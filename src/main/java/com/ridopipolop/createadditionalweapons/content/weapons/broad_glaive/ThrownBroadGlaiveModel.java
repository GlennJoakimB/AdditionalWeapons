package com.ridopipolop.createadditionalweapons.content.weapons.broad_glaive;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.ridopipolop.createadditionalweapons.CreateAdditionalWeapons;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

// Made with Blockbench 4.10.4
public class ThrownBroadGlaiveModel extends Model {
  // private final ModelPart Cog;

  public static final ResourceLocation TEXTURE = new ResourceLocation(
      CreateAdditionalWeapons.MOD_ID, "textures/entity/broad_glaive_entity.png");
  private final ModelPart root;

  public ThrownBroadGlaiveModel(ModelPart root) {
    super(RenderType::entitySolid);
    this.root = root;
    // this.Cog = root.getChild("Cog");
  }

  public static LayerDefinition getTexturedModelData() {
    MeshDefinition meshDefinition = new MeshDefinition();
    PartDefinition modelPartData = meshDefinition.getRoot();
    modelPartData.addOrReplaceChild("Blade", CubeListBuilder.create()
        .texOffs(4, 0).addBox(-0.25F, -7.5F, -1.5F, 0.5F, 9.5F, 3.0F)
        .texOffs(4, 13).addBox(-0.75F, -0.5F, -0.75F, 1.5F, 2.5F, 1.5F)
        .texOffs(11, 5).addBox(-1.0F, 2.0F, -1.75F, 2.0F, 1.0F, 3.5F),
        PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

    PartDefinition Cog = modelPartData.addOrReplaceChild("Cog",
        CubeListBuilder.create().texOffs(11, 3).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F),
        PartPose.offset(0.0F, 7.5F, 0.0F));
    Cog.addOrReplaceChild("Cog_r1",
        CubeListBuilder.create().texOffs(11, 3).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F),
        PartPose.rotation(0.0F, 2.3562F, 0.0F));
    Cog.addOrReplaceChild("Cog_r2",
        CubeListBuilder.create().texOffs(11, 3).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F),
        PartPose.rotation(0.0F, 1.5708F, 0.0F));
    Cog.addOrReplaceChild("Cog_r3",
        CubeListBuilder.create().texOffs(11, 3).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F),
        PartPose.rotation(0.0F, 0.7854F, 0.0F));

    PartDefinition Handle = modelPartData.addOrReplaceChild("Handle",
        CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -10.0F, -0.5F, 1.0F, 16.0F, 1.0F),
        PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
    Handle.addOrReplaceChild("SideHandle_r1",
        CubeListBuilder.create().texOffs(11, 10).addBox(-0.7F, -3.0F, -0.75F, 1.0F, 6.0F, 1.0F),
        PartPose.offsetAndRotation(-0.05F, -7.0F, -0.5F, 0.0F, -0.7854F, 0.0F));
    Handle.addOrReplaceChild("HandleBracket_r1", CubeListBuilder.create()
        .texOffs(8, 0).addBox(-1.35F, 2.25F, -1.35F, 2.0F, 1.0F, 2.0F)
        .texOffs(8, 0).addBox(-1.35F, -4.75F, -1.35F, 2.0F, 1.0F, 2.0F),
        PartPose.offsetAndRotation(0.0F, -6.25F, 0.1F, 0.0F, -0.7854F, 0.0F));

    return LayerDefinition.create(meshDefinition, 32, 32);
  }

  public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red,
      float green, float blue, float alpha) {
    this.root.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
  }

  // @Override
  // public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount,
  // float ageInTicks, float netHeadYaw,
  // float headPitch) {
  // // TODO: Add animation of gear?
  // }
}