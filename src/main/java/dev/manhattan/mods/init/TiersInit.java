package dev.manhattan.mods.init;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class TiersInit {
    public static final  ForgeTier LEAD = new ForgeTier(
            4,
            750,
            1.5f,
            4.f,
            14,
            TagInit.NEEDS_LEAD_TOOL,
            () -> Ingredient.of(ItemsInit.LEAD_BLOCK_ITEM::get)
    );
}
