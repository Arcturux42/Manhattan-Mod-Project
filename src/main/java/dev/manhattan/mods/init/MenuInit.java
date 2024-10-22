package dev.manhattan.mods.init;

import dev.manhattan.mods.Mods;
import dev.manhattan.mods.menu.ChemicalLeachingMachineContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuInit {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Mods.MODID);

    public static final RegistryObject<MenuType<ChemicalLeachingMachineContainerMenu>> CHEMICAL_LEACHING_MACHINE_MENU =
            MENU_TYPES.register("chemical_leaching_machine_menu",
                    () -> IForgeMenuType.create((ChemicalLeachingMachineContainerMenu::new)));
}
