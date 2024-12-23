package dev.manhattan.mods.init;

import dev.manhattan.mods.Mods;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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

    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.1f)
                            .build())
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<Item> PIZZA = ITEMS.register("pizza",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .food(new FoodProperties.Builder()
                            .nutrition(9)
                            .saturationMod(0.1f)
                            .build())
                    .rarity(Rarity.UNCOMMON)
            ));

    public static final RegistryObject<Item> SLICE_OF_PIZZA = ITEMS.register("slice_of_pizza",
            () -> new Item(new Item.Properties()
                    .stacksTo(16)
                    .food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationMod(0.1f)
                            .build())
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<BlockItem> URANIUM_BLOCK_ITEM = ITEMS.register("uranium_block",
            () -> new BlockItem(BlocksInit.URANIUM_BLOCK.get(),
                    new Item.Properties()
                            .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<BlockItem> LEAD_BLOCK_ITEM = ITEMS.register("lead_block",
            () -> new BlockItem(BlocksInit.LEAD_BLOCK.get(),
                    new Item.Properties()
                            .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<BlockItem> CARBON_BLOCK_ITEM = ITEMS.register("carbon_block",
            () -> new BlockItem(BlocksInit.CARBON_BLOCK.get(),
                    new Item.Properties()
                            .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<BlockItem> LEAD_ORE_ITEM = ITEMS.register("lead_ore",
            () -> new BlockItem(BlocksInit.LEAD_ORE.get(),
                    new Item.Properties()
                            .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<BlockItem> DEEPSLATE_LEAD_ORE_ITEM = ITEMS.register("deepslate_lead_ore",
            () -> new BlockItem(BlocksInit.DEEPSLATE_LEAD_ORE.get(),
                    new Item.Properties()
                            .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<SwordItem> LEAD_SWORD = ITEMS.register("lead_sword",
            () -> new SwordItem(
                    TiersInit.LEAD,
                    3,
                    -0.6f,
                    new Item.Properties()
            ));

    public static final RegistryObject<PickaxeItem> LEAD_PICKAXE = ITEMS.register("lead_pickaxe",
            () -> new PickaxeItem(
                    TiersInit.LEAD,
                    2,
                    1.2f,
                    new Item.Properties()
            ));

    public static final RegistryObject<AxeItem> LEAD_AXE = ITEMS.register("lead_axe",
            () -> new AxeItem(
                    TiersInit.LEAD,
                    2,
                    1.2f,
                    new Item.Properties()
            ));

    public static final RegistryObject<ShovelItem> LEAD_SHOVEL = ITEMS.register("lead_shovel",
            () -> new ShovelItem(
                    TiersInit.LEAD,
                    1,
                    1.5f,
                    new Item.Properties()
            ));

    public static final RegistryObject<HoeItem> LEAD_HOE = ITEMS.register("lead_hoe",
            () -> new HoeItem(
                    TiersInit.LEAD,
                    1,
                    1.5f,
                    new Item.Properties()
            ));

    public static final RegistryObject<ArmorItem> LEAD_HELMET = ITEMS.register("lead_helmet",
            () -> new ArmorItem(
                    ArmorMaterialInit.LEAD,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
            ));

    public static final RegistryObject<ArmorItem> LEAD_CHESTPLATE = ITEMS.register("lead_chestplate",
            () -> new ArmorItem(
                    ArmorMaterialInit.LEAD,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
            ));

    public static final RegistryObject<ArmorItem> LEAD_LEGGINGS = ITEMS.register("lead_leggings",
            () -> new ArmorItem(
                    ArmorMaterialInit.LEAD,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
            ));

    public static final RegistryObject<ArmorItem> LEAD_BOOTS = ITEMS.register("lead_boots",
            () -> new ArmorItem(
                    ArmorMaterialInit.LEAD,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
            ));

    public static final RegistryObject<BlockItem> URANIUM_ORE_ITEM = ITEMS.register("uranium_ore",
            () -> new BlockItem(BlocksInit.URANIUM_ORE.get(),
                    new Item.Properties()
                            .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<BlockItem> DEEPSLATE_URANIUM_ORE_ITEM = ITEMS.register("deepslate_uranium_ore",
            () -> new BlockItem(BlocksInit.DEEPSLATE_URANIUM_ORE.get(),
                    new Item.Properties()
                            .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<Item> URANIUM_RAW = ITEMS.register("uranium_raw",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<Item> YELLOWCAKE = ITEMS.register("yellowcake",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<BlockItem> CHEMICAL_LEACHING_MACHINE_ITEM = ITEMS.register("chemical_leaching_machine_item",
            () -> new BlockItem(BlocksInit.CHEMICAL_LEACHING_MACHINE_BLOCK.get(),
                    new Item.Properties()
                            .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<ForgeSpawnEggItem> NUCLEBUG_SPAWN_EGG = ITEMS.register("nuclebug_spawn_egg",
            () -> new ForgeSpawnEggItem(EntitiesInit.NUCLEBUG_ENTITY, 0xF0ABD1, 0xAE4C82, new Item.Properties()));
}
