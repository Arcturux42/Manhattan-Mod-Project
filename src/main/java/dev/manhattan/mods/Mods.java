package dev.manhattan.mods;

import dev.manhattan.mods.init.ItemsInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Mods.MODID)
public class Mods {
    public static final String MODID = "manhattan";

    public Mods() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemsInit.ITEMS.register(bus);
    }

    private void setup(FMLClientSetupEvent e) {

    }

    private void clientSetup(FMLClientSetupEvent e) {

    }
}
