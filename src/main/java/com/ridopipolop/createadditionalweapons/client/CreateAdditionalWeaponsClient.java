package com.ridopipolop.createadditionalweapons.client;

import com.ridopipolop.createadditionalweapons.CreateAdditionalWeapons;
import com.ridopipolop.createadditionalweapons.content.weapons.broad_glaive.ThrownBroadGlaiveModel;
import com.ridopipolop.createadditionalweapons.content.weapons.broad_glaive.ThrownBroadGlaiveRenderer;
import com.ridopipolop.createadditionalweapons.item.ModEntityTypes;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class CreateAdditionalWeaponsClient implements ClientModInitializer {

  public static final ModelLayerLocation THROWN_BROAD_GLAIVE = new ModelLayerLocation(
      new ResourceLocation(CreateAdditionalWeapons.MOD_ID, "broad_glaive"), "main");

  @Override
  public void onInitializeClient() {
    EntityRendererRegistry.register(ModEntityTypes.THROWN_BROAD_GLAIVE, (context) -> {
      return new ThrownBroadGlaiveRenderer(context);
    });

    EntityModelLayerRegistry.registerModelLayer(THROWN_BROAD_GLAIVE, ThrownBroadGlaiveModel::getTexturedModelData);
  }
}
