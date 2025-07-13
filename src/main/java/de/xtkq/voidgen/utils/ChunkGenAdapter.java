package de.xtkq.voidgen.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.xtkq.voidgen.generator.settings.ChunkGenSettings;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.block.Biome;

import java.io.IOException;

public class ChunkGenAdapter extends TypeAdapter<ChunkGenSettings> {

    @SuppressWarnings("deprecation")
    @Override
    public void write(JsonWriter jsonWriter, ChunkGenSettings chunkGenSettings) throws IOException {
        jsonWriter.beginObject();
        Biome biome = chunkGenSettings.getBiome();
        jsonWriter.name("biome").value(biome.getKey().getKey().toLowerCase());
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
        ChunkGenSettings chunkGenSettings = new ChunkGenSettings(Biome.THE_VOID);
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "biome" -> {
                    Biome biome = Registry.BIOME.get(NamespacedKey.minecraft(jsonReader.nextString().toLowerCase()));
                    if (biome != null)
                        chunkGenSettings.setBiome(biome);
                }
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
