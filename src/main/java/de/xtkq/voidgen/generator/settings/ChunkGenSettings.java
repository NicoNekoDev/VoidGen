package de.xtkq.voidgen.generator.settings;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.Biome;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Getter
@Setter
public class ChunkGenSettings {

    public ChunkGenSettings(@NotNull Biome defaultBiome) {
        this.biome = defaultBiome;
    }

    @NotNull
    private Biome biome;

    private boolean caves = false;

    private boolean decoration = false;

    private boolean mobs = false;

    private boolean structures = false;

    private boolean noise = false;

    private boolean surface = false;

    private boolean bedrock = false;

    @Nullable
    private List<LayerSettings> layers;
}
