package com.ridopipolop.createadditionalweapons.content.weapons.broad_glaive;

import java.util.UUID;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import com.ridopipolop.createadditionalweapons.item.ModItems;

import io.github.fabricators_of_create.porting_lib.entity.events.LivingEntityEvents.LivingTickEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;

public class BroadGlaiveItem extends TridentItem {

  // Added custom UUID, hope it works
  public static final AttributeModifier rangeAttributeModifier = new AttributeModifier(
      UUID.fromString("ffe07123-760f-4174-9340-cf290be36139"), "Range modifier", 1.2,
      AttributeModifier.Operation.ADDITION);

  private static final Supplier<Multimap<Attribute, AttributeModifier>> rangeModifier = Suppliers
      .memoize(() -> ImmutableMultimap.of(
          ReachEntityAttributes.ATTACK_RANGE, rangeAttributeModifier));

  public static final String GLAIVE_MARKER = "moddedBroadGlaive";

  // Constructor
  public BroadGlaiveItem(Properties properties) {
    super(properties);
  }

  // --- Attribute-logic ---
  public static void holdingGlaiveIncreasesRange(LivingTickEvent ent) {
    LivingEntity entity = ent.getEntity();
    if (!(entity instanceof Player))
      return;

    Player player = (Player) entity;

    CompoundTag persistentData = player.getCustomData();
    boolean holdinginMainHand = ModItems.BROAD_GLAIVE.isIn(player.getMainHandItem());
    boolean wasHolding = persistentData.contains(GLAIVE_MARKER);

    if (holdinginMainHand != wasHolding) {
      if (!holdinginMainHand) {
        player.getAttributes().removeAttributeModifiers(rangeModifier.get());
        persistentData.remove(GLAIVE_MARKER);
      } else {
        player.getAttributes().addTransientAttributeModifiers(rangeModifier.get());
        persistentData.putBoolean(GLAIVE_MARKER, true);
      }
    }
  }

  public static void addRangeToJoiningPlayersHoldingGlaive(Entity entity, @Nullable CompoundTag persistentData) {
    if (!(entity instanceof Player player) || persistentData == null)
      return;

    if (persistentData.contains(GLAIVE_MARKER))
      player.getAttributes().addTransientAttributeModifiers(rangeModifier.get());
  }
}
