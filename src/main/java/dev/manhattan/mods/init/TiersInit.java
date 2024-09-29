package dev.manhattan.mods.init;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class TiersInit {
    public static final  ForgeTier LEAD = new ForgeTier(
            4,
            550,
            0.7f,
            2.f,
            14,
            TagInit.NEEDS_LEAD_TOOL,
            () -> Ingredient.of(ItemsInit.LEAD_BLOCK_ITEM::get)
    );
}
