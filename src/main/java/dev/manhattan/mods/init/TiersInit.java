package dev.manhattan.mods.init;

import dev.manhattan.mods.Mods;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class TiersInit {
    public static final Tier LEAD = TierSortingRegistry.registerTier(new ForgeTier(
                    5,
                    800,
                    15f,
                    5f,
                    22,
                    TagInit.NEEDS_LEAD_TOOL,
                    () -> Ingredient.of(ItemsInit.CHOCOLATE.get())),
            new ResourceLocation(Mods.MODID, "lead"), // This is the name of your tier
            List.of(Tiers.NETHERITE), // This is a list of tiers that this tier should be after (in this case only netherite)
            List.of()); // This is a list of tiers that this tier should be before (in this case its better than all the other tiers, so we leave it empty)
}
