package de.xtkq.voidgen.generator.settings;

import org.bukkit.block.Biome;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class ChunkGenSettings {
    @Nullable
    private Biome biome;

    public Optional<Biome> getBiome() {
        return Optional.ofNullable(this.biome);
    }

    public ChunkGenSettings setBiome(@Nullable Biome biome) {
        this.biome = biome;
        return this;
    }

    @Nullable
    private Boolean caves;

    public Optional<Boolean> getCaves() {
        return Optional.ofNullable(this.caves);
    }

    public ChunkGenSettings setCaves(@Nullable Boolean caves) {
        this.caves = caves;
        return this;
    }

    @Nullable
    private Boolean decoration;

    public Optional<Boolean> getDecoration() {
        return Optional.ofNullable(this.decoration);
    }

    public ChunkGenSettings setDecoration(@Nullable Boolean decoration) {
        this.decoration = decoration;
        return this;
    }

    @Nullable
    private Boolean mobs;

    public Optional<Boolean> getMobs() {
        return Optional.ofNullable(this.mobs);
    }

    public ChunkGenSettings setMobs(@Nullable Boolean mobs) {
        this.mobs = mobs;
        return this;
    }

    @Nullable
    private Boolean structures;

    public Optional<Boolean> getStructures() {
        return Optional.ofNullable(this.structures);
    }

    public ChunkGenSettings setStructures(@Nullable Boolean structures) {
        this.structures = structures;
        return this;
    }

    @Nullable
    private Boolean noise;

    public Optional<Boolean> getNoise() {
        return Optional.ofNullable(this.noise);
    }

    public ChunkGenSettings setNoise(@Nullable Boolean noise) {
        this.noise = noise;
        return this;
    }

    @Nullable
    private Boolean surface;

    public Optional<Boolean> getSurface() {
        return Optional.ofNullable(this.surface);
    }

    public ChunkGenSettings setSurface(@Nullable Boolean surface) {
        this.surface = surface;
        return this;
    }

    @Nullable
    private Boolean bedrock;

    public Optional<Boolean> getBedrock() {
        return Optional.ofNullable(this.bedrock);
    }

    public ChunkGenSettings setBedrock(@Nullable Boolean bedrock) {
        this.bedrock = bedrock;
        return this;
    }

    @Nullable
    private List<LayerSettings> layers;

    public Optional<List<LayerSettings>> getLayers() {
        return Optional.ofNullable(this.layers);
    }

    public ChunkGenSettings setLayers(List<LayerSettings> layers) {
        this.layers = layers;
        return this;
    }
}
