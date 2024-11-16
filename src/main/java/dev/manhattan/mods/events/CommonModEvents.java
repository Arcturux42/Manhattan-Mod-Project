package dev.manhattan.mods.events;

// Imports for entity attributes and spawn placement registration
import dev.manhattan.mods.Mods;
import dev.manhattan.mods.entity.NuclebugEntity;
import dev.manhattan.mods.init.EntitiesInit;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// Event handler class for common mod events
@Mod.EventBusSubscriber(modid = Mods.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {

    // Event to register custom entity attributes (e.g., health, speed, etc.)
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntitiesInit.NUCLEBUG_ENTITY.get(), NuclebugEntity.createAttributes().build());
    }

    // Event to register custom spawn placements for the entity
    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(
                EntitiesInit.NUCLEBUG_ENTITY.get(),                 // The entity to register spawn rules for
                SpawnPlacements.Type.ON_GROUND,                     // Spawn type (on ground)
                Heightmap.Types.WORLD_SURFACE,                      // Heightmap used for placement
                NuclebugEntity::canSpaw,                            // Predicate to check if spawning is allowed
                SpawnPlacementRegisterEvent.Operation.AND           // Combining this with other spawn rules
        );
    }
}
