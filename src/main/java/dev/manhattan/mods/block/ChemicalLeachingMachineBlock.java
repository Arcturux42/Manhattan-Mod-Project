package dev.manhattan.mods.block;

import dev.manhattan.mods.blockentity.util.TickableBlockEntity;
import dev.manhattan.mods.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// Class representing the block of the chemical leaching machine, which can be oriented horizontally.
public class ChemicalLeachingMachineBlock extends HorizontalDirectionalBlock implements EntityBlock {

    // Constructor for the block, defining its properties and the default orientation (north).
    public ChemicalLeachingMachineBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    // Creates a new block entity for this block at a given position.
    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return BlockEntityInit.CHEMICAL_LEACHING_MACHINE_BLOCK_ENTITY.get().create(pos, state);
    }

    // Adds the direction (FACING) as a state of the block.
    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    // Determines the orientation of the block when placed (facing away from the player).
    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    // Retrieves the block entity ticker to execute logic on each tick.
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> blockEntityType) {
        return TickableBlockEntity.getTickerHelper(level);
    }

    // Handles interaction with the block (right-click).
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        // Ignore if the hand used is not the main hand.
        if (hand != InteractionHand.MAIN_HAND) return InteractionResult.PASS;

        // On the client side, return SUCCESS for the animation.
        if (level.isClientSide) return InteractionResult.SUCCESS;

        // If the block has a user interface, open it for the player.
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof MenuProvider menuProvider) {
            NetworkHooks.openScreen((ServerPlayer) player, menuProvider, buf -> buf.writeBlockPos(pos));
            return InteractionResult.SUCCESS;
        }

        // Otherwise, fail the interaction.
        return InteractionResult.FAIL;
    }
}