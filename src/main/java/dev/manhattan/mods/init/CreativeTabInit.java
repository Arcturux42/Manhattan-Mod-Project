package dev.manhattan.mods.init;

import dev.manhattan.mods.Mods;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Mods.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mods.MODID);
    public static final List<Supplier<? extends ItemLike>> MANHATTAN_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> MANHATTAN_TAB = TABS.register("manhattan_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.manhattan.manhattan_tab"))
                    .icon(ItemsInit.URANIUM_BLOCK_ITEM.get()::getDefaultInstance)
                    .displayItems((displayParams, output) ->
                            MANHATTAN_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get()))
                    )
                    .withSearchBar(80)
                    .build()
    );

    private static void addToTabs(BuildCreativeModeTabContentsEvent event, ResourceKey<CreativeModeTab> tab, ItemLike afterItem, Supplier<? extends Item> item, boolean placeAfter) {
        if (event.getTabKey().equals(tab)) {
            ItemStack afterItemStack = afterItem != null ? new ItemStack(afterItem.asItem()) : ItemStack.EMPTY; // Gérer le cas où afterItem est null
            ItemStack itemStack = item.get().getDefaultInstance();

            if (placeAfter && afterItem != null) {
                // Ajoute l'item après afterItem seulement si afterItem n'est pas null
                event.getEntries().putAfter(afterItemStack, itemStack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            } else {
                // Ajoute l'item sans se soucier de l'ordre
                event.getEntries().put(itemStack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
    }


    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        // MANHATTAN
        if (event.getTabKey().equals(MANHATTAN_TAB.getKey())) {
            // BUILDING_BLOCKS
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.URANIUM_BLOCK_ITEM, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.CARBON_BLOCK_ITEM, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.LEAD_BLOCK_ITEM, false);

            // FOOD_AND_DRINKS
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.CHEESE, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.CHOCOLATE, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.SLICE_OF_PIZZA, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.PIZZA, false);

            // Ingredients
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.LEAD_INGOT, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.URANIUM_RAW, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.URANIUM_INGOT, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.YELLOWCAKE, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.FLOUR, false);

            // NATURAL_BLOCKS
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.URANIUM_ORE_ITEM, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.DEEPSLATE_URANIUM_ORE_ITEM, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.LEAD_ORE_ITEM, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.DEEPSLATE_LEAD_ORE_ITEM, false);

            // COMBAT
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.LEAD_SWORD, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.LEAD_BOOTS, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.LEAD_LEGGINGS, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.LEAD_HELMET, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.LEAD_CHESTPLATE, false);

            // TOOLS_AND_UTILITIES
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.LEAD_HOE, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.LEAD_AXE, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.LEAD_PICKAXE, false);
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.LEAD_SHOVEL, false);

            // Functional block
            addToTabs(event, MANHATTAN_TAB.getKey(), null, ItemsInit.CHEMICAL_LEACHING_MACHINE_ITEM, false);
        }

        // BUILDING_BLOCKS
        addToTabs(event, CreativeModeTabs.BUILDING_BLOCKS, Items.BASALT, ItemsInit.URANIUM_BLOCK_ITEM, true);
        addToTabs(event, CreativeModeTabs.BUILDING_BLOCKS, Items.BASALT, ItemsInit.CARBON_BLOCK_ITEM, true);
        addToTabs(event, CreativeModeTabs.BUILDING_BLOCKS, Items.BASALT, ItemsInit.LEAD_BLOCK_ITEM, true);

        // FOOD_AND_DRINKS
        addToTabs(event, CreativeModeTabs.FOOD_AND_DRINKS, Items.PUMPKIN_PIE, ItemsInit.CHEESE, true);
        addToTabs(event, CreativeModeTabs.FOOD_AND_DRINKS, Items.PUMPKIN_PIE, ItemsInit.CHOCOLATE, true);
        addToTabs(event, CreativeModeTabs.FOOD_AND_DRINKS, Items.PUMPKIN_PIE, ItemsInit.SLICE_OF_PIZZA, true);
        addToTabs(event, CreativeModeTabs.FOOD_AND_DRINKS, Items.PUMPKIN_PIE, ItemsInit.PIZZA, true);

        // NATURAL_BLOCKS
        addToTabs(event, CreativeModeTabs.NATURAL_BLOCKS, Items.NETHER_QUARTZ_ORE, ItemsInit.URANIUM_ORE_ITEM, true);
        addToTabs(event, CreativeModeTabs.NATURAL_BLOCKS, Items.NETHER_QUARTZ_ORE, ItemsInit.DEEPSLATE_URANIUM_ORE_ITEM, true);
        addToTabs(event, CreativeModeTabs.NATURAL_BLOCKS, Items.NETHER_QUARTZ_ORE, ItemsInit.LEAD_ORE_ITEM, true);
        addToTabs(event, CreativeModeTabs.NATURAL_BLOCKS, Items.NETHER_QUARTZ_ORE, ItemsInit.DEEPSLATE_LEAD_ORE_ITEM, true);

        // COMBAT
        addToTabs(event, CreativeModeTabs.COMBAT, Items.NETHERITE_SWORD, ItemsInit.LEAD_SWORD, true);
        addToTabs(event, CreativeModeTabs.COMBAT, Items.NETHERITE_BOOTS, ItemsInit.LEAD_BOOTS, true);
        addToTabs(event, CreativeModeTabs.COMBAT, Items.NETHERITE_BOOTS, ItemsInit.LEAD_LEGGINGS, true);
        addToTabs(event, CreativeModeTabs.COMBAT, Items.NETHERITE_BOOTS, ItemsInit.LEAD_HELMET, true);
        addToTabs(event, CreativeModeTabs.COMBAT, Items.NETHERITE_BOOTS, ItemsInit.LEAD_CHESTPLATE, true);

        // TOOLS_AND_UTILITIES
        addToTabs(event, CreativeModeTabs.TOOLS_AND_UTILITIES, Items.NETHERITE_HOE, ItemsInit.LEAD_HOE, true);
        addToTabs(event, CreativeModeTabs.TOOLS_AND_UTILITIES, Items.NETHERITE_HOE, ItemsInit.LEAD_AXE, true);
        addToTabs(event, CreativeModeTabs.TOOLS_AND_UTILITIES, Items.NETHERITE_HOE, ItemsInit.LEAD_PICKAXE, true);
        addToTabs(event, CreativeModeTabs.TOOLS_AND_UTILITIES, Items.NETHERITE_HOE, ItemsInit.LEAD_SHOVEL, true);

        // INGREDIENTS
        addToTabs(event, CreativeModeTabs.INGREDIENTS, Items.GUNPOWDER, ItemsInit.YELLOWCAKE, true);
        addToTabs(event, CreativeModeTabs.INGREDIENTS, Items.NETHERITE_INGOT, ItemsInit.LEAD_INGOT, true);
        addToTabs(event, CreativeModeTabs.INGREDIENTS, Items.DIAMOND, ItemsInit.URANIUM_RAW, true);
        addToTabs(event, CreativeModeTabs.INGREDIENTS, Items.NETHERITE_INGOT, ItemsInit.URANIUM_INGOT, true);
        addToTabs(event, CreativeModeTabs.INGREDIENTS, Items.WHEAT, ItemsInit.FLOUR, true);

        // Functional block
        addToTabs(event, CreativeModeTabs.FUNCTIONAL_BLOCKS, Items.BREWING_STAND, ItemsInit.CHEMICAL_LEACHING_MACHINE_ITEM, true);
    }
}