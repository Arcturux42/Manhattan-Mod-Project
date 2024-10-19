package dev.manhattan.mods.init;

import dev.manhattan.mods.Mods;
import dev.manhattan.mods.blockentity.ChemicalLeachingMachineBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Mods.MODID);

    public static final RegistryObject<BlockEntityType<ChemicalLeachingMachineBlockEntity>> CHEMICAL_LEACHING_MACHINE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("chemical_leaching_machine_block_entity",
                    () -> BlockEntityType.Builder.of(ChemicalLeachingMachineBlockEntity::new, BlocksInit.CHEMICAL_LEACHING_MACHINE_BLOCK.get())
                            .build(null)
            );
}
