package de.xtkq.voidgen.generator.instances;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.xtkq.voidgen.generator.annotations.VoidChunkGenInfo;
import de.xtkq.voidgen.generator.interfaces.ChunkGen;
import de.xtkq.voidgen.generator.settings.ChunkGenSettings;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@VoidChunkGenInfo(versions = {"1.21.3", "1.21.4"})
public class VoidChunkGen_1_21_3 extends ChunkGen {

    public VoidChunkGen_1_21_3(JavaPlugin javaPlugin, String paramIdentifier) {
        super(javaPlugin);
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(ChunkGenSettings.class, new ChunkGenAdapter());
        builder.setStrictness(Strictness.LENIENT);
        Gson gson = builder.create();

        if (paramIdentifier == null || paramIdentifier.isBlank()) {
            this.chunkGenSettings = new ChunkGenSettings();
            this.javaPlugin.getLogger().info("Generator settings have not been set. Using default values:");
        } else {
            try {
                this.chunkGenSettings = gson.fromJson(paramIdentifier, ChunkGenSettings.class);
            } catch (JsonSyntaxException jse) {
                this.chunkGenSettings = new ChunkGenSettings();
                this.javaPlugin.getLogger().info("Generator settings \"" + paramIdentifier + "\" syntax is not valid. Using default values:");
            }
        }
        // Posting the currently used chunkGenSettings to console.
        this.javaPlugin.getLogger().info(gson.toJson(chunkGenSettings));
    }

    @Override
    public BiomeProvider getDefaultBiomeProvider(@NotNull WorldInfo worldInfo) {
        if (Objects.isNull(this.chunkGenSettings.getBiome())) {
            return null;
        } else {
            return new VoidBiomeProvider(this.chunkGenSettings.getBiome());
        }
    }

    private static class VoidBiomeProvider extends BiomeProvider {
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

    private static class ChunkGenAdapter extends TypeAdapter<ChunkGenSettings> {

        @SuppressWarnings("deprecation")
        @Override
        public void write(JsonWriter jsonWriter, ChunkGenSettings chunkGenSettings) throws IOException {
            jsonWriter.beginObject();
            Biome biome = chunkGenSettings.getBiome();
            if (biome != null) {
                NamespacedKey key = biome.getKey();
                jsonWriter.name("biome").value(key.getKey().toLowerCase());
            }
            jsonWriter.name("caves").value(chunkGenSettings.isCaves());
            jsonWriter.name("decoration").value(chunkGenSettings.isDecoration());
            jsonWriter.name("mobs").value(chunkGenSettings.isMobs());
            jsonWriter.name("structures").value(chunkGenSettings.isStructures());
            jsonWriter.name("noise").value(chunkGenSettings.isNoise());
            jsonWriter.name("surface").value(chunkGenSettings.isSurface());
            jsonWriter.name("bedrock").value(chunkGenSettings.isBedrock());
            jsonWriter.endObject();
        }

        @Override
        public ChunkGenSettings read(JsonReader jsonReader) throws IOException {
            ChunkGenSettings chunkGenSettings = new ChunkGenSettings();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "biome" ->
                            chunkGenSettings.setBiome(Registry.BIOME.get(NamespacedKey.minecraft(jsonReader.nextString().toLowerCase())));
                    case "caves" -> chunkGenSettings.setCaves(jsonReader.nextBoolean());
                    case "decoration" -> chunkGenSettings.setDecoration(jsonReader.nextBoolean());
                    case "mobs" -> chunkGenSettings.setMobs(jsonReader.nextBoolean());
                    case "structures" -> chunkGenSettings.setStructures(jsonReader.nextBoolean());
                    case "noise" -> chunkGenSettings.setNoise(jsonReader.nextBoolean());
                    case "surface" -> chunkGenSettings.setSurface(jsonReader.nextBoolean());
                    case "bedrock" -> chunkGenSettings.setBedrock(jsonReader.nextBoolean());
                    default -> jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return chunkGenSettings;
        }
    }
}