package dev.manhattan.mods.init;

import dev.manhattan.mods.Mods;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
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

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        MANHATTAN_TAB_ITEMS.add(itemLike);
        return itemLike;
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey().equals(CreativeModeTabs.BUILDING_BLOCKS)) {
            event.getEntries().putAfter(Items.BASALT.getDefaultInstance(), ItemsInit.URANIUM_BLOCK_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ItemsInit.CARBON_BLOCK_ITEM);
            event.accept(ItemsInit.LEAD_BLOCK_ITEM);
        }

        if(event.getTabKey().equals(CreativeModeTabs.FOOD_AND_DRINKS)) {

            event.getEntries()
                    .putAfter(
                            Items.PUMPKIN.getDefaultInstance(),
                            ItemsInit.CHEESE.get().getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries()
                    .putAfter(
                            Items.PUMPKIN.getDefaultInstance(),
                            ItemsInit.CHOCOLATE.get().getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries()
                    .putAfter(
                            Items.PUMPKIN.getDefaultInstance(),
                            ItemsInit.SLICE_OF_PIZZA.get().getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries()
                    .putAfter(
                            Items.PUMPKIN.getDefaultInstance(),
                            ItemsInit.PIZZA.get().getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if(event.getTabKey().equals(CreativeModeTabs.NATURAL_BLOCKS)) {
            event.accept(ItemsInit.LEAD_ORE_ITEM);
            event.accept(ItemsInit.URANIUM_ORE_ITEM);
        }
        if(event.getTabKey().equals(CreativeModeTabs.COMBAT)) {
            event.getEntries()
                    .putAfter(
                            Items.NETHERITE_SWORD.getDefaultInstance(),
                            ItemsInit.LEAD_SWORD.get().getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries()
                    .putAfter(
                            Items.NETHERITE_BOOTS.getDefaultInstance(),
                            ItemsInit.LEAD_BOOTS.get().getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries()
                    .putAfter(
                            Items.NETHERITE_BOOTS.getDefaultInstance(),
                            ItemsInit.LEAD_LEGGINGS.get().getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries()
                    .putAfter(
                            Items.NETHERITE_BOOTS.getDefaultInstance(),
                            ItemsInit.LEAD_HELMET.get().getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries()
                    .putAfter(
                            Items.NETHERITE_BOOTS.getDefaultInstance(),
                            ItemsInit.LEAD_CHESTPLATE.get().getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if(event.getTabKey().equals(CreativeModeTabs.TOOLS_AND_UTILITIES)) {

            event.getEntries()
                    .putAfter(
                            Items.NETHERITE_HOE.getDefaultInstance(),
                            ItemsInit.LEAD_HOE.get().getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries()
                    .putAfter(
                            Items.NETHERITE_HOE.getDefaultInstance(),
                            ItemsInit.LEAD_AXE.get().getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries()
                    .putAfter(
                            Items.NETHERITE_HOE.getDefaultInstance(),
                            ItemsInit.LEAD_PICKAXE.get().getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries()
                    .putAfter(
                            Items.NETHERITE_HOE.getDefaultInstance(),
                            ItemsInit.LEAD_SHOVEL.get().getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if(event.getTabKey().equals(CreativeModeTabs.INGREDIENTS)) {
            event.accept(ItemsInit.YELLOWCAKE);
        }
    }
}
