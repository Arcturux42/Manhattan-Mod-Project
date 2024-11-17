package dev.manhattan.mods.init;

// Necessary imports for declaring and registering entities in Minecraft
import dev.manhattan.mods.Mods;
import dev.manhattan.mods.entity.NuclebugEntity;
import dev.manhattan.mods.entity.RochaneEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// Class for managing entities in the mod
public class EntitiesInit {

    // Deferred register to handle the registration of the mod's entity types
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Mods.MODID);

    // Registry object for the custom entity "NuclebugEntity"
    public static final RegistryObject<EntityType<NuclebugEntity>> NUCLEBUG_ENTITY = ENTITIES.register("nuclebug_entity",
            () -> EntityType.Builder.<NuclebugEntity>of(NuclebugEntity::new, MobCategory.CREATURE) // Define the entity type as a creature
                    .sized(1.0f, 1.0f) // Set the entity's hitbox size
                    .build(new ResourceLocation(Mods.MODID, "nuclebug_entity").toString()) // Build the entity with a unique resource location
    );

    // Registry object for the custom entity "Rochane
    public static final RegistryObject<EntityType<RochaneEntity>> ROCHANE_ENTITY = ENTITIES.register("rochane_entity",
            () -> EntityType.Builder.<RochaneEntity>of(RochaneEntity::new, MobCategory.MONSTER)
                    .sized(2.0f, 2.0f)
                    .build(new ResourceLocation(Mods.MODID, "rochane_entity"))
    );
}
