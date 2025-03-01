package de.xtkq.voidgen.generator.settings;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.Biome;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
public class ChunkGenSettings {

    public ChunkGenSettings(@NotNull Biome defaultBiome) {
        this.biome = defaultBiome;
    }

    @SerializedName("biome")
    @NotNull
    private Biome biome;

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
}
