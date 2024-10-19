package dev.manhattan.mods.client.screen;

import dev.manhattan.mods.menu.ChemicalLeachingMachineContainerMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

// User interface screen for the chemical leaching machine.
public class ChemicalLeachingMachineScreen extends AbstractContainerScreen<ChemicalLeachingMachineContainerMenu> {

    // Location of the graphical interface texture.
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("manhattan", "textures/gui/chemical_leaching_machine_gui.png");

    // Constructor for the screen, taking the menu, player inventory, and screen title.
    public ChemicalLeachingMachineScreen(ChemicalLeachingMachineContainerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 176; // Width of the interface.
        this.imageHeight = 166; // Height of the interface.
    }

    // Method to draw the background of the screen and the progress bar.
    @Override
    protected void renderBg(@NotNull GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        // Draws the background image of the user interface.
        pGuiGraphics.blit(GUI_TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        // Draws the empty bar (area where the progress bar will appear).
        pGuiGraphics.blit(GUI_TEXTURE, this.leftPos + 60, this.topPos + 37, 60, 37, 54, 15);

        // Calculates the width of the progress bar based on the current progress.
        int progressWidth = (int) (menu.getProgress() * 54); // The bar is 54 pixels wide.

        // Draws the filled progress bar.
        pGuiGraphics.blit(GUI_TEXTURE, this.leftPos + 60, this.topPos + 37, 177, 0, progressWidth, 15);
    }

    // Global rendering method for the screen, including tooltips.
    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        // Calls the superclass rendering (draws the standard interface).
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        // Displays tooltips if the mouse is over an interactive element.
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
