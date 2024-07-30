package com.ridopipolop.createadditionalweapons.entity;

import org.jetbrains.annotations.Nullable;

import com.ridopipolop.createadditionalweapons.item.ModEntityTypes;
import com.ridopipolop.createadditionalweapons.item.ModItems;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class ThrownBroadGlaive extends AbstractArrow {
  private static final EntityDataAccessor<Byte> ID_LOYALTY;
  private static final EntityDataAccessor<Boolean> ID_FOIL;
  private ItemStack broadGlaiveItem;
  private boolean dealtDamage;
  public int clientSideReturnTridentTickCount;

  public ThrownBroadGlaive(EntityType<? extends ThrownBroadGlaive> entityType, Level level) {
    super(entityType, level);
    this.broadGlaiveItem = new ItemStack(ModItems.BROAD_GLAIVE);
  }

  public ThrownBroadGlaive(Level level, LivingEntity shooter, ItemStack stack) {
    super(ModEntityTypes.THROWN_BROAD_GLAIVE, shooter, level);

    this.broadGlaiveItem = new ItemStack(ModItems.BROAD_GLAIVE);
    this.broadGlaiveItem = stack.copy();
    this.entityData.set(ID_LOYALTY, (byte) EnchantmentHelper.getLoyalty(stack));
    this.entityData.set(ID_FOIL, stack.hasFoil());
  }

  protected void defineSynchedData() {
    super.defineSynchedData();
    this.entityData.define(ID_LOYALTY, (byte) 0);
    this.entityData.define(ID_FOIL, false);
  }

  @SuppressWarnings("resource")
  public void tick() {
    if (this.inGroundTime > 4) {
      this.dealtDamage = true;
    }

    Entity entity = this.getOwner();
    int i = (Byte) this.entityData.get(ID_LOYALTY);
    if (i > 0 && (this.dealtDamage || this.isNoPhysics()) && entity != null) {
      if (!this.isAcceptibleReturnOwner()) {
        if (!this.level().isClientSide && this.pickup == Pickup.ALLOWED) {
          this.spawnAtLocation(this.getPickupItem(), 0.1F);
        }

        this.discard();
      } else {
        this.setNoPhysics(true);
        Vec3 vec3 = entity.getEyePosition().subtract(this.position());
        this.setPosRaw(this.getX(), this.getY() + vec3.y * 0.015 * (double) i, this.getZ());
        if (this.level().isClientSide) {
          this.yOld = this.getY();
        }

        double d = 0.05 * (double) i;
        this.setDeltaMovement(this.getDeltaMovement().scale(0.95).add(vec3.normalize().scale(d)));
        if (this.clientSideReturnTridentTickCount == 0) {
          this.playSound(SoundEvents.TRIDENT_RETURN, 10.0F, 1.0F);
        }

        ++this.clientSideReturnTridentTickCount;
      }
    }

    super.tick();
  }

  private boolean isAcceptibleReturnOwner() {
    Entity entity = this.getOwner();
    if (entity != null && entity.isAlive()) {
      return !(entity instanceof ServerPlayer) || !entity.isSpectator();
    } else {
      return false;
    }
  }

  protected ItemStack getPickupItem() {
    return this.broadGlaiveItem.copy();
  }

  public boolean isFoil() {
    return (Boolean) this.entityData.get(ID_FOIL);
  }

  @Nullable
  protected EntityHitResult findHitEntity(Vec3 startVec, Vec3 endVec) {
    return this.dealtDamage ? null : super.findHitEntity(startVec, endVec);
  }

  protected void onHitEntity(EntityHitResult result) {
    Entity entity = result.getEntity();
    float f = 8.0F;
    if (entity instanceof LivingEntity livingEntity) {
      f += EnchantmentHelper.getDamageBonus(this.broadGlaiveItem, livingEntity.getMobType());
    }

    Entity entity2 = this.getOwner();
    DamageSource damageSource = this.damageSources().trident(this, (Entity) (entity2 == null ? this : entity2));
    this.dealtDamage = true;
    SoundEvent soundEvent = SoundEvents.TRIDENT_HIT;
    if (entity.hurt(damageSource, f)) {
      if (entity.getType() == EntityType.ENDERMAN) {
        return;
      }

      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity2 = (LivingEntity) entity;
        if (entity2 instanceof LivingEntity) {
          EnchantmentHelper.doPostHurtEffects(livingEntity2, entity2);
          EnchantmentHelper.doPostDamageEffects((LivingEntity) entity2, livingEntity2);
        }

        this.doPostHurtEffects(livingEntity2);
      }
    }

    this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01, -0.1, -0.01));
    float g = 1.0F;
    if (this.level() instanceof ServerLevel && this.level().isThundering() && this.isChanneling()) {
      BlockPos blockPos = entity.blockPosition();
      if (this.level().canSeeSky(blockPos)) {
        LightningBolt lightningBolt = (LightningBolt) EntityType.LIGHTNING_BOLT.create(this.level());
        if (lightningBolt != null) {
          lightningBolt.moveTo(Vec3.atBottomCenterOf(blockPos));
          lightningBolt.setCause(entity2 instanceof ServerPlayer ? (ServerPlayer) entity2 : null);
          this.level().addFreshEntity(lightningBolt);
          soundEvent = SoundEvents.TRIDENT_THUNDER;
          g = 5.0F;
        }
      }
    }

    this.playSound(soundEvent, g, 1.0F);
  }

  public boolean isChanneling() {
    return EnchantmentHelper.hasChanneling(this.broadGlaiveItem);
  }

  protected boolean tryPickup(Player player) {
    return super.tryPickup(player)
        || this.isNoPhysics() && this.ownedBy(player) && player.getInventory().add(this.getPickupItem());
  }

  protected SoundEvent getDefaultHitGroundSoundEvent() {
    return SoundEvents.TRIDENT_HIT_GROUND;
  }

  public void playerTouch(Player player) {
    if (this.ownedBy(player) || this.getOwner() == null) {
      super.playerTouch(player);
    }

  }

  public void readAdditionalSaveData(CompoundTag compound) {
    super.readAdditionalSaveData(compound);
    if (compound.contains("Trident", 10)) {
      this.broadGlaiveItem = ItemStack.of(compound.getCompound("Trident"));
    }

    this.dealtDamage = compound.getBoolean("DealtDamage");
    this.entityData.set(ID_LOYALTY, (byte) EnchantmentHelper.getLoyalty(this.broadGlaiveItem));
  }

  public void addAdditionalSaveData(CompoundTag compound) {
    super.addAdditionalSaveData(compound);
    compound.put("Trident", this.broadGlaiveItem.save(new CompoundTag()));
    compound.putBoolean("DealtDamage", this.dealtDamage);
  }

  public void tickDespawn() {
    int i = (Byte) this.entityData.get(ID_LOYALTY);
    if (this.pickup != Pickup.ALLOWED || i <= 0) {
      super.tickDespawn();
    }
  }

  public static FabricEntityTypeBuilder<?> build(FabricEntityTypeBuilder<?> builder) {
    return builder.dimensions(EntityDimensions.fixed(0.25f, 0.25f));
  }

  protected float getWaterInertia() {
    return 0.6F;
  }

  public boolean shouldRender(double x, double y, double z) {
    return true;
  }

  static {
    ID_LOYALTY = SynchedEntityData.defineId(ThrownTrident.class, EntityDataSerializers.BYTE);
    ID_FOIL = SynchedEntityData.defineId(ThrownTrident.class, EntityDataSerializers.BOOLEAN);
  }
}
