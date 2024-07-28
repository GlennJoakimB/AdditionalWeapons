package com.ridopipolop.createadditionalweapons.item;

import com.ridopipolop.createadditionalweapons.CreateAdditionalWeapons;
import com.ridopipolop.createadditionalweapons.entity.ThrownBroadGlaive;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntityTypes {
  public static final EntityType<ThrownBroadGlaive> THROWN_BROAD_GLAIVE = register("thrown_broad_glaive",
      createEntityType(ThrownBroadGlaive::new));

  private static <T extends Entity> EntityType<T> register(String key, EntityType<T> entity) {
    return Registry.register(BuiltInRegistries.ENTITY_TYPE, CreateAdditionalWeapons.MOD_ID + ":" + key, entity);
  }

  private static <T extends Entity> EntityType<T> createEntityType(EntityType.EntityFactory<T> factory) {
    return FabricEntityTypeBuilder.create(MobCategory.MISC, factory)
        .dimensions(EntityDimensions.scalable(0.5f, 0.5f))
        .trackRangeBlocks(4).trackedUpdateRate(20).build();
  }

  public static void register() {
    CreateAdditionalWeapons.LOGGER.info("Registiring entities for {}.", CreateAdditionalWeapons.NAME);
  }
}
