package de.xtkq.voidgen.generator.instances;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.Strictness;
import de.xtkq.voidgen.generator.annotations.VoidChunkGenInfo;
import de.xtkq.voidgen.generator.interfaces.ChunkGen3D;
import de.xtkq.voidgen.generator.settings.ChunkGenSettings;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Random;

@VoidChunkGenInfo(versions = {"1.15", "1.15.1", "1.15.2", "1.16.1", "1.16.2", "1.16.3", "1.16.4", "1.16.5"})
public class VoidChunkGen_1_15 extends ChunkGen3D {

    public VoidChunkGen_1_15(JavaPlugin paramPlugin, String paramIdentifier) {
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

    @NotNull
    @SuppressWarnings("deprecation")
    @Override
    public ChunkData generateChunkData(@NotNull World world, @NotNull Random random, int chunkX, int chunkZ, @NotNull BiomeGrid paramBiomeGrid) {
        ChunkData chunkData = this.createChunkData(world);
        this.setBiomeGrid(paramBiomeGrid, chunkData);

        super.generateBedrock(world, random, chunkX, chunkZ, chunkData);
//        this.placeBedrock(chunkData, ChunkX, ChunkZ);
        return chunkData;
    }
}