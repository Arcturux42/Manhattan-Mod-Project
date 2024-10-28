package dev.manhattan.mods.init;

import dev.manhattan.mods.Mods;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class TagInit {
    public static final TagKey<Block> NEEDS_LEAD_TOOL = tag("needs_lead_tool");

    private static  TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(Mods.MODID, name));
    }
}