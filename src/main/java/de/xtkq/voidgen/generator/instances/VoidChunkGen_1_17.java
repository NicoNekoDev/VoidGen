package de.xtkq.voidgen.generator.instances;

import de.xtkq.voidgen.generator.annotations.VoidChunkGenInfo;
import de.xtkq.voidgen.generator.interfaces.ChunkGen3DExtended;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

@VoidChunkGenInfo(versions = {"1.17"})
public final class VoidChunkGen_1_17 extends ChunkGen3DExtended {

    public VoidChunkGen_1_17(JavaPlugin paramPlugin, String paramIdentifier) {
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

        super.generateBedrock(world, random, chunkX, chunkZ, chunkData);
        return chunkData;
    }
}