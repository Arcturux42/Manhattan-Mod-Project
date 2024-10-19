package dev.manhattan.mods.network;

import dev.manhattan.mods.Mods;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModsNetwork {
    // Network protocol version used to ensure compatibility between client and server
    private static final String PROTOCOL_VERSION = "1";

    // Creation of a SimpleChannel network channel with a unique identifier
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(Mods.MODID, "network"), // Unique name for the network channel (formatted with the MODID)
            () -> PROTOCOL_VERSION, // Protocol version for sending
            PROTOCOL_VERSION::equals, // Checks if the protocol version on the client side matches
            PROTOCOL_VERSION::equals  // Checks if the protocol version on the server side matches
    );

    // Registration of packets to be transmitted over the network channel
    public static void registerPackets() {
        int id = 1; // Unique identifier for each packet

        // Registration of the SyncProgressPacket with specific handling
        CHANNEL.registerMessage(id++,
                SyncProgressPacket.class,       // Class of the packet to register
                SyncProgressPacket::toBytes,    // Method to convert the packet to bytes for transmission
                SyncProgressPacket::new,        // Constructor to recreate the packet from received bytes
                SyncProgressPacket::handle      // Handler to process the received packet on client or server
        );
    }
}