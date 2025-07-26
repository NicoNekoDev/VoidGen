package de.xtkq.voidgen.generator.interfaces;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class ChunkGen2D extends ChunkGen implements IChunkGenBiomeGrid {

    public ChunkGen2D(JavaPlugin paramPlugin, String paramIdentifier) {
        super(paramPlugin, paramIdentifier);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setBiomeGrid(BiomeGrid paramBiomeGrid, ChunkData paramChunkData) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                paramBiomeGrid.setBiome(x, z, this.chunkGenSettings.getBiome());
            }
        }
    }
}
