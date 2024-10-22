package dev.manhattan.mods.network;

import dev.manhattan.mods.blockentity.ChemicalLeachingMachineBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncProgressPacket {
    private final BlockPos pos;    // Position of the block referenced by the packet
    private final int progress;     // Progress value to synchronize

    // Constructor to create a packet with a given position and progress
    public SyncProgressPacket(BlockPos pos, int progress) {
        this.pos = pos;
        this.progress = progress;
    }

    // Constructor to recreate a packet from byte data
    public SyncProgressPacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos(); // Reads the block position from the bytes
        this.progress = buf.readInt();  // Reads the progress value from the bytes
    }

    // Converts the packet to bytes for sending over the network
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(this.pos); // Writes the position to the buffer
        buf.writeInt(this.progress);  // Writes the progress to the buffer
    }

    // Handles the reception of the packet on the client or server
    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
        // Enqueues a task to execute on the event management thread
        ctx.get().enqueueWork(() -> {
            if (ctx.get().getDirection().getReceptionSide().isClient()) {
                // Client side
                BlockEntity entity = Minecraft.getInstance().level.getBlockEntity(pos); // Retrieves the block at the specified position
                if (entity instanceof ChemicalLeachingMachineBlockEntity) {
                    // If the block is an instance of ChemicalLeachingMachineBlockEntity, update the progress
                    ((ChemicalLeachingMachineBlockEntity) entity).setClientProgress(this.progress);
                }
            } else {
                // Server side
                BlockEntity entity = ctx.get().getSender().level().getBlockEntity(pos); // Retrieves the block at the specified position
                if (entity instanceof ChemicalLeachingMachineBlockEntity) {
                    // If the block is an instance of ChemicalLeachingMachineBlockEntity, update the progress
                    ((ChemicalLeachingMachineBlockEntity) entity).setClientProgress(this.progress);
                }
            }
        });

        return true; // Indicates that the packet handling was successful
    }
}