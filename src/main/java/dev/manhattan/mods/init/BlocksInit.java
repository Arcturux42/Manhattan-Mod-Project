package dev.manhattan.mods.init;

import dev.manhattan.mods.Mods;
import dev.manhattan.mods.block.ChemicalLeachingMachineBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
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

    public static final RegistryObject<Block> CARBON_BLOCK = BLOCKS.register("carbon_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.0f, 1f)
                    .lightLevel(state -> 50)
            ));

    public static final RegistryObject<Block> LEAD_ORE = BLOCKS.register("lead_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.0f, 1f)
                    .lightLevel(state -> 50)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = BLOCKS.register("deepslate_lead_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.0f, 1f)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<DropExperienceBlock> URANIUM_ORE = BLOCKS.register("uranium_ore",
            () -> new DropExperienceBlock(
                    BlockBehaviour.Properties.of()
                        .strength(1.0f, 1f)
                        .lightLevel(state -> 50)
                        .requiresCorrectToolForDrops(),
                    UniformInt.of(4, 7)
            ));
    public static final RegistryObject<DropExperienceBlock> DEEPSLATE_URANIUM_ORE = BLOCKS.register("deepslate_uranium_ore",
            () -> new DropExperienceBlock(
                    BlockBehaviour.Properties.of()
                            .strength(1.0f, 1f)
                            .lightLevel(state -> 50)
                            .requiresCorrectToolForDrops(),
                    UniformInt.of(4, 7)
            ));

    public static final RegistryObject<ChemicalLeachingMachineBlock> CHEMICAL_LEACHING_MACHINE_BLOCK = BLOCKS.register("chemical_leaching_machine_block",
            () -> new ChemicalLeachingMachineBlock(BlockBehaviour.Properties.of()
                    .strength(4.0f, 4f)
                    .noOcclusion()
            ));
}
