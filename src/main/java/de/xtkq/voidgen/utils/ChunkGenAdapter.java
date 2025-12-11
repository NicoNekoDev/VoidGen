package de.xtkq.voidgen.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.xtkq.voidgen.generator.settings.ChunkGenSettings;
import de.xtkq.voidgen.generator.settings.LayerSettings;
import org.bukkit.block.Biome;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChunkGenAdapter extends TypeAdapter<ChunkGenSettings> {
    private final JavaPlugin javaPlugin;

    public ChunkGenAdapter(JavaPlugin paramPlugin) {
        this.javaPlugin = paramPlugin;
    }

    @Override
    public void write(JsonWriter jsonWriter, ChunkGenSettings chunkGenSettings) throws IOException {
        jsonWriter.beginObject();
        if (chunkGenSettings.getBiome().isPresent())
            jsonWriter.name("biome").value(chunkGenSettings.getBiome().get().name().toLowerCase());
        if (chunkGenSettings.getCaves().isPresent())
            jsonWriter.name("caves").value(chunkGenSettings.getCaves().get());
        if (chunkGenSettings.getDecoration().isPresent())
            jsonWriter.name("decoration").value(chunkGenSettings.getDecoration().get());
        if (chunkGenSettings.getMobs().isPresent())
            jsonWriter.name("mobs").value(chunkGenSettings.getMobs().get());
        if (chunkGenSettings.getStructures().isPresent())
            jsonWriter.name("structures").value(chunkGenSettings.getStructures().get());
        if (chunkGenSettings.getNoise().isPresent())
            jsonWriter.name("noise").value(chunkGenSettings.getNoise().get());
        if (chunkGenSettings.getSurface().isPresent())
            jsonWriter.name("surface").value(chunkGenSettings.getSurface().get());
        if (chunkGenSettings.getBedrock().isPresent())
            jsonWriter.name("bedrock").value(chunkGenSettings.getBedrock().get());
        if (chunkGenSettings.getLayers().isPresent()) {
            jsonWriter.name("layers").beginArray();
            for (LayerSettings layerSettings : chunkGenSettings.getLayers().get())
                layerSettings.write(jsonWriter);
            jsonWriter.endArray();
        }
        jsonWriter.endObject();
    }

    @Override
    public ChunkGenSettings read(JsonReader jsonReader) throws IOException {
        ChunkGenSettings chunkGenSettings = new ChunkGenSettings();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "biome" -> {
                    String biomeName = jsonReader.nextString();
                    try {
                        chunkGenSettings.setBiome(Biome.valueOf(biomeName.toUpperCase()));
                    } catch (Exception ex) {
                        this.javaPlugin.getLogger().warning("Unknown biome \"" + biomeName + "\" skipped!");
                    }
                }
                case "caves" -> chunkGenSettings.setCaves(jsonReader.nextBoolean());
                case "decoration" -> chunkGenSettings.setDecoration(jsonReader.nextBoolean());
                case "mobs" -> chunkGenSettings.setMobs(jsonReader.nextBoolean());
                case "structures" -> chunkGenSettings.setStructures(jsonReader.nextBoolean());
                case "noise" -> chunkGenSettings.setNoise(jsonReader.nextBoolean());
                case "surface" -> chunkGenSettings.setSurface(jsonReader.nextBoolean());
                case "bedrock" -> chunkGenSettings.setBedrock(jsonReader.nextBoolean());
                case "layers" -> {
                    jsonReader.beginArray();
                    List<LayerSettings> layerSettings = new ArrayList<>();
                    while (jsonReader.hasNext())
                        layerSettings.add(new LayerSettings().read(jsonReader, this.javaPlugin.getLogger()));
                    chunkGenSettings.setLayers(layerSettings);
                    jsonReader.endArray();
                }
                default -> jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return chunkGenSettings;
    }
}
