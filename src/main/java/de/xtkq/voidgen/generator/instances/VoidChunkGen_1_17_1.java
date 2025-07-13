package de.xtkq.voidgen.generator.instances;

import de.xtkq.voidgen.generator.annotations.VoidChunkGenInfo;
import de.xtkq.voidgen.generator.interfaces.ChunkGen;
import de.xtkq.voidgen.utils.VoidBiomeProvider;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@VoidChunkGenInfo(versions = {"1.17.1", "1.18", "1.18.1", "1.18.2"})
public final class VoidChunkGen_1_17_1 extends ChunkGen {

    public VoidChunkGen_1_17_1(JavaPlugin javaPlugin, String paramIdentifier) {
        super(javaPlugin, paramIdentifier);
    }

    @Override
    public Biome getDefaultBiome() {
        return Biome.PLAINS;
    }

    @Override
    public BiomeProvider getDefaultBiomeProvider(@NotNull WorldInfo worldInfo) {
        return new VoidBiomeProvider(this.chunkGenSettings.getBiome());
    }
}