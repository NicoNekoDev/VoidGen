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

@VoidChunkGenInfo(versions = {"1.17.1", "1.18", "1.18.1", "1.18.2"})
public final class VoidChunkGen_1_17_1 extends ChunkGen {

    public VoidChunkGen_1_17_1(JavaPlugin javaPlugin, String paramIdentifier, String worldName) {
        super(javaPlugin, paramIdentifier, worldName);
    }

    @Override
    public Biome getDefaultBiome() {
        return Biome.PLAINS;
    }

    @Override
    public BiomeProvider getDefaultBiomeProvider(@NotNull WorldInfo worldInfo) {
        return this.chunkGenSettings.getBiome().map(biome -> (BiomeProvider) new VoidBiomeProvider(biome)).orElse(super.getDefaultBiomeProvider(worldInfo));
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public ChunkData generateChunkData(@NotNull World world, @NotNull Random random, int chunkX, int chunkZ, @NotNull BiomeGrid paramBiomeGrid) {
        ChunkData chunkData = this.createChunkData(world);
        int yOffset = 0;
        if (this.chunkGenSettings.getLayers().isPresent()) {
            for (LayerSettings layer : this.chunkGenSettings.getLayers().get()) {
                for (int y = 0; y < layer.getHeight(); y++) {
                    for (int x = 0; x < 16; x++) {
                        for (int z = 0; z < 16; z++) {
                            chunkData.setBlock(x, yOffset, z, layer.composeBlockData());
                        }
                    }
                    yOffset++;
                }
            }
        } else if (this.chunkGenSettings.getBedrock().orElse(false))
            super.generateBedrock(world, random, chunkX, chunkZ, chunkData);
        return chunkData;
    }
}