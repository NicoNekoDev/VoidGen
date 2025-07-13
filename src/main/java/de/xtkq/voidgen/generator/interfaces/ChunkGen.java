package de.xtkq.voidgen.generator.interfaces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.Strictness;
import de.xtkq.voidgen.generator.settings.ChunkGenSettings;
import de.xtkq.voidgen.utils.ChunkGenAdapter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public abstract class ChunkGen extends ChunkGenerator {

    protected ChunkGenSettings chunkGenSettings;
    protected JavaPlugin javaPlugin;

    public ChunkGen(JavaPlugin paramPlugin, String paramIdentifier) {
        this.javaPlugin = paramPlugin;
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(ChunkGenSettings.class, new ChunkGenAdapter());
        builder.setStrictness(Strictness.LENIENT);
        Gson gson = builder.create();

        if (paramIdentifier == null || paramIdentifier.isBlank()) {
            this.chunkGenSettings = new ChunkGenSettings(this.getDefaultBiome());
            this.javaPlugin.getLogger().warning("Generator settings have not been set. Using default values:");
        } else {
            try {
                this.chunkGenSettings = gson.fromJson(paramIdentifier, ChunkGenSettings.class);
            } catch (JsonSyntaxException jse) {
                this.chunkGenSettings = new ChunkGenSettings(this.getDefaultBiome());
                this.javaPlugin.getLogger().warning("Generator settings \"" + paramIdentifier + "\" syntax is not valid. Using default values:");
            }
        }
        // Posting the currently used chunkGenSettings to console.
        this.javaPlugin.getLogger().warning(gson.toJson(chunkGenSettings));
    }

    public abstract Biome getDefaultBiome();

    @Override
    public Location getFixedSpawnLocation(@NotNull World world, @NotNull Random random) {
        return new Location(world, 0d, 64d, 0d);
    }

    @Override
    public boolean shouldGenerateCaves() {
        return this.chunkGenSettings.isCaves();
    }

    @Override
    public boolean shouldGenerateDecorations() {
        return this.chunkGenSettings.isDecoration();
    }

    @Override
    public boolean shouldGenerateMobs() {
        return this.chunkGenSettings.isMobs();
    }

    @Override
    public boolean shouldGenerateStructures() {
        return this.chunkGenSettings.isStructures();
    }

    @Override
    public boolean shouldGenerateNoise() {
        return this.chunkGenSettings.isNoise();
    }

    @Override
    public boolean shouldGenerateSurface() {
        return this.chunkGenSettings.isSurface();
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldGenerateBedrock() {
        return this.chunkGenSettings.isBedrock();
    }

    protected void placeBedrock(ChunkData paramChunkData, int paramChunkX, int paramChunkZ) {
        // Bedrock block position
        int x = 0, y = 64, z = 0;

        if ((x >= paramChunkX * 16) && (x < (paramChunkX + 1) * 16)) {
            if ((z >= paramChunkZ * 16) && (z < (paramChunkZ + 1) * 16)) {
                paramChunkData.setBlock(x, y, z, Material.BEDROCK);
            }
        }
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
