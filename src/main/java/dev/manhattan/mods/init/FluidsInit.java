package dev.manhattan.mods.init;

// Importing necessary classes for fluid and item registration
import dev.manhattan.mods.Mods;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import dev.manhattan.mods.base.FluidRegistryContainer;

// Class that initializes fluids in the mod
public class FluidsInit {
    // Creating a deferred register for fluids, linked to the mod ID
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Mods.MODID);
    // Creating a deferred register for fluid types, linked to the mod ID
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Mods.MODID);

    // Registering a fluid called sulfuric acid with its properties
    public static final FluidRegistryContainer SULFURIC_ACID = new FluidRegistryContainer("sulfuric_acid",
            FluidType.Properties.create()
                    .canSwim(true)  // Players can swim in this fluid
                    .canDrown(true) // Players can drown in this fluid
                    .viscosity(100) // The viscosity of the fluid
                    .density(100)   // The density of the fluid
                    .supportsBoating(true), // Players can use boats on this fluid
            () -> FluidRegistryContainer.createExtension(new FluidRegistryContainer.ClientExtensions(Mods.MODID, "sulfuric_acid")
                    .tint(0x7AF202) // Color tint for the fluid
                    .fogColor(0.478f, 0.949f, 0.008f) // Fog color when viewed in the fluid
            ),
            BlockBehaviour.Properties.copy(Blocks.WATER), // Properties copied from water for block behavior
            new Item.Properties().stacksTo(1) // The item can only stack to one
    );
}
