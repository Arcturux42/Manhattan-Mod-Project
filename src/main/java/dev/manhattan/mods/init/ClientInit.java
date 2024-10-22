package dev.manhattan.mods.init;

import dev.manhattan.mods.Mods;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import dev.manhattan.mods.client.screen.ChemicalLeachingMachineScreen;

// Client-side configuration class for initializing interfaces and screens.
@Mod.EventBusSubscriber(modid = Mods.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientInit {

    // Method called to register client-related events.
    public static void register(IEventBus modEventBus) {
        // Adds a listener for the client setup event.
        modEventBus.addListener(ClientInit::onClientSetup);
    }

    // This method only runs on the client side to initialize the graphical interface.
    @OnlyIn(Dist.CLIENT)
    private static void onClientSetup(final FMLClientSetupEvent event) {
        // Associates the "Chemical Leaching Machine" menu with the corresponding screen.
        MenuScreens.register(MenuInit.CHEMICAL_LEACHING_MACHINE_MENU.get(), ChemicalLeachingMachineScreen::new);
    }
}
