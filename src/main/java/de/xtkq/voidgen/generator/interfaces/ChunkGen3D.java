package de.xtkq.voidgen.generator.interfaces;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class ChunkGen3D extends ChunkGen implements IChunkGenBiomeGrid {

    public ChunkGen3D(JavaPlugin paramPlugin, String paramIdentifier, String worldName) {
        super(paramPlugin, paramIdentifier, worldName);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setBiomeGrid(BiomeGrid paramBiomeGrid, ChunkData paramChunkData) {
        if (this.chunkGenSettings.getBiome().isPresent())
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    for (int y = 0; y < paramChunkData.getMaxHeight(); y++) {
                        paramBiomeGrid.setBiome(x, y, z, this.chunkGenSettings.getBiome().get());
                    }
                }
            }
    }
}
