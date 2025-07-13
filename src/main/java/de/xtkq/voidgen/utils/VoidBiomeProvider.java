package de.xtkq.voidgen.utils;

import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class VoidBiomeProvider extends BiomeProvider {
    private final Biome biome;

    public VoidBiomeProvider(Biome paramBiome) {
        this.biome = paramBiome;
    }

    @NotNull
    @Override
    public Biome getBiome(@NotNull WorldInfo worldInfo, int x, int y, int z) {
        return this.biome;
    }

    @NotNull
    @Override
    public List<Biome> getBiomes(@NotNull WorldInfo worldInfo) {
        return Collections.singletonList(this.biome);
    }
}