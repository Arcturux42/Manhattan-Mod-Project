package dev.manhattan.mods.init;

import dev.manhattan.mods.init.tiers.ModArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorMaterialInit {
    public static final ModArmorMaterial LEAD = new ModArmorMaterial(
            new int[] {300, 900, 450, 240},
            new int[] {2, 3, 5, 2},
            12,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            () -> Ingredient.of(ItemsInit.LEAD_BLOCK_ITEM::get),
            "lead",
            0.12f,
            0.20f
    );
}
