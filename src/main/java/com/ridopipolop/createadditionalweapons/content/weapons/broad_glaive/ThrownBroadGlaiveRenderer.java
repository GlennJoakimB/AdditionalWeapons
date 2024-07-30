package com.ridopipolop.createadditionalweapons.content.weapons.broad_glaive;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.ridopipolop.createadditionalweapons.CreateAdditionalWeapons;
import com.ridopipolop.createadditionalweapons.client.CreateAdditionalWeaponsClient;
import com.ridopipolop.createadditionalweapons.entity.ThrownBroadGlaive;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ThrownBroadGlaiveRenderer extends EntityRenderer<ThrownBroadGlaive> {
  public static final ResourceLocation BROAD_GLAIVE_LOCATION = new ResourceLocation(
      CreateAdditionalWeapons.MOD_ID, "textures/entity/broad_glaive_entity.png");
  private final ThrownBroadGlaiveModel model;

  public ThrownBroadGlaiveRenderer(EntityRendererProvider.Context context) {
    super(context);
    this.model = new ThrownBroadGlaiveModel(context.bakeLayer(CreateAdditionalWeaponsClient.THROWN_BROAD_GLAIVE));
  }

  @Override
  public void render(ThrownBroadGlaive entity, float yaw, float partialTicks, PoseStack poseStack,
      MultiBufferSource buffer, int light) {
    poseStack.pushPose();
    poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot()) - 90.0F));
    poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.xRotO, entity.getXRot()) + 90.0F));
    VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(buffer,
        this.model.renderType(this.getTextureLocation(entity)), false, entity.isFoil());
    this.model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    poseStack.popPose();
    super.render(entity, yaw, partialTicks, poseStack, buffer, light);
  }

  @Override
  public ResourceLocation getTextureLocation(ThrownBroadGlaive entity) {
    return BROAD_GLAIVE_LOCATION;
  }
}
