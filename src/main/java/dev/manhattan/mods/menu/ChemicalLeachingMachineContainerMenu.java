package dev.manhattan.mods.menu;

import dev.manhattan.mods.blockentity.ChemicalLeachingMachineBlockEntity;
import dev.manhattan.mods.init.BlocksInit;
import dev.manhattan.mods.init.MenuInit;
import dev.manhattan.mods.menu.slot.UraniumSlot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ChemicalLeachingMachineContainerMenu extends AbstractContainerMenu {
    private final ChemicalLeachingMachineBlockEntity blockEntity; // Reference to the block entity
    private final ContainerLevelAccess levelAccess; // Level access for interface validation

    // Client constructor (used when opening the graphical interface)
    public ChemicalLeachingMachineContainerMenu(int containerId, Inventory playerInv, FriendlyByteBuf additionalData) {
        // Retrieves the block entity based on information received from the client
        this(containerId, playerInv, playerInv.player.level().getBlockEntity(additionalData.readBlockPos()));
    }

    // Server constructor (called when opening the interface on the server side)
    public ChemicalLeachingMachineContainerMenu(int containerId, Inventory playerInv, BlockEntity blockEntity) {
        super(MenuInit.CHEMICAL_LEACHING_MACHINE_MENU.get(), containerId);

        // Checks that the entity is of type ChemicalLeachingMachineBlockEntity
        if (blockEntity instanceof ChemicalLeachingMachineBlockEntity be) {
            this.blockEntity = be;
        } else {
            throw new IllegalStateException("Incorrect block entity type passed into ChemicalLeachingMachineMenus");
        }

        this.levelAccess = ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos());

        // Adds slots for the machine (raw uranium and yellowcake)
        this.addSlot(new UraniumSlot(be.getInventory(), 0, 39, 36)); // Slot for raw uranium
        this.addSlot(new Slot(be.getInventory(), 1, 121, 36)); // Slot for yellowcake

        // Adds the player's inventory slots
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // Adds the player's shortcut bar
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInv, col, 8 + col * 18, 142));
        }
    }

    // Handles quick item movements between the machine's slots and the player's slots
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack stackInSlot = slot.getItem();
            itemstack = stackInSlot.copy();

            // Checks if the selected stack comes from the machine's slots
            if (index < 2) { // Machine slots
                // Attempts to move the item to the player's inventory (slots 2 to 38)
                if (!this.moveItemStackTo(stackInSlot, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
            }
        }

        if (itemstack.isEmpty()) {
            slot.set(ItemStack.EMPTY); // Empties the slot
        } else {
            slot.setChanged(); // Marks the slot as modified
        }

        return itemstack;
    }

    // Returns the current progress of the chemical process
    public float getProgress() {
        return blockEntity.getProgress();
    }

    // Checks if the interface is still valid and accessible by the player
    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.levelAccess, player, BlocksInit.CHEMICAL_LEACHING_MACHINE_BLOCK.get());
    }
}
