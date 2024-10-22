package dev.manhattan.mods.blockentity;

import dev.manhattan.mods.Mods;
import dev.manhattan.mods.blockentity.util.TickableBlockEntity;
import dev.manhattan.mods.init.BlockEntityInit;
import dev.manhattan.mods.init.ItemsInit;
import dev.manhattan.mods.menu.ChemicalLeachingMachineContainerMenu;
import dev.manhattan.mods.network.ModsNetwork;
import dev.manhattan.mods.network.SyncProgressPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// Block entity for the chemical leaching machine, with ticker capability and providing a user interface menu.
public class ChemicalLeachingMachineBlockEntity extends BlockEntity implements TickableBlockEntity, MenuProvider {

    // Title of the user interface
    private static final Component TITLE = Component.translatable("container." + Mods.MODID + ".chemical_leaching_machine_menu_block");

    // Machine inventory with 2 slots (for raw uranium and yellowcake).
    private final SimpleContainer inventory = new SimpleContainer(2);

    // Variables to manage the processing progress.
    private int ticks;
    private static final int MAX_PROGRESS = 400; // Time needed to complete the process
    private int currentProgress = 0; // Current progress

    // Constructor for the block entity
    public ChemicalLeachingMachineBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.CHEMICAL_LEACHING_MACHINE_BLOCK_ENTITY.get(), pos, state);
    }

    // Method called on each server tick to manage the block's progress.
    @Override
    public void tick() {
        if (this.level == null || this.level.isClientSide()) return;

        // If the machine can progress, increment the progress.
        if (this.canProcess()) {
            this.currentProgress++;
            if (this.currentProgress >= MAX_PROGRESS) {
                this.processItem(); // Transform raw uranium into yellowcake
                this.currentProgress = 0; // Reset after transformation
            }
        } else {
            this.currentProgress = 0; // Reset if the process cannot continue
        }

        // Send the current progress to the client
        this.sendProgressToClient();
    }

    // Checks if the machine can progress (if raw uranium is present in the inventory).
    private boolean canProcess() {
        return !this.getInventory().getItem(0).isEmpty(); // Check slot 0 (raw uranium)
    }

    // Transforms raw uranium into yellowcake.
    private void processItem() {
        ItemStack input = this.inventory.getItem(0); // Raw uranium
        ItemStack output = this.inventory.getItem(1); // Yellowcake

        // If the output slot is empty or can accept more yellowcake.
        if (output.isEmpty() || (output.getItem() == ItemsInit.YELLOWCAKE.get() && output.getCount() < output.getMaxStackSize())) {
            this.inventory.removeItem(0, 1); // Remove one raw uranium
            if (output.isEmpty()) {
                this.inventory.setItem(1, new ItemStack(ItemsInit.YELLOWCAKE.get())); // Create a yellowcake
            } else {
                output.grow(1); // Add an additional yellowcake
            }
        }
    }

    // Returns the machine's inventory.
    public Container getInventory() {
        return this.inventory;
    }

    // Returns the current progress as a percentage.
    public float getProgress() {
        return (float) this.currentProgress / (float) MAX_PROGRESS;
    }

    // Returns the display name for the user interface.
    @Override
    public Component getDisplayName() {
        return TITLE;
    }

    // Creates the user interface menu for the player.
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pPlayerInventory, Player pPlayer) {
        return new ChemicalLeachingMachineContainerMenu(pContainerId, pPlayerInventory, this);
    }

    // Sends the current progress to the client for synchronization.
    public void sendProgressToClient() {
        if (this.level != null && !this.level.isClientSide()) {
            ModsNetwork.CHANNEL.send(PacketDistributor.TRACKING_CHUNK.with(() -> this.level.getChunkAt(this.worldPosition)),
                    new SyncProgressPacket(this.worldPosition, this.currentProgress));
        }
    }

    // Sets the progress on the client side (useful for synchronization).
    public void setClientProgress(int progress) {
        this.currentProgress = progress;
    }
}
