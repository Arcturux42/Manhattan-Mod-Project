package dev.manhattan.mods.init;

import dev.manhattan.mods.Mods;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlocksInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Mods.MODID);

    public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(10.0f, 12f)
                    .lightLevel(state -> 15)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> LEAD_BLOCK = BLOCKS.register("lead_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f, 7f)
                    .requiresCorrectToolForDrops()
            ));
}
