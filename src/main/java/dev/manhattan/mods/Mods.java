package dev.manhattan.mods;

import dev.manhattan.mods.init.*;
import dev.manhattan.mods.network.ModsNetwork;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Mods.MODID) // Annotation that defines this class as a Minecraft mod with the specified ID
public class Mods {
    public static final String MODID = "manhattan"; // Unique identifier for the mod

    public Mods() {
        // Registers setup events for the mod
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup); // Registers the setup method for common events
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup); // Registers the setup method for client events

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus(); // Retrieves the mod event bus

        // Registers various elements of the mod with the event bus
        ItemsInit.ITEMS.register(bus); // Registers the items
        BlocksInit.BLOCKS.register(bus); // Registers the blocks
        CreativeTabInit.TABS.register(bus); // Registers the creative tabs
        BlockEntityInit.BLOCK_ENTITIES.register(bus); // Registers the block entities
        EntitiesInit.ENTITIES.register(bus); // Registers the type of entities
        MenuInit.MENU_TYPES.register(bus); // Registers the menu types
        ClientInit.register(bus); // Registers client-side initializations
        FluidsInit.FLUID_TYPES.register(bus); // Registers the fluids type
        FluidsInit.FLUIDS.register(bus);    // Registers the fluids
        MinecraftForge.EVENT_BUS.register(CreativeTabInit.class); // Registers creative tab events in the Forge event bus
    }

    // Common setup method called during mod initialization
    private void setup(FMLCommonSetupEvent e) {
        // Registers network packets here
        e.enqueueWork(ModsNetwork::registerPackets); // Enqueues the packet registration method for execution on the main thread
    }

    // Client setup method called during client initialization
    private void clientSetup(FMLClientSetupEvent e) {
        // Client-specific initialization can be added here
    }
}
