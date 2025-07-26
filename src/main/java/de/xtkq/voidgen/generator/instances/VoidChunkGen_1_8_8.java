package de.xtkq.voidgen.generator.instances;

import de.xtkq.voidgen.generator.annotations.VoidChunkGenInfo;
import de.xtkq.voidgen.generator.interfaces.ChunkGen2D;
import de.xtkq.voidgen.generator.settings.LayerSettings;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

@VoidChunkGenInfo(versions = {"1.8.8", "1.9", "1.9.2", "1.9.4", "1.10", "1.10.2", "1.11", "1.11.1", "1.11.2", "1.12",
        "1.12.1", "1.12.2", "1.13", "1.13.1", "1.13.2", "1.14", "1.14.1", "1.14.2", "1.14.3", "1.14.4"})
public final class VoidChunkGen_1_8_8 extends ChunkGen2D {

    public VoidChunkGen_1_8_8(JavaPlugin paramPlugin, String paramIdentifier) {
        super(paramPlugin, paramIdentifier);
    }

    @Override
    public Biome getDefaultBiome() {
        return Biome.PLAINS;
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public ChunkData generateChunkData(@NotNull World world, @NotNull Random random, int chunkX, int chunkZ, @NotNull BiomeGrid paramBiomeGrid) {
        ChunkData chunkData = this.createChunkData(world);
        this.setBiomeGrid(paramBiomeGrid, chunkData);
        int yOffset = 0;
        if (this.chunkGenSettings.getLayers() != null) {
            for (LayerSettings layer : this.chunkGenSettings.getLayers()) {
                for (int y = 0; y < layer.getHeight(); y++) {
                    yOffset++;
                    for (int x = 0; x < 16; x++) {
                        for (int z = 0; z < 16; z++) {
                            chunkData.setBlock(x, yOffset, z, layer.getMaterial());
                        }
                    }
                }
            }
        } else if (this.chunkGenSettings.isBedrock())
            super.generateBedrock(world, random, chunkX, chunkZ, chunkData);
        return chunkData;
    }
}
