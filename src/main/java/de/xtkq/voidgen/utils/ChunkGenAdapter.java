package de.xtkq.voidgen.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.xtkq.voidgen.generator.settings.BlockDataSettings;
import de.xtkq.voidgen.generator.settings.ChunkGenSettings;
import de.xtkq.voidgen.generator.settings.LayerSettings;
import org.bukkit.Material;
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
                    if (data.getBellAttachment() != null)
                        jsonWriter.name("bell_attachment").value(data.getBellAttachment().name().toLowerCase());
                    if (data.getDripleafTilt() != null)
                        jsonWriter.name("dripleaf_tilt").value(data.getDripleafTilt().name().toLowerCase());
                    if (data.getBisectedHalf() != null)
                        jsonWriter.name("bisected_half").value(data.getBisectedHalf().name().toLowerCase());
                    if (data.getBubbleDrag() != null)
                        jsonWriter.name("bubble_drag").value(data.getBubbleDrag());
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
                    if (data.getChestType() != null)
                        jsonWriter.name("chest_type").value(data.getChestType().name().toLowerCase());
                    if (data.getConditional() != null)
                        jsonWriter.name("conditional").value(data.getConditional());
                    if (data.getComparatorMode() != null)
                        jsonWriter.name("comparator_mode").value(data.getComparatorMode().name().toLowerCase());
                    if (data.getCrafterOrientation() != null)
                        jsonWriter.name("crafter_orientation").value(data.getCrafterOrientation().name().toLowerCase());
                    if (data.getCrafterTriggered() != null)
                        jsonWriter.name("crafter_triggered").value(data.getCrafterTriggered());
                    if (data.getEnderEye() != null)
                        jsonWriter.name("ender_eye").value(data.getEnderEye());
                    if (data.getMoisture() != null)
                        jsonWriter.name("moisture").value(data.getMoisture());
                    if (data.getHanging() != null)
                        jsonWriter.name("hanging").value(data.getHanging());
                    if (data.getHatch() != null)
                        jsonWriter.name("hatch").value(data.getHatch());
                    if (data.getHopperEnabled() != null)
                        jsonWriter.name("hopper_enabled").value(data.getHopperEnabled());
                    if (data.getJigsawOrientation() != null)
                        jsonWriter.name("jigsaw_orientation").value(data.getJigsawOrientation().name().toLowerCase());
                    if (data.getLevel() != null)
                        jsonWriter.name("level").value(data.getLevel());
                    if (data.getInstrument() != null)
                        jsonWriter.name("instrument").value(data.getInstrument().name().toLowerCase());
                    if (data.getNote() != null)
                        jsonWriter.name("note").value(data.getNote());
                    if (data.getExtended() != null)
                        jsonWriter.name("extended").value(data.getExtended());
                    if (data.getDripstoneThickness() != null)
                        jsonWriter.name("dripstone_thickness").value(data.getDripstoneThickness().name().toLowerCase());
                    if (data.getDripstoneVerticalDirection() != null)
                        jsonWriter.name("dripstone_vertical_direction").value(data.getDripstoneVerticalDirection().name().toLowerCase());
                    if (data.getRailShape() != null)
                        jsonWriter.name("rail_shape").value(data.getRailShape().name().toLowerCase());
                    if (data.getRepeaterDelay() != null)
                        jsonWriter.name("repeater_delay").value(data.getRepeaterDelay());
                    if (data.getRepeaterLocked() != null)
                        jsonWriter.name("repeater_locked").value(data.getRepeaterLocked());
                    if (data.getCharges() != null)
                        jsonWriter.name("charges").value(data.getCharges());
                    if (data.getScaffoldingDistance() != null)
                        jsonWriter.name("scaffolding_distance").value(data.getScaffoldingDistance());
                    if (data.getScaffoldingBottom() != null)
                        jsonWriter.name("scaffolding_bottom").value(data.getScaffoldingBottom());
                    if (data.getSculkShriekerCanSummon() != null)
                        jsonWriter.name("sculk_shrieker_can_summon").value(data.getSculkShriekerCanSummon());
                    if (data.getSculkCatalystBloom() != null)
                        jsonWriter.name("sculk_catalyst_bloom").value(data.getSculkCatalystBloom());
                    if (data.getPickles() != null)
                        jsonWriter.name("pickles").value(data.getPickles());
                    if (data.getSlabType() != null)
                        jsonWriter.name("slab_type").value(data.getSlabType().name().toLowerCase());
                    if (data.getSnowLayers() != null)
                        jsonWriter.name("snow_layers").value(data.getSnowLayers());
                    if (data.getStairsShape() != null)
                        jsonWriter.name("stairs_shape").value(data.getStairsShape().name().toLowerCase());
                    if (data.getStructureBlockMode() != null)
                        jsonWriter.name("structure_block_mode").value(data.getStructureBlockMode().name().toLowerCase());
                    if (data.getPistonType() != null)
                        jsonWriter.name("piston_type").value(data.getPistonType().name().toLowerCase());
                    if (data.getTrialSpawnerOminous() != null)
                        jsonWriter.name("trial_spawner_ominous").value(data.getTrialSpawnerOminous());
                    if (data.getTrialSpawnerState() != null)
                        jsonWriter.name("trial_spawner_state").value(data.getTrialSpawnerState().name().toLowerCase());
                    if (data.getVaultState() != null)
                        jsonWriter.name("vault_state").value(data.getVaultState().name().toLowerCase());
                    if (data.getTripwireHookDisarmed() != null)
                        jsonWriter.name("tripwire_hook_disarmed").value(data.getTripwireHookDisarmed());
                    if (data.getTurtleEggs() != null)
                        jsonWriter.name("turtle_eggs").value(data.getTurtleEggs());
                    if (data.getDusted() != null)
                        jsonWriter.name("dusted").value(data.getDusted());
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
                                            case "door_hinge" -> {
                                                try {
                                                    blockDataSettings.setDoorHinge(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown door hinge \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "in_wall" -> blockDataSettings.setIsInWall(jsonReader.nextBoolean());
                                            case "facing" -> {
                                                try {
                                                    blockDataSettings.setFacing(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown facing \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "open" -> blockDataSettings.setOpen(jsonReader.nextBoolean());
                                            case "power" -> blockDataSettings.setPower(jsonReader.nextInt());
                                            case "attached" -> blockDataSettings.setAttached(jsonReader.nextBoolean());
                                            case "rotation" -> {
                                                try {
                                                    blockDataSettings.setRotation(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown rotation \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "leaves_distance" ->
                                                    blockDataSettings.setLeavesDistance(jsonReader.nextInt());
                                            case "leaves_persistent" ->
                                                    blockDataSettings.setLeavesPersistent(jsonReader.nextBoolean());
                                            case "axis" -> {
                                                try {
                                                    blockDataSettings.setAxis(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown axis \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "age" -> blockDataSettings.setAge(jsonReader.nextInt());
                                            case "sculk_phase" -> {
                                                try {
                                                    blockDataSettings.setSculkPhase(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown sculk phase \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "inverted" -> blockDataSettings.setInverted(jsonReader.nextBoolean());
                                            case "crop_state" -> {
                                                try {
                                                    blockDataSettings.setCropState(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown crop state \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "color" -> {
                                                try {
                                                    blockDataSettings.setColor(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown color \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "bed_part" -> {
                                                try {
                                                    blockDataSettings.setBedPart(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown bed part \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "honey_level" -> blockDataSettings.setHoneyLevel(jsonReader.nextInt());
                                            case "bell_attachment" -> {
                                                try {
                                                    blockDataSettings.setBellAttachment(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown bell attachment \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "dripleaf_tilt" -> {
                                                try {
                                                    blockDataSettings.setDripleafTilt(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown dripleaf tilt \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "bisected_half" -> {
                                                try {
                                                    blockDataSettings.setBisectedHalf(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown bisected half \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "bubble_drag" ->
                                                    blockDataSettings.setBubbleDrag(jsonReader.nextBoolean());
                                            case "cake_bites" -> blockDataSettings.setCakeBites(jsonReader.nextInt());
                                            case "signal_fire" ->
                                                    blockDataSettings.setSignalFire(jsonReader.nextBoolean());
                                            case "candles" -> blockDataSettings.setCandles(jsonReader.nextInt());
                                            case "lit" -> blockDataSettings.setLit(jsonReader.nextBoolean());
                                            case "berries" -> blockDataSettings.setBerries(jsonReader.nextBoolean());
                                            case "chest_type" -> {
                                                try {
                                                    blockDataSettings.setChestType(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown chest type \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "conditional" ->
                                                    blockDataSettings.setConditional(jsonReader.nextBoolean());
                                            case "comparator_mode" -> {
                                                try {
                                                    blockDataSettings.setComparatorMode(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown comparator mode \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "crafter_orientation" -> {
                                                try {
                                                    blockDataSettings.setCrafterOrientation(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown crafter orientation \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "crafter_triggered" ->
                                                    blockDataSettings.setCrafterTriggered(jsonReader.nextBoolean());
                                            case "ender_eye" -> blockDataSettings.setEnderEye(jsonReader.nextBoolean());
                                            case "moisture" -> blockDataSettings.setMoisture(jsonReader.nextInt());
                                            case "hanging" -> blockDataSettings.setHanging(jsonReader.nextBoolean());
                                            case "hatch" -> blockDataSettings.setHatch(jsonReader.nextInt());
                                            case "hopper_enabled" ->
                                                    blockDataSettings.setHopperEnabled(jsonReader.nextBoolean());
                                            case "jigsaw_orientation" -> {
                                                try {
                                                    blockDataSettings.setJigsawOrientation(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown jigsaw orientation \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "level" -> blockDataSettings.setLevel(jsonReader.nextInt());
                                            case "instrument" -> {
                                                try {
                                                    blockDataSettings.setInstrument(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown instrument \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "note" -> blockDataSettings.setNote(jsonReader.nextInt());
                                            case "extended" -> blockDataSettings.setExtended(jsonReader.nextBoolean());
                                            case "dripstone_thickness" -> {
                                                try {
                                                    blockDataSettings.setDripstoneThickness(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown dripstone thickness \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "dripstone_vertical_direction" -> {
                                                try {
                                                    blockDataSettings.setDripstoneVerticalDirection(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown dripstone vertical direction \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "rail_shape" -> {
                                                try {
                                                    blockDataSettings.setRailShape(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown rail shape \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "repeater_delay" ->
                                                    blockDataSettings.setRepeaterDelay(jsonReader.nextInt());
                                            case "repeater_locked" ->
                                                    blockDataSettings.setRepeaterLocked(jsonReader.nextBoolean());
                                            case "charges" -> blockDataSettings.setCharges(jsonReader.nextInt());
                                            case "scaffolding_distance" ->
                                                    blockDataSettings.setScaffoldingDistance(jsonReader.nextInt());
                                            case "scaffolding_bottom" ->
                                                    blockDataSettings.setScaffoldingBottom(jsonReader.nextBoolean());
                                            case "sculk_shrieker_can_summon" ->
                                                    blockDataSettings.setSculkShriekerCanSummon(jsonReader.nextBoolean());
                                            case "sculk_catalyst_bloom" ->
                                                    blockDataSettings.setSculkCatalystBloom(jsonReader.nextBoolean());
                                            case "pickles" -> blockDataSettings.setPickles(jsonReader.nextInt());
                                            case "slab_type" -> {
                                                try {
                                                    blockDataSettings.setSlabType(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown slab type \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "snow_layers" -> blockDataSettings.setSnowLayers(jsonReader.nextInt());
                                            case "stairs_shape" -> {
                                                try {
                                                    blockDataSettings.setStairsShape(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown stairs shape \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "structure_block_mode" -> {
                                                try {
                                                    blockDataSettings.setStructureBlockMode(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown structure block mode \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "piston_type" -> {
                                                try {
                                                    blockDataSettings.setPistonType(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown piston type \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "trial_spawner_ominous" ->
                                                    blockDataSettings.setTrialSpawnerOminous(jsonReader.nextBoolean());
                                            case "trial_spawner_state" -> {
                                                try {
                                                    blockDataSettings.setTrialSpawnerState(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown trial spawner state \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "vault_state" -> {
                                                try {
                                                    blockDataSettings.setVaultState(jsonReader.nextString());
                                                } catch (Exception ex) {
                                                    this.javaPlugin.getLogger().warning("Unknown vault state \"" + jsonReader.nextString() + "\", skipped!");
                                                }
                                            }
                                            case "tripwire_hook_disarmed" ->
                                                    blockDataSettings.setTripwireHookDisarmed(jsonReader.nextBoolean());
                                            case "turtle_eggs" -> blockDataSettings.setTurtleEggs(jsonReader.nextInt());
                                            case "dusted" -> blockDataSettings.setDusted(jsonReader.nextInt());
                                            default -> jsonReader.skipValue();
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
