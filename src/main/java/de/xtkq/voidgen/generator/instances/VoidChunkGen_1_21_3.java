package de.xtkq.voidgen.generator.instances;

import de.xtkq.voidgen.generator.annotations.VoidChunkGenInfo;
import de.xtkq.voidgen.generator.interfaces.ChunkGen;
import de.xtkq.voidgen.generator.settings.LayerSettings;
import de.xtkq.voidgen.utils.VoidBiomeProvider;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

@VoidChunkGenInfo(versions = {"1.21.3", "1.21.4", "1.21.5", "1.21.6"})
public final class VoidChunkGen_1_21_3 extends ChunkGen {

    public VoidChunkGen_1_21_3(JavaPlugin javaPlugin, String paramIdentifier) {
        super(javaPlugin, paramIdentifier);
    }

    @Override
    public Biome getDefaultBiome() {
        return Biome.THE_VOID;
    }

    @Override
    public BiomeProvider getDefaultBiomeProvider(@NotNull WorldInfo worldInfo) {
        return new VoidBiomeProvider(this.chunkGenSettings.getBiome());
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public ChunkData generateChunkData(@NotNull World world, @NotNull Random random, int chunkX, int chunkZ, @NotNull BiomeGrid paramBiomeGrid) {
        ChunkData chunkData = this.createChunkData(world);
        int yOffset = world.getMinHeight();
        if (this.chunkGenSettings.getLayers() != null) {
            for (LayerSettings layer : this.chunkGenSettings.getLayers()) {
                for (int y = 0; y < layer.getHeight(); y++) {
                    yOffset++;
                    for (int x = 0; x < 16; x++) {
                        for (int z = 0; z < 16; z++) {
                            chunkData.setBlock(x, yOffset, z,layer.getBlockData());
                        }
                    }
                }
            }
        } else if (this.chunkGenSettings.isBedrock())
            super.generateBedrock(world, random, chunkX, chunkZ, chunkData);
        return chunkData;
    }
}