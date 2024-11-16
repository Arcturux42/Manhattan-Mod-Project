package dev.manhattan.mods.client.renderer;

// Imports for custom entity rendering
import dev.manhattan.mods.Mods;
import dev.manhattan.mods.client.model.NuclebugEntityModel;
import dev.manhattan.mods.entity.NuclebugEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

// Renderer class for the "Nuclebug" entity
public class NuclebugEntityRenderer extends MobRenderer<NuclebugEntity, NuclebugEntityModel<NuclebugEntity>> {

    // Path to the texture file for the entity
    public static final ResourceLocation TEXTURE = new ResourceLocation(Mods.MODID, "textures/entity/nuclebug_entity.png");

    // Constructor initializing the renderer with the entity's model and shadow size
    public NuclebugEntityRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new NuclebugEntityModel(ctx.bakeLayer(NuclebugEntityModel.LAYER_LOCATION)), 1.0f);
    }

    // Returns the texture location for the entity
    @Override
    public ResourceLocation getTextureLocation(NuclebugEntity entity) {
        return TEXTURE;
    }
}
