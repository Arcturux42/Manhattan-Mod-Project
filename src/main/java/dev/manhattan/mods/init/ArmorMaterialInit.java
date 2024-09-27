package dev.manhattan.mods.init;

import dev.manhattan.mods.init.tiers.ModArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorMaterialInit {
    public static final ModArmorMaterial LEAD = new ModArmorMaterial(
            new int[] {500, 1200, 600, 400},
            new int[] {11, 16, 15, 13},
            20,
            SoundEvents.FOX_TELEPORT,
            () -> Ingredient.of(ItemsInit.LEAD_BLOCK_ITEM::get),
            "lead",
            0.25f,
            0.15f
    );
}
