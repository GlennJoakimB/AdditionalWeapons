package assets.createadditionalweapons.models.item.broad_glaive;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

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
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ThrownBroadGlaiveModel extends Model {// EntityModel<ThrownBroadGlaive> {
  // private final ModelPart Blade;
  // private final ModelPart Cog;
  // private final ModelPart Handle;
  public static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/broad_glaive_entity.png");
  private final ModelPart root;

  public ThrownBroadGlaiveModel(ModelPart root) {
    super(RenderType::entitySolid);
    this.root = root;
    // this.Blade = root.getChild("Blade");
    // this.Cog = root.getChild("Cog");
    // this.Handle = root.getChild("Handle");
  }

  public static LayerDefinition getTexturedModelData() {
    MeshDefinition meshDefinition = new MeshDefinition();
    PartDefinition modelPartData = meshDefinition.getRoot();
    modelPartData.addOrReplaceChild("Blade", CubeListBuilder.create()
        .texOffs(4, 0).addBox(-0.75F, -5.5F, -1.25F, 0.5F, 9.5F, 3.0F)
        .texOffs(4, 13).addBox(-1.25F, 1.5F, -0.5F, 1.5F, 2.5F, 1.5F)
        .texOffs(11, 5).addBox(-1.5F, 4.0F, -1.5F, 2.0F, 1.0F, 3.5F),
        PartPose.rotation(0.5F, 7.0F, -0.25F));

    PartDefinition Cog = modelPartData.addOrReplaceChild("Cog",
        CubeListBuilder.create().texOffs(11, 3).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F),
        PartPose.rotation(0.0F, 12.5F, 0.0F));
    Cog.addOrReplaceChild("Cog_r1",
        CubeListBuilder.create().texOffs(11, 3).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F),
        PartPose.rotation(0.0F, 2.3562F, 0.0F));
    Cog.addOrReplaceChild("Cog_r2",
        CubeListBuilder.create().texOffs(11, 3).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F),
        PartPose.rotation(0.0F, 1.5708F, 0.0F));
    Cog.addOrReplaceChild("Cog_r3",
        CubeListBuilder.create().texOffs(11, 3).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F),
        PartPose.rotation(0.0F, 0.7854F, 0.0F));

    PartDefinition Handle = modelPartData.addOrReplaceChild("Handle", CubeListBuilder.create()
        .texOffs(0, 0).addBox(-0.5F, -10.0F, -0.5F, 1.0F, 16.0F, 1.0F), PartPose.rotation(0, 24.0F, 0));
    Handle.addOrReplaceChild("SideHandle_r1",
        CubeListBuilder.create().texOffs(11, 10).addBox(-0.7F, -3.0F, -0.75F, 1.0F, 6.0F, 1.0F),
        PartPose.offsetAndRotation(-0.05F, -7.0F, -0.5F, 0.0F, -0.7854F, 0.0F));
    Handle.addOrReplaceChild("HandleBracket_r1", CubeListBuilder.create()
        .texOffs(8, 0).addBox(-1.35F, 2.25F, -1.35F, 2.0F, 1.0F, 2.0F)
        .texOffs(8, 0).addBox(-1.35F, -4.75F, -1.35F, 2.0F, 1.0F, 2.0F),
        PartPose.offsetAndRotation(0.0F, -6.25F, 0.1F, 0.0F, -0.7854F, 0.0F));

    return LayerDefinition.create(meshDefinition, 64, 64);
  }
  // ModelData modelData = new ModelData();
  // ModelPartData modelPartData = modelData.getRoot();
  // ModelPartData Blade = modelPartData.addChild("Blade",
  // ModelPartBuilder.create().uv(4, 0).cuboid(-0.75F, -5.5F, -1.25F, 0.5F, 9.5F,
  // 3.0F, new Dilation(0.0F))
  // .uv(4, 13).cuboid(-1.25F, 1.5F, -0.5F, 1.5F, 2.5F, 1.5F, new Dilation(0.0F))
  // .uv(11, 5).cuboid(-1.5F, 4.0F, -1.5F, 2.0F, 1.0F, 3.5F, new Dilation(0.0F)),
  // ModelTransform.pivot(0.5F, 7.0F, -0.25F));

  // ModelPartData Cog = modelPartData.addChild("Cog",
  // ModelPartBuilder.create().uv(11, 3).cuboid(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F,
  // 1.0F, new Dilation(0.0F)),
  // ModelTransform.pivot(0.0F, 12.5F, 0.0F));

  // ModelPartData Cog_r1 = Cog.addChild("Cog_r1",
  // ModelPartBuilder.create().uv(11, 3).cuboid(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F,
  // 1.0F, new Dilation(0.0F)),
  // ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 2.3562F, 0.0F));

  // ModelPartData Cog_r2 = Cog.addChild("Cog_r2",
  // ModelPartBuilder.create().uv(11, 3).cuboid(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F,
  // 1.0F, new Dilation(0.0F)),
  // ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

  // ModelPartData Cog_r3 = Cog.addChild("Cog_r3",
  // ModelPartBuilder.create().uv(11, 3).cuboid(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F,
  // 1.0F, new Dilation(0.0F)),
  // ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

  // ModelPartData Handle = modelPartData.addChild("Handle",
  // ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -10.0F, -0.5F, 1.0F, 16.0F,
  // 1.0F, new Dilation(0.0F)),
  // ModelTransform.pivot(0.0F, 24.0F, 0.0F));

  // ModelPartData SideHandle_r1 = Handle.addChild("SideHandle_r1",
  // ModelPartBuilder.create().uv(11, 10).cuboid(-0.7F, -3.0F, -0.75F, 1.0F, 6.0F,
  // 1.0F, new Dilation(0.0F)),
  // ModelTransform.of(-0.05F, -7.0F, -0.5F, 0.0F, -0.7854F, 0.0F));

  // ModelPartData HandleBracket_r1 = Handle.addChild("HandleBracket_r1",
  // ModelPartBuilder.create().uv(8, 0).cuboid(-1.35F, 2.25F, -1.35F, 2.0F, 1.0F,
  // 2.0F, new Dilation(0.0F))
  // .uv(8, 0).cuboid(-1.35F, -4.75F, -1.35F, 2.0F, 1.0F, 2.0F, new
  // Dilation(0.0F)),
  // ModelTransform.of(0.0F, -6.25F, 0.1F, 0.0F, -0.7854F, 0.0F));
  // return TexturedModelData.of(modelData, 32, 32);
  // }

  // @Override
  // public void setAngles(Entity entity, float limbSwing, float limbSwingAmount,
  // float ageInTicks, float netHeadYaw,
  // float headPitch) {

  // }

  // @Override
  // public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int
  // light, int overlay, float red,
  // float green, float blue, float alpha) {
  // Blade.render(matrices, vertexConsumer, light, overlay, red, green, blue,
  // alpha);
  // Cog.render(matrices, vertexConsumer, light, overlay, red, green, blue,
  // alpha);
  // Handle.render(matrices, vertexConsumer, light, overlay, red, green, blue,
  // alpha);
  // }

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