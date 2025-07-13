package de.xtkq.voidgen.generator.instances;

import de.xtkq.voidgen.generator.annotations.VoidChunkGenInfo;
import de.xtkq.voidgen.generator.interfaces.ChunkGen3D;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

@VoidChunkGenInfo(versions = {"1.15", "1.15.1", "1.15.2", "1.16.1", "1.16.2", "1.16.3", "1.16.4", "1.16.5"})
public final class VoidChunkGen_1_15 extends ChunkGen3D {

    public VoidChunkGen_1_15(JavaPlugin paramPlugin, String paramIdentifier) {
        super(paramPlugin, paramIdentifier);
    }

    @Override
    public Biome getDefaultBiome() {
        return Biome.PLAINS;
    }

    @NotNull
    @SuppressWarnings("deprecation")
    @Override
    public ChunkData generateChunkData(@NotNull World world, @NotNull Random random, int chunkX, int chunkZ, @NotNull BiomeGrid paramBiomeGrid) {
        ChunkData chunkData = this.createChunkData(world);
        this.setBiomeGrid(paramBiomeGrid, chunkData);

        super.generateBedrock(world, random, chunkX, chunkZ, chunkData);
//        this.placeBedrock(chunkData, ChunkX, ChunkZ);
        return chunkData;
    }
}