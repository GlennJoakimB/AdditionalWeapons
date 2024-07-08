package com.ridopipolop.createadditionalweapons.item;

import static com.ridopipolop.createadditionalweapons.CreateAdditionalWeapons.REGISTRATE;

import com.ridopipolop.createadditionalweapons.CreateAdditionalWeapons;
import com.simibubi.create.foundation.utility.Components;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
  
  public static final ResourceKey<CreativeModeTab> MAIN_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, CreateAdditionalWeapons.id("main"));
  public static final CreativeModeTab MAIN_TAB = FabricItemGroup.builder()
    .icon(() -> new ItemStack(ModItems.GOLDEN_DUCK))
    .title(Components.translatable("itemGroup.createadditionalweapons.main"))
    .build();
    
  public static void registerItemGroups() {
    CreateAdditionalWeapons.LOGGER.info("Registering Item Groups for [{}].", CreateAdditionalWeapons.NAME);
    Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MAIN_KEY, MAIN_TAB);

    ItemGroupEvents.modifyEntriesEvent(MAIN_KEY).register(content -> {
      REGISTRATE.getAll(Registries.ITEM).forEach(entry -> {
        content.accept(entry.get());
      });
    });
  }
}
