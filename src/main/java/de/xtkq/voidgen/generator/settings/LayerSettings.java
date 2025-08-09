package de.xtkq.voidgen.generator.settings;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.logging.Logger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LayerSettings {
    @NotNull
    private Material material = Material.AIR;

    private int height = 1;

    @Nullable
    private BlockDataSettings data;

    public BlockData composeBlockData() {
        BlockData blockData = this.material.createBlockData();
        if (this.data == null)
            return blockData;
        this.data.applyInverted(blockData);
        this.data.applyCropState(blockData);
        this.data.applyHoneyLevel(blockData);
        this.data.applyBellAttachment(blockData);
        this.data.applyDripleafTilt(blockData);
        this.data.applyBisectedHalf(blockData);
        this.data.applyBubbleDrag(blockData);
        this.data.applyCakeBites(blockData);
        this.data.applyWaterlogged(blockData);
        this.data.applyAge(blockData);
        this.data.applyOpen(blockData);
        this.data.applyInWall(blockData);
        this.data.applyDusted(blockData);
        this.data.applyPower(blockData);
        this.data.applyLevel(blockData);
        this.data.applyColor(blockData);
        this.data.applyAttached(blockData);
        this.data.applyPowered(blockData);
        this.data.applyHatch(blockData);
        this.data.applyBedPart(blockData);
        this.data.applyNote(blockData);
        this.data.applyInstrument(blockData);
        this.data.applyLit(blockData);
        this.data.applyAxis(blockData);
        this.data.applyLeavesPersistent(blockData);
        this.data.applyLeavesDistance(blockData);
        this.data.applyRotation(blockData);
        this.data.applySnowy(blockData);
        this.data.applyFacing(blockData);
        this.data.applySwitchFace(blockData);
        this.data.applyDoorHinge(blockData);
        this.data.applyTurtleEggs(blockData);
        this.data.applyTripwireHookDisarmed(blockData);
        this.data.applyVaultState(blockData);
        this.data.applyTrialSpawnerState(blockData);
        this.data.applyTrialSpawnerOminous(blockData);
        this.data.applyPistonType(blockData);
        this.data.applyStructureBlockMode(blockData);
        this.data.applyStairsShape(blockData);
        this.data.applySnowLayers(blockData);
        this.data.applySlabType(blockData);
        this.data.applyPickles(blockData);
        this.data.applySculkPhase(blockData);
        this.data.applySculkShriekerShrieking(blockData);
        this.data.applySculkCatalystBloom(blockData);
        this.data.applySculkShriekerCanSummon(blockData);
        this.data.applyScaffoldingBottom(blockData);
        this.data.applyScaffoldingDistance(blockData);
        this.data.applyCharges(blockData);
        this.data.applyRepeaterLocked(blockData);
        this.data.applyRepeaterDelay(blockData);
        this.data.applyRailShape(blockData);
        this.data.applyDripstoneVerticalDirection(blockData);
        this.data.applyDripstoneThickness(blockData);
        this.data.applyExtended(blockData);
        this.data.applyJigsawOrientation(blockData);
        this.data.applyHopperEnabled(blockData);
        this.data.applyHanging(blockData);
        this.data.applyMoisture(blockData);
        this.data.applyHasEye(blockData);
        this.data.applyCrafterTriggered(blockData);
        this.data.applyCrafterCrafting(blockData);
        this.data.applyCrafterOrientation(blockData);
        this.data.applyComparatorMode(blockData);
        this.data.applyConditional(blockData);
        this.data.applyChestType(blockData);
        this.data.applyBerries(blockData);
        this.data.applyCandles(blockData);
        this.data.applySignalFire(blockData);
        return blockData;
    }

    public void write(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("block").value(this.material.name().toLowerCase());
        jsonWriter.name("height").value(this.height);
        if (this.data != null) {
            jsonWriter.name("data").beginObject();
            if (this.data.getWaterlogged() != null)
                jsonWriter.name("waterlogged").value(this.data.getWaterlogged());
            if (this.data.getSwitchFace() != null)
                jsonWriter.name("switch_face").value(this.data.getSwitchFace().name().toLowerCase());
            if (this.data.getDoorHinge() != null)
                jsonWriter.name("door_hinge").value(this.data.getDoorHinge().name().toLowerCase());
            if (this.data.getIsInWall() != null)
                jsonWriter.name("in_wall").value(this.data.getIsInWall());
            if (this.data.getFacing() != null)
                jsonWriter.name("facing").value(this.data.getFacing().name().toLowerCase());
            if (this.data.getOpen() != null)
                jsonWriter.name("open").value(this.data.getOpen());
            if (this.data.getPower() != null)
                jsonWriter.name("power").value(this.data.getPower());
            if (this.data.getAttached() != null)
                jsonWriter.name("attached").value(this.data.getAttached());
            if (this.data.getRotation() != null)
                jsonWriter.name("rotation").value(this.data.getRotation().name().toLowerCase());
            if (this.data.getLeavesDistance() != null)
                jsonWriter.name("leaves_distance").value(this.data.getLeavesDistance());
            if (this.data.getLeavesPersistent() != null)
                jsonWriter.name("leaves_persistent").value(this.data.getLeavesPersistent());
            if (this.data.getAxis() != null)
                jsonWriter.name("axis").value(this.data.getAxis().name().toLowerCase());
            if (this.data.getAge() != null)
                jsonWriter.name("age").value(this.data.getAge());
            if (this.data.getSculkPhase() != null)
                jsonWriter.name("sculk_phase").value(this.data.getSculkPhase().name().toLowerCase());
            if (this.data.getInverted() != null)
                jsonWriter.name("inverted").value(this.data.getInverted());
            if (this.data.getCropState() != null)
                jsonWriter.name("crop_state").value(this.data.getCropState().name().toLowerCase());
            if (this.data.getColor() != null)
                jsonWriter.name("color").value(this.data.getColor().name().toLowerCase());
            if (this.data.getBedPart() != null)
                jsonWriter.name("bed_part").value(this.data.getBedPart().name().toLowerCase());
            if (this.data.getHoneyLevel() != null)
                jsonWriter.name("honey_level").value(this.data.getHoneyLevel());
            if (this.data.getBellAttachment() != null)
                jsonWriter.name("bell_attachment").value(this.data.getBellAttachment().name().toLowerCase());
            if (this.data.getDripleafTilt() != null)
                jsonWriter.name("dripleaf_tilt").value(this.data.getDripleafTilt().name().toLowerCase());
            if (this.data.getBisectedHalf() != null)
                jsonWriter.name("bisected_half").value(this.data.getBisectedHalf().name().toLowerCase());
            if (this.data.getBubbleDrag() != null)
                jsonWriter.name("bubble_drag").value(this.data.getBubbleDrag());
            if (this.data.getCakeBites() != null)
                jsonWriter.name("cake_bites").value(this.data.getCakeBites());
            if (this.data.getSignalFire() != null)
                jsonWriter.name("signal_fire").value(this.data.getSignalFire());
            if (this.data.getCandles() != null)
                jsonWriter.name("candles").value(this.data.getCandles());
            if (this.data.getLit() != null)
                jsonWriter.name("lit").value(this.data.getLit());
            if (this.data.getBerries() != null)
                jsonWriter.name("berries").value(this.data.getBerries());
            if (this.data.getChestType() != null)
                jsonWriter.name("chest_type").value(this.data.getChestType().name().toLowerCase());
            if (this.data.getConditional() != null)
                jsonWriter.name("conditional").value(this.data.getConditional());
            if (this.data.getComparatorMode() != null)
                jsonWriter.name("comparator_mode").value(this.data.getComparatorMode().name().toLowerCase());
            if (this.data.getCrafterOrientation() != null)
                jsonWriter.name("crafter_orientation").value(this.data.getCrafterOrientation().name().toLowerCase());
            if (this.data.getCrafterTriggered() != null)
                jsonWriter.name("crafter_triggered").value(this.data.getCrafterTriggered());
            if (this.data.getEnderEye() != null)
                jsonWriter.name("ender_eye").value(this.data.getEnderEye());
            if (this.data.getMoisture() != null)
                jsonWriter.name("moisture").value(this.data.getMoisture());
            if (this.data.getHanging() != null)
                jsonWriter.name("hanging").value(this.data.getHanging());
            if (this.data.getHatch() != null)
                jsonWriter.name("hatch").value(this.data.getHatch());
            if (this.data.getHopperEnabled() != null)
                jsonWriter.name("hopper_enabled").value(this.data.getHopperEnabled());
            if (this.data.getJigsawOrientation() != null)
                jsonWriter.name("jigsaw_orientation").value(this.data.getJigsawOrientation().name().toLowerCase());
            if (this.data.getLevel() != null)
                jsonWriter.name("level").value(this.data.getLevel());
            if (this.data.getInstrument() != null)
                jsonWriter.name("instrument").value(this.data.getInstrument().name().toLowerCase());
            if (this.data.getNote() != null)
                jsonWriter.name("note").value(this.data.getNote());
            if (this.data.getExtended() != null)
                jsonWriter.name("extended").value(this.data.getExtended());
            if (this.data.getDripstoneThickness() != null)
                jsonWriter.name("dripstone_thickness").value(this.data.getDripstoneThickness().name().toLowerCase());
            if (this.data.getDripstoneVerticalDirection() != null)
                jsonWriter.name("dripstone_vertical_direction").value(this.data.getDripstoneVerticalDirection().name().toLowerCase());
            if (this.data.getRailShape() != null)
                jsonWriter.name("rail_shape").value(this.data.getRailShape().name().toLowerCase());
            if (this.data.getRepeaterDelay() != null)
                jsonWriter.name("repeater_delay").value(this.data.getRepeaterDelay());
            if (this.data.getRepeaterLocked() != null)
                jsonWriter.name("repeater_locked").value(this.data.getRepeaterLocked());
            if (this.data.getCharges() != null)
                jsonWriter.name("charges").value(this.data.getCharges());
            if (this.data.getScaffoldingDistance() != null)
                jsonWriter.name("scaffolding_distance").value(this.data.getScaffoldingDistance());
            if (this.data.getScaffoldingBottom() != null)
                jsonWriter.name("scaffolding_bottom").value(this.data.getScaffoldingBottom());
            if (this.data.getSculkShriekerCanSummon() != null)
                jsonWriter.name("sculk_shrieker_can_summon").value(this.data.getSculkShriekerCanSummon());
            if (this.data.getSculkCatalystBloom() != null)
                jsonWriter.name("sculk_catalyst_bloom").value(this.data.getSculkCatalystBloom());
            if (this.data.getPickles() != null)
                jsonWriter.name("pickles").value(this.data.getPickles());
            if (this.data.getSlabType() != null)
                jsonWriter.name("slab_type").value(this.data.getSlabType().name().toLowerCase());
            if (this.data.getSnowLayers() != null)
                jsonWriter.name("snow_layers").value(this.data.getSnowLayers());
            if (this.data.getStairsShape() != null)
                jsonWriter.name("stairs_shape").value(this.data.getStairsShape().name().toLowerCase());
            if (this.data.getStructureBlockMode() != null)
                jsonWriter.name("structure_block_mode").value(this.data.getStructureBlockMode().name().toLowerCase());
            if (this.data.getPistonType() != null)
                jsonWriter.name("piston_type").value(this.data.getPistonType().name().toLowerCase());
            if (this.data.getTrialSpawnerOminous() != null)
                jsonWriter.name("trial_spawner_ominous").value(this.data.getTrialSpawnerOminous());
            if (this.data.getTrialSpawnerState() != null)
                jsonWriter.name("trial_spawner_state").value(this.data.getTrialSpawnerState().name().toLowerCase());
            if (this.data.getVaultState() != null)
                jsonWriter.name("vault_state").value(this.data.getVaultState().name().toLowerCase());
            if (this.data.getTripwireHookDisarmed() != null)
                jsonWriter.name("tripwire_hook_disarmed").value(this.data.getTripwireHookDisarmed());
            if (this.data.getTurtleEggs() != null)
                jsonWriter.name("turtle_eggs").value(this.data.getTurtleEggs());
            if (this.data.getDusted() != null)
                jsonWriter.name("dusted").value(this.data.getDusted());
            jsonWriter.endObject();
        }
        jsonWriter.endObject();
    }

    public LayerSettings read(JsonReader jsonReader, Logger logger) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "block" -> {
                    String materialString = jsonReader.nextString();
                    try {
                        Material material = Material.valueOf(materialString.toUpperCase());
                        if (material.isAir() || material.isBlock())
                            this.material = material;
                        else
                            logger.warning("Material type \"" + materialString + "\" is not a block!");
                    } catch (Exception ex) {
                        logger.warning("Unknown material type \"" + materialString + "\", skipped!");
                    }
                }
                case "height" -> {
                    int height = jsonReader.nextInt();
                    if (height < 0) {
                        logger.warning("Layer height cannot be less than 0!");
                        height = 1;
                    }
                    this.height = height;
                }
                case "data" -> {
                    BlockDataSettings blockDataSettings = new BlockDataSettings();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        switch (jsonReader.nextName()) {
                            case "waterlogged" -> blockDataSettings.setWaterlogged(jsonReader.nextBoolean());
                            case "switch_face" -> {
                                try {
                                    blockDataSettings.setSwitchFace(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown switch face \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "door_hinge" -> {
                                try {
                                    blockDataSettings.setDoorHinge(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown door hinge \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "in_wall" -> blockDataSettings.setIsInWall(jsonReader.nextBoolean());
                            case "facing" -> {
                                try {
                                    blockDataSettings.setFacing(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown facing \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "open" -> blockDataSettings.setOpen(jsonReader.nextBoolean());
                            case "power" -> blockDataSettings.setPower(jsonReader.nextInt());
                            case "attached" -> blockDataSettings.setAttached(jsonReader.nextBoolean());
                            case "rotation" -> {
                                try {
                                    blockDataSettings.setRotation(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown rotation \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "leaves_distance" -> blockDataSettings.setLeavesDistance(jsonReader.nextInt());
                            case "leaves_persistent" -> blockDataSettings.setLeavesPersistent(jsonReader.nextBoolean());
                            case "axis" -> {
                                try {
                                    blockDataSettings.setAxis(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown axis \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "age" -> blockDataSettings.setAge(jsonReader.nextInt());
                            case "sculk_phase" -> {
                                try {
                                    blockDataSettings.setSculkPhase(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown sculk phase \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "inverted" -> blockDataSettings.setInverted(jsonReader.nextBoolean());
                            case "crop_state" -> {
                                try {
                                    blockDataSettings.setCropState(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown crop state \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "color" -> {
                                try {
                                    blockDataSettings.setColor(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown color \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "bed_part" -> {
                                try {
                                    blockDataSettings.setBedPart(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown bed part \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "honey_level" -> blockDataSettings.setHoneyLevel(jsonReader.nextInt());
                            case "bell_attachment" -> {
                                try {
                                    blockDataSettings.setBellAttachment(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown bell attachment \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "dripleaf_tilt" -> {
                                try {
                                    blockDataSettings.setDripleafTilt(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown dripleaf tilt \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "bisected_half" -> {
                                try {
                                    blockDataSettings.setBisectedHalf(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown bisected half \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "bubble_drag" -> blockDataSettings.setBubbleDrag(jsonReader.nextBoolean());
                            case "cake_bites" -> blockDataSettings.setCakeBites(jsonReader.nextInt());
                            case "signal_fire" -> blockDataSettings.setSignalFire(jsonReader.nextBoolean());
                            case "candles" -> blockDataSettings.setCandles(jsonReader.nextInt());
                            case "lit" -> blockDataSettings.setLit(jsonReader.nextBoolean());
                            case "berries" -> blockDataSettings.setBerries(jsonReader.nextBoolean());
                            case "chest_type" -> {
                                try {
                                    blockDataSettings.setChestType(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown chest type \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "conditional" -> blockDataSettings.setConditional(jsonReader.nextBoolean());
                            case "comparator_mode" -> {
                                try {
                                    blockDataSettings.setComparatorMode(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown comparator mode \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "crafter_orientation" -> {
                                try {
                                    blockDataSettings.setCrafterOrientation(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown crafter orientation \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "crafter_triggered" -> blockDataSettings.setCrafterTriggered(jsonReader.nextBoolean());
                            case "ender_eye" -> blockDataSettings.setEnderEye(jsonReader.nextBoolean());
                            case "moisture" -> blockDataSettings.setMoisture(jsonReader.nextInt());
                            case "hanging" -> blockDataSettings.setHanging(jsonReader.nextBoolean());
                            case "hatch" -> blockDataSettings.setHatch(jsonReader.nextInt());
                            case "hopper_enabled" -> blockDataSettings.setHopperEnabled(jsonReader.nextBoolean());
                            case "jigsaw_orientation" -> {
                                try {
                                    blockDataSettings.setJigsawOrientation(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown jigsaw orientation \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "level" -> blockDataSettings.setLevel(jsonReader.nextInt());
                            case "instrument" -> {
                                try {
                                    blockDataSettings.setInstrument(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown instrument \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "note" -> blockDataSettings.setNote(jsonReader.nextInt());
                            case "extended" -> blockDataSettings.setExtended(jsonReader.nextBoolean());
                            case "dripstone_thickness" -> {
                                try {
                                    blockDataSettings.setDripstoneThickness(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown dripstone thickness \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "dripstone_vertical_direction" -> {
                                try {
                                    blockDataSettings.setDripstoneVerticalDirection(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown dripstone vertical direction \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "rail_shape" -> {
                                try {
                                    blockDataSettings.setRailShape(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown rail shape \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "repeater_delay" -> blockDataSettings.setRepeaterDelay(jsonReader.nextInt());
                            case "repeater_locked" -> blockDataSettings.setRepeaterLocked(jsonReader.nextBoolean());
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
                                    logger.warning("Unknown slab type \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "snow_layers" -> blockDataSettings.setSnowLayers(jsonReader.nextInt());
                            case "stairs_shape" -> {
                                try {
                                    blockDataSettings.setStairsShape(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown stairs shape \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "structure_block_mode" -> {
                                try {
                                    blockDataSettings.setStructureBlockMode(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown structure block mode \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "piston_type" -> {
                                try {
                                    blockDataSettings.setPistonType(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown piston type \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "trial_spawner_ominous" ->
                                    blockDataSettings.setTrialSpawnerOminous(jsonReader.nextBoolean());
                            case "trial_spawner_state" -> {
                                try {
                                    blockDataSettings.setTrialSpawnerState(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown trial spawner state \"" + jsonReader.nextString() + "\", skipped!");
                                }
                            }
                            case "vault_state" -> {
                                try {
                                    blockDataSettings.setVaultState(jsonReader.nextString());
                                } catch (Exception ex) {
                                    logger.warning("Unknown vault state \"" + jsonReader.nextString() + "\", skipped!");
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
                    this.data = blockDataSettings;
                }
            }
        }
        jsonReader.endObject();
        return this;
    }
}
