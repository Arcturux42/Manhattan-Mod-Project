package dev.manhattan.mods.init;

import dev.manhattan.mods.Mods;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
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
}
