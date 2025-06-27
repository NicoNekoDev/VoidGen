package de.xtkq.voidgen.generator.instances;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.Strictness;
import de.xtkq.voidgen.generator.annotations.VoidChunkGenInfo;
import de.xtkq.voidgen.generator.interfaces.ChunkGen3DExtended;
import de.xtkq.voidgen.generator.settings.ChunkGenSettings;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Random;

@VoidChunkGenInfo(versions = {"1.17"})
public class VoidChunkGen_1_17 extends ChunkGen3DExtended {

    public VoidChunkGen_1_17(JavaPlugin paramPlugin, String paramIdentifier) {
        super(paramPlugin);
        GsonBuilder builder = new GsonBuilder();
        builder.setStrictness(Strictness.LENIENT);
        Gson gson = builder.create();

        if (paramIdentifier == null || paramIdentifier.isBlank()) {
            this.chunkGenSettings = new ChunkGenSettings(Biome.PLAINS);
            this.javaPlugin.getLogger().warning("Generator settings have not been set. Using default values:");
        } else {
            try {
                this.chunkGenSettings = gson.fromJson(paramIdentifier, ChunkGenSettings.class);
            } catch (JsonSyntaxException jse) {
                this.chunkGenSettings = new ChunkGenSettings(Biome.PLAINS);
                this.javaPlugin.getLogger().warning("Generator settings \"" + paramIdentifier + "\" syntax is not valid. Using default values:");
            }
        }
        // Posting the currently used chunkGenSettings to console.
        this.javaPlugin.getLogger().warning(gson.toJson(chunkGenSettings));
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