package de.xtkq.voidgen.generator.settings;

import com.google.gson.annotations.SerializedName;
import org.bukkit.block.Biome;

public class ChunkGenSettings {

    @SerializedName("biome")
    private Biome biome = Biome.THE_VOID;

    @SerializedName("caves")
    private boolean caves = false;

    @SerializedName("decoration")
    private boolean decoration = false;

    @SerializedName("mobs")
    private boolean mobs = false;

    @SerializedName("structures")
    private boolean structures = false;

    @SerializedName("noise")
    private boolean noise = false;

    @SerializedName("surface")
    private boolean surface = false;

    @SerializedName("bedrock")
    private boolean bedrock = false;

    public Biome getBiome() {
        return this.biome;
    }

    public boolean isCaves() {
        return this.caves;
    }

    public boolean isDecoration() {
        return this.decoration;
    }

    public boolean isMobs() {
        return this.mobs;
    }

    public boolean isStructures() {
        return this.structures;
    }

    public boolean isNoise() {
        return this.noise;
    }

    public boolean isSurface() {
        return this.surface;
    }

    public boolean isBedrock() {
        return this.bedrock;
    }

    public void setBiome(Biome biome) {
        this.biome = biome;
    }

    public void setCaves(boolean caves) {
        this.caves = caves;
    }

    public void setDecoration(boolean decoration) {
        this.decoration = decoration;
    }

    public void setMobs(boolean mobs) {
        this.mobs = mobs;
    }

    public void setStructures(boolean structures) {
        this.structures = structures;
    }

    public void setNoise(boolean noise) {
        this.noise = noise;
    }

    public void setSurface(boolean surface) {
        this.surface = surface;
    }

    public void setBedrock(boolean bedrock) {
        this.bedrock = bedrock;
    }
}
