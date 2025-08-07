package de.xtkq.voidgen.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.xtkq.voidgen.generator.settings.BlockDataSettings;
import de.xtkq.voidgen.generator.settings.ChunkGenSettings;
import de.xtkq.voidgen.generator.settings.LayerSettings;
import org.bukkit.CropState;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.data.type.Switch;
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
        jsonWriter.name("biome").value(chunkGenSettings.getBiome().name().toLowerCase());
        if (chunkGenSettings.isCaves())
            jsonWriter.name("caves").value(chunkGenSettings.isCaves());
        if (chunkGenSettings.isDecoration())
            jsonWriter.name("decoration").value(chunkGenSettings.isDecoration());
        if (chunkGenSettings.isMobs())
            jsonWriter.name("mobs").value(chunkGenSettings.isMobs());
        if (chunkGenSettings.isStructures())
            jsonWriter.name("structures").value(chunkGenSettings.isStructures());
        if (chunkGenSettings.isNoise())
            jsonWriter.name("noise").value(chunkGenSettings.isNoise());
        if (chunkGenSettings.isSurface())
            jsonWriter.name("surface").value(chunkGenSettings.isSurface());
        if (chunkGenSettings.isBedrock())
            jsonWriter.name("bedrock").value(chunkGenSettings.isBedrock());
        if (chunkGenSettings.getLayers() != null) {
            jsonWriter.name("layers").beginArray();
            for (LayerSettings layerSettings : chunkGenSettings.getLayers()) {
                jsonWriter.beginObject();
                jsonWriter.name("block").value(layerSettings.getMaterial().name().toLowerCase());
                jsonWriter.name("height").value(layerSettings.getHeight());
                if (layerSettings.getData() != null) {
                    jsonWriter.name("data").beginObject();
                    BlockDataSettings data = layerSettings.getData();
                    if (data.getWaterlogged() != null)
                        jsonWriter.name("waterlogged").value(data.getWaterlogged());
                    if (data.getSwitchFace() != null)
                        jsonWriter.name("switch_face").value(data.getSwitchFace().name().toLowerCase());
                    if (data.getDoorHinge() != null)
                        jsonWriter.name("door_hinge").value(data.getDoorHinge().name().toLowerCase());
                    if (data.getIsInWall() != null)
                        jsonWriter.name("in_wall").value(data.getIsInWall());
                    if (data.getFacing() != null)
                        jsonWriter.name("facing").value(data.getFacing().name().toLowerCase());
                    if (data.getOpen() != null)
                        jsonWriter.name("open").value(data.getOpen());
                    if (data.getPower() != null)
                        jsonWriter.name("power").value(data.getPower());
                    if (data.getAttached() != null)
                        jsonWriter.name("attached").value(data.getAttached());
                    if (data.getRotation() != null)
                        jsonWriter.name("rotation").value(data.getRotation().name().toLowerCase());
                    if (data.getLeavesDistance() != null)
                        jsonWriter.name("leaves_distance").value(data.getLeavesDistance());
                    if (data.getLeavesPersistent() != null)
                        jsonWriter.name("leaves_persistent").value(data.getLeavesPersistent());
                    if (data.getAxis() != null)
                        jsonWriter.name("axis").value(data.getAxis().name().toLowerCase());
                    if (data.getAge() != null)
                        jsonWriter.name("age").value(data.getAge());
                    if (data.getSculkPhase() != null)
                        jsonWriter.name("sculk_phase").value(data.getSculkPhase().name().toLowerCase());
                    if (data.getInverted() != null)
                        jsonWriter.name("inverted").value(data.getInverted());
                    if (data.getCropState() != null)
                        jsonWriter.name("crop_state").value(data.getCropState().name().toLowerCase());
                    if (data.getColor() != null)
                        jsonWriter.name("color").value(data.getColor().name().toLowerCase());
                    if (data.getBedPart() != null)
                        jsonWriter.name("bed_part").value(data.getBedPart().name().toLowerCase());
                    if (data.getHoneyLevel() != null)
                        jsonWriter.name("honey_level").value(data.getHoneyLevel());
                    if (data.getDripleafTilt() != null)
                        jsonWriter.name("dripleaf_tilt").value(data.getDripleafTilt().name().toLowerCase());
                    if (data.getBisectedHalf() != null)
                        jsonWriter.name("bisected_half").value(data.getBisectedHalf().name().toLowerCase());
                    if (data.getCakeBites() != null)
                        jsonWriter.name("cake_bites").value(data.getCakeBites());
                    if (data.getSignalFire() != null)
                        jsonWriter.name("signal_fire").value(data.getSignalFire());
                    if (data.getCandles() != null)
                        jsonWriter.name("candles").value(data.getCandles());
                    if (data.getLit() != null)
                        jsonWriter.name("lit").value(data.getLit());
                    if (data.getBerries() != null)
                        jsonWriter.name("berries").value(data.getBerries());
                    if (data.getConditional() != null)
                        jsonWriter.name("conditional").value(data.getConditional());
                    if (data.getComparatorMode() != null)
                        jsonWriter.name("comparator_mode").value(data.getComparatorMode().name().toLowerCase());
                    if (data.getCrafterOrientation() != null)
                        jsonWriter.name("crafter_orientation").value(data.getCrafterOrientation().name().toLowerCase());
                    if (data.getCrafterTriggered() != null)
                        jsonWriter.name("crafter_triggered").value(data.getCrafterTriggered());
                    jsonWriter.endObject();
                }
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
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        LayerSettings layer = new LayerSettings();
                        while (jsonReader.hasNext()) {
                            switch (jsonReader.nextName()) {
                                case "block" -> {
                                    String materialString = jsonReader.nextString();
                                    try {
                                        Material material = Material.valueOf(materialString.toUpperCase());
                                        if (material.isAir() || material.isBlock())
                                            layer.setMaterial(material);
                                        else
                                            this.javaPlugin.getLogger().warning("Material type \"" + materialString + "\" is not a block!");
                                    } catch (Exception ex) {
                                        this.javaPlugin.getLogger().warning("Unknown material type \"" + materialString + "\", skipped!");
                                    }
                                }
                                case "height" -> {
                                    int height = jsonReader.nextInt();
                                    if (height < 0) {
                                        this.javaPlugin.getLogger().warning("Layer height cannot be less than 0!");
                                        height = 1;
                                    }
                                    layer.setHeight(height);
                                }
                                case "data" -> {
                                    BlockDataSettings blockDataSettings = new BlockDataSettings();
                                    jsonReader.beginObject();
                                    while (jsonReader.hasNext()) {
                                        switch (jsonReader.nextName()) {
                                            case "waterlogged" ->
                                                    blockDataSettings.setWaterlogged(jsonReader.nextBoolean());
                                            case "switch_face" -> {
                                                try {
                                                    blockDataSettings.setSwitchFace(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown switch face \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                        }
                                    }
                                    jsonReader.endObject();
                                    layer.setData(blockDataSettings);
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
