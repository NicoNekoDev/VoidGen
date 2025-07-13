package de.xtkq.voidgen.generator.instances;

import de.xtkq.voidgen.generator.annotations.VoidChunkGenInfo;
import de.xtkq.voidgen.generator.interfaces.ChunkGen;
import de.xtkq.voidgen.utils.VoidBiomeProvider;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

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
}