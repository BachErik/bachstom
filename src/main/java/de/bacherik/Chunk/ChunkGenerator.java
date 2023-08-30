package de.bacherik.Chunk;

import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.PlayerLoginEvent;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.block.Block;

public class ChunkGenerator {

    private final InstanceContainer instanceContainer;

    /**
     * @param instanceContainer InstanceContainer from InstanceManager
     */
    public ChunkGenerator(InstanceContainer instanceContainer) {
        this.instanceContainer = instanceContainer;
    }

    /**
     * Generate a flat world and add an event callback to specify the spawning instance
     * and the spawn position.
     */
    private void Flat() {
        instanceContainer.setGenerator(unit -> {
            // Generate a flat world
            unit.modifier().fillHeight(0, 63, Block.DIRT);
            unit.modifier().fillHeight(63, 64, Block.GRASS);

            // Add an event callback to specify the spawning instance (and the spawn position)
            GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();
            globalEventHandler.addListener(PlayerLoginEvent.class, event -> {
                final Player player = event.getPlayer();
                event.setSpawningInstance(instanceContainer);
                player.setRespawnPoint(new Pos(0, 64, 0));
            });
        });
    }

    private void Normal() {
        System.out.println("Not implemented yet");
    }

    private void Amplified() {
        System.out.println("Not implemented yet");
    }

    private void Custom() {
        System.out.println("Not implemented yet");
    }
}
