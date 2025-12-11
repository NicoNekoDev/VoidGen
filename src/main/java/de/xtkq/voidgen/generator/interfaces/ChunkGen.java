package de.xtkq.voidgen.generator.interfaces;

import com.google.gson.*;
import de.xtkq.voidgen.generator.settings.ChunkGenSettings;
import de.xtkq.voidgen.settings.Settings;
import de.xtkq.voidgen.utils.ChunkGenAdapter;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public abstract class ChunkGen extends ChunkGenerator {

    private final JavaPlugin javaPlugin;
    protected ChunkGenSettings chunkGenSettings;

    public ChunkGen(JavaPlugin javaPlugin, String paramIdentifier, String worldName) {
        this.javaPlugin = javaPlugin;
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(ChunkGenSettings.class, new ChunkGenAdapter(this.javaPlugin));
        builder.setStrictness(Strictness.LENIENT);
        Gson gson = builder.create();
        // Posting the currently used chunkGenSettings to console.
        if (Settings.ENABLE_VERBOSE.get()) {
            this.javaPlugin.getLogger().info("");
            this.javaPlugin.getLogger().info("> ——————————————————————[ " + worldName + " ]——————————————————————");
            this.javaPlugin.getLogger().info("> ");
        }
        if (paramIdentifier == null || paramIdentifier.isBlank()) {
            this.chunkGenSettings = new ChunkGenSettings().setBiome(this.getDefaultBiome());
            if (Settings.ENABLE_VERBOSE.get())
                this.javaPlugin.getLogger().info("> Generator settings have not been set, we will use the default settings:");
        } else {
            try {
                this.chunkGenSettings = gson.fromJson(paramIdentifier, ChunkGenSettings.class);
                if (Settings.ENABLE_VERBOSE.get())
                    this.javaPlugin.getLogger().info("> Generator settings have been loaded:");
            } catch (JsonSyntaxException jse) {
                this.chunkGenSettings = new ChunkGenSettings().setBiome(this.getDefaultBiome());
                if (Settings.ENABLE_VERBOSE.get())
                    this.javaPlugin.getLogger().info("> Generator settings syntax is not valid, we will use the default settings:");
            }
        }
        if (Settings.ENABLE_VERBOSE.get()) {
            this.javaPlugin.getLogger().info("> " + gson.toJson(this.chunkGenSettings));
            this.javaPlugin.getLogger().info("> ");
            this.javaPlugin.getLogger().info("> ——————————————————————[ " + worldName + " ]——————————————————————");
            this.javaPlugin.getLogger().info("");
        }
    }

    public abstract Biome getDefaultBiome();

    @Override
    public Location getFixedSpawnLocation(@NotNull World world, @NotNull Random random) {
        return new Location(world, 0d, 64d, 0d);
    }

    @Override
    public boolean shouldGenerateCaves() {
        return this.chunkGenSettings.getCaves().orElse(false);
    }

    @Override
    public boolean shouldGenerateDecorations() {
        return this.chunkGenSettings.getDecoration().orElse(false);
    }

    @Override
    public boolean shouldGenerateMobs() {
        return this.chunkGenSettings.getMobs().orElse(false);
    }

    @Override
    public boolean shouldGenerateStructures() {
        return this.chunkGenSettings.getStructures().orElse(false);
    }

    @Override
    public boolean shouldGenerateNoise() {
        return this.chunkGenSettings.getNoise().orElse(false);
    }

    @Override
    public boolean shouldGenerateSurface() {
        return this.chunkGenSettings.getSurface().orElse(false);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldGenerateBedrock() {
        return this.chunkGenSettings.getBedrock().orElse(false);
    }

    @Override
    public void generateBedrock(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkData chunkData) {
        // Bedrock block position
        final int x = 0, y = 64, z = 0;

        if ((x >= chunkX * 16) && (x < (chunkX + 1) * 16)) {
            if ((z >= chunkZ * 16) && (z < (chunkZ + 1) * 16)) {
                chunkData.setBlock(x, y, z, Material.BEDROCK);
            }
        }
    }
}
