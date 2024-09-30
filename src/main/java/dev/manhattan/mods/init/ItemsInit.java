package dev.manhattan.mods.init;

import dev.manhattan.mods.Mods;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.manhattan.mods.init.CreativeTabInit.addToTab;

public class ItemsInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mods.MODID);

    public static final RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.1f)
                            .build())
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<BlockItem> URANIUM_BLOCK_ITEM = addToTab(ITEMS.register("uranium_block",
            () -> new BlockItem(BlocksInit.URANIUM_BLOCK.get(),
                    new Item.Properties()
                            .rarity(Rarity.COMMON)
            )));

    public static final RegistryObject<BlockItem> LEAD_BLOCK_ITEM = addToTab(ITEMS.register("lead_block",
            () -> new BlockItem(BlocksInit.LEAD_BLOCK.get(),
                    new Item.Properties()
                            .rarity(Rarity.COMMON)
            )));

    public static final RegistryObject<BlockItem> CARBON_BLOCK_ITEM = addToTab(ITEMS.register("carbon_block",
            () -> new BlockItem(BlocksInit.CARBON_BLOCK.get(),
                    new Item.Properties()
                            .rarity(Rarity.COMMON)
            )));

    public static final RegistryObject<BlockItem> LEAD_ORE_ITEM = addToTab(ITEMS.register("lead_ore",
            () -> new BlockItem(BlocksInit.LEAD_ORE.get(),
                    new Item.Properties()
                            .rarity(Rarity.COMMON)
            )));

    public static final RegistryObject<SwordItem> LEAD_SWORD = addToTab(ITEMS.register("lead_sword",
            () -> new SwordItem(
                    TiersInit.LEAD,
                    3,
                    -0.6f,
                    new Item.Properties()
            )));

    public static final RegistryObject<PickaxeItem> LEAD_PICKAXE = addToTab(ITEMS.register("lead_pickaxe",
            () -> new PickaxeItem(
                    TiersInit.LEAD,
                    2,
                    1.2f,
                    new Item.Properties()
            )));

    public static final RegistryObject<AxeItem> LEAD_AXE = addToTab(ITEMS.register("lead_axe",
            () -> new AxeItem(
                    TiersInit.LEAD,
                    2,
                    1.2f,
                    new Item.Properties()
            )));

    public static final RegistryObject<ShovelItem> LEAD_SHOVEL = addToTab(ITEMS.register("lead_shovel",
            () -> new ShovelItem(
                    TiersInit.LEAD,
                    1,
                    1.5f,
                    new Item.Properties()
            )));

    public static final RegistryObject<HoeItem> LEAD_HOE = addToTab(ITEMS.register("lead_hoe",
            () -> new HoeItem(
                    TiersInit.LEAD,
                    1,
                    1.5f,
                    new Item.Properties()
            )));

    public static final RegistryObject<ArmorItem> LEAD_HELMET = addToTab(ITEMS.register("lead_helmet",
            () -> new ArmorItem(
                    ArmorMaterialInit.LEAD,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
            )));

    public static final RegistryObject<ArmorItem> LEAD_CHESTPLATE = addToTab(ITEMS.register("lead_chestplate",
            () -> new ArmorItem(
                    ArmorMaterialInit.LEAD,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
            )));

    public static final RegistryObject<ArmorItem> LEAD_LEGGINGS = addToTab(ITEMS.register("lead_leggings",
            () -> new ArmorItem(
                    ArmorMaterialInit.LEAD,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
            )));

    public static final RegistryObject<ArmorItem> LEAD_BOOTS = addToTab(ITEMS.register("lead_boots",
            () -> new ArmorItem(
                    ArmorMaterialInit.LEAD,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
            )));

    public static final RegistryObject<BlockItem> URANIUM_ORE_ITEM = addToTab(ITEMS.register("uranium_ore",
            () -> new BlockItem(BlocksInit.URANIUM_ORE.get(),
                    new Item.Properties()
                            .rarity(Rarity.COMMON)
            )));

    public static final RegistryObject<Item> URANIUM_RAW = addToTab(ITEMS.register("uranium_raw",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            )));
}
