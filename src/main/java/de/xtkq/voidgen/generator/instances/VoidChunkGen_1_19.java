package de.xtkq.voidgen.generator.instances;

import de.xtkq.voidgen.generator.annotations.VoidChunkGenInfo;
import de.xtkq.voidgen.generator.interfaces.ChunkGen;
import de.xtkq.voidgen.generator.settings.LayerSettings;
import de.xtkq.voidgen.utils.VoidBiomeProvider;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

@VoidChunkGenInfo(versions = {"1.19", "1.19.1", "1.19.2", "1.19.3", "1.19.4", "1.20", "1.20.1", "1.20.2", "1.20.3", "1.20.4", "1.21", "1.21.1", "1.21.2"})
public final class VoidChunkGen_1_19 extends ChunkGen {

    public VoidChunkGen_1_19(JavaPlugin javaPlugin, String paramIdentifier, String worldName) {
        super(javaPlugin, paramIdentifier, worldName);
    }

    @Override
    public Biome getDefaultBiome() {
        return Biome.THE_VOID;
    }

    @Override
    public BiomeProvider getDefaultBiomeProvider(@NotNull WorldInfo worldInfo) {
        return new VoidBiomeProvider(this.chunkGenSettings.getBiome());
    }

    @NotNull
    @SuppressWarnings("deprecation")
    @Override
    public ChunkData generateChunkData(@NotNull World world, @NotNull Random random, int chunkX, int chunkZ, @NotNull BiomeGrid paramBiomeGrid) {
        ChunkData chunkData = this.createChunkData(world);
        int yOffset = world.getMinHeight();
        if (this.chunkGenSettings.getLayers() != null) {
            for (LayerSettings layer : this.chunkGenSettings.getLayers()) {
                for (int y = 0; y < layer.getHeight(); y++) {
                    for (int x = 0; x < 16; x++) {
                        for (int z = 0; z < 16; z++) {
                            chunkData.setBlock(x, yOffset, z, layer.composeBlockData());
                        }
                    }
                    yOffset++;
                }
            }
        } else if (this.chunkGenSettings.isBedrock())
            super.generateBedrock(world, random, chunkX, chunkZ, chunkData);
        return chunkData;
    }
}