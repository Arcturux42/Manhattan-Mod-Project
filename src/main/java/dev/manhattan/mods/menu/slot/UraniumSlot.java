package dev.manhattan.mods.menu.slot;

import dev.manhattan.mods.init.ItemsInit;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

// This class defines a custom slot specifically for uranium.
public class UraniumSlot extends Slot {

    // Constructor for the UraniumSlot class.
    public UraniumSlot(Container container, int index, int xPosition, int yPosition) {
        super(container, index, xPosition, yPosition);
    }

    // This method checks if the item being placed in the slot is allowed.
    @Override
    public boolean mayPlace(ItemStack stack) {
        // Only allows uranium_raw to be placed in this slot.
        return stack.getItem() == ItemsInit.URANIUM_RAW.get();
    }
}
