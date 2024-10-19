package dev.manhattan.mods.blockentity.util;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;

// Interface representing a block entity that has logic executed on each tick.
public interface TickableBlockEntity {
    // Method to be implemented by block entities to define their behavior on each tick.
    void tick();

    // Utility method to return a BlockEntityTicker, which executes the tick logic.
    // If it's on the client side, return null (no tick on the client side), otherwise execute the tick() method.
    static <T extends BlockEntity> BlockEntityTicker<T> getTickerHelper(Level level) {
        // On the server side, return a ticker that calls the tick() method of the block entity.
        return level.isClientSide() ? null : (level0, pos0, state0, BlockEntity) -> ((TickableBlockEntity)BlockEntity).tick();
    }
}
