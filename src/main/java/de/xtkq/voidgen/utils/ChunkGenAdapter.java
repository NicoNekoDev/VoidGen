package de.xtkq.voidgen.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.xtkq.voidgen.generator.settings.ChunkGenSettings;
import de.xtkq.voidgen.generator.settings.LayerSettings;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
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
        if (chunkGenSettings.getLayers() != null) {
            jsonWriter.name("layers").beginArray();
            for (LayerSettings layerSettings : chunkGenSettings.getLayers()) {
                jsonWriter.beginObject();
                jsonWriter.name("material").value(layerSettings.getMaterial().getKey().getKey().toLowerCase());
                jsonWriter.name("size").value(layerSettings.getSize());
                jsonWriter.endObject();
            }
            jsonWriter.endArray();
        }
        jsonWriter.endObject();
    }

    @Override
    public ChunkGenSettings read(JsonReader jsonReader) throws IOException {
        ChunkGenSettings chunkGenSettings = new ChunkGenSettings(Biome.THE_VOID);
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "biome" -> {
                    String biomeName = jsonReader.nextString();
                    Biome biome = Registry.BIOME.get(NamespacedKey.minecraft(biomeName.toUpperCase()));
                    if (biome != null)
                        chunkGenSettings.setBiome(biome);
                    else
                        this.javaPlugin.getLogger().warning("Unknown biome \"" + biomeName + "\" skipped!");
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
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        LayerSettings layer = new LayerSettings();
                        while (jsonReader.hasNext()) {
                            switch (jsonReader.nextName()) {
                                case "material" -> {
                                    String materialName = jsonReader.nextString();
                                    Material material = Registry.MATERIAL.get(NamespacedKey.minecraft(materialName.toUpperCase()));
                                    if (material != null)
                                        layer.setMaterial(material);
                                    else
                                        this.javaPlugin.getLogger().warning("Unknown material \"" + materialName + "\" skipped!");
                                }
                                case "size" -> {
                                    int size = jsonReader.nextInt();
                                    if (size < 0) {
                                        this.javaPlugin.getLogger().warning("Layer size cannot be less than 0!");
                                        size = 1;
                                    }
                                    layer.setSize(size);
                                }
                            }
                        }
                        layerSettings.add(layer);
                        jsonReader.endObject();
                    }
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
