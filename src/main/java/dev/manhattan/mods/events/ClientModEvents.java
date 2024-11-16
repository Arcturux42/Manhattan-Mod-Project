package dev.manhattan.mods.events;

// Imports for custom entity rendering and model setup
import dev.manhattan.mods.Mods;
import dev.manhattan.mods.client.model.NuclebugEntityModel;
import dev.manhattan.mods.client.renderer.NuclebugEntityRenderer;
import dev.manhattan.mods.init.EntitiesInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// Event handler class for client-side mod events
@Mod.EventBusSubscriber(modid = Mods.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    // Event to register custom renderers for entities
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(
                EntitiesInit.NUCLEBUG_ENTITY.get(), // The entity to assign a renderer
                NuclebugEntityRenderer::new         // Custom renderer for the entity
        );
    }

    // Event to register custom layer definitions for entity models
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(
                NuclebugEntityModel.LAYER_LOCATION, // Location for the model's layer
                NuclebugEntityModel::createBodyLayer // Method to define the body layer
        );
    }
}
