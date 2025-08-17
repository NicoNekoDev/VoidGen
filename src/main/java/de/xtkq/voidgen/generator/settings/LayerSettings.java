package de.xtkq.voidgen.generator.settings;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.RedstoneWire;
import org.bukkit.block.data.type.Wall;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Map;
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
        this.data.applyFaces(blockData);
        this.data.applyWallHeight(blockData);
        this.data.applyMossyCarpetHeights(blockData);
        this.data.applyRedstoneWireConnections(blockData);
        this.data.applyWallUp(blockData);
        this.data.applyMossyCarpetBottom(blockData);
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
        this.data.applyTripwireDisarmed(blockData);
        this.data.applyVaultState(blockData);
        this.data.applyVaultOminous(blockData);
        this.data.applyTrialSpawnerState(blockData);
        this.data.applyTrialSpawnerOminous(blockData);
        this.data.applyPistonType(blockData);
        this.data.applyStructureBlockMode(blockData);
        this.data.applyStairsShape(blockData);
        this.data.applySnowLayers(blockData);
        this.data.applySlabType(blockData);
        this.data.applyPickles(blockData);
        this.data.applySculkPhase(blockData);
        this.data.applySculkShriekerCanSummon(blockData);
        this.data.applySculkShriekerShrieking(blockData);
        this.data.applySculkCatalystBloom(blockData);
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
        this.data.applyFlowerAmount(blockData);
        this.data.applySegmentAmount(blockData);
        this.data.applyCreakingHeartState(blockData);
        this.data.applyCreakingHeartActive(blockData);
        this.data.applyCreakingHeartNatural(blockData);
        return blockData;
    }

    public void write(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("block").value(this.material.name().toLowerCase());
        jsonWriter.name("height").value(this.height);
        if (this.data != null) {
            jsonWriter.name("data").beginObject();
            if (this.data.getWallHeights() != null && !this.data.getWallHeights().isEmpty()) {
                jsonWriter.name("wall_heights").beginObject();
                for (Map.Entry<BlockFace, Wall.Height> entry : this.data.getWallHeights().entrySet())
                    jsonWriter.name(entry.getKey().name().toLowerCase()).value(entry.getValue().name().toLowerCase());
                jsonWriter.endObject();
            }
            if (this.data.getMossyCarpetHeights() != null && !this.data.getMossyCarpetHeights().isEmpty()) {
                jsonWriter.name("mossy_carpet_heights").beginObject();
                for (Map.Entry<BlockFace, Enum<?>> entry : this.data.getMossyCarpetHeights().entrySet())
                    jsonWriter.name(entry.getKey().name().toLowerCase()).value(entry.getValue().name().toLowerCase());
                jsonWriter.endObject();
            }
            if (this.data.getRedstoneWireConnections() != null && !this.data.getRedstoneWireConnections().isEmpty()) {
                jsonWriter.name("redstone_connections").beginObject();
                for (Map.Entry<BlockFace, RedstoneWire.Connection> entry : this.data.getRedstoneWireConnections().entrySet())
                    jsonWriter.name(entry.getKey().name().toLowerCase()).value(entry.getValue().name().toLowerCase());
                jsonWriter.endObject();
            }
            if (this.data.getFaces() != null && !this.data.getFaces().isEmpty()) {
                jsonWriter.name("faces").beginObject();
                for (Map.Entry<BlockFace, Boolean> entry : this.data.getFaces().entrySet())
                    jsonWriter.name(entry.getKey().name().toLowerCase()).value(entry.getValue());
                jsonWriter.endObject();
            }
            if (this.data.getWallUp() != null)
                jsonWriter.name("wall_up").value(this.data.getWallUp());
            if (this.data.getMossyCarpetBottom() != null)
                jsonWriter.name("mossy_carpet_bottom").value(this.data.getMossyCarpetBottom());
            if (this.data.getBambooLeaves() != null)
                jsonWriter.name("bamboo_leaves").value(this.data.getBambooLeaves().name().toLowerCase());
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
            if (this.data.getCrafterCrafting() != null)
                jsonWriter.name("crafter_crafting").value(this.data.getCrafterCrafting());
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
                jsonWriter.name("piston_extended").value(this.data.getExtended());
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
            if (this.data.getSculkShriekerShrieking() != null)
                jsonWriter.name("sculk_shrieker_shrieking").value(this.data.getSculkShriekerShrieking());
            if (this.data.getSculkCatalystBloom() != null)
                jsonWriter.name("sculk_catalyst_bloom").value(this.data.getSculkCatalystBloom());
            if (this.data.getPickles() != null)
                jsonWriter.name("pickles").value(this.data.getPickles());
            if (this.data.getSlabType() != null)
                jsonWriter.name("slab_type").value(this.data.getSlabType().name().toLowerCase());
            if (this.data.getSnowLayers() != null)
                jsonWriter.name("snow_layers").value(this.data.getSnowLayers());
            if (this.data.getSnowy() != null)
                jsonWriter.name("snowy").value(this.data.getSnowy());
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
            if (this.data.getVaultOminous() != null)
                jsonWriter.name("vault_ominous").value(this.data.getVaultOminous());
            if (this.data.getVaultState() != null)
                jsonWriter.name("vault_state").value(this.data.getVaultState().name().toLowerCase());
            if (this.data.getTripwireDisarmed() != null)
                jsonWriter.name("tripwire_disarmed").value(this.data.getTripwireDisarmed());
            if (this.data.getTurtleEggs() != null)
                jsonWriter.name("turtle_eggs").value(this.data.getTurtleEggs());
            if (this.data.getDusted() != null)
                jsonWriter.name("dusted").value(this.data.getDusted());
            if (this.data.getFlowerAmount() != null)
                jsonWriter.name("flower_amount").value(this.data.getFlowerAmount());
            if (this.data.getSegmentAmount() != null)
                jsonWriter.name("segment_amount").value(this.data.getSegmentAmount());
            if (this.data.getCreakingHeartState() != null)
                jsonWriter.name("creaking_heart_state").value(this.data.getCreakingHeartState().name().toLowerCase());
            if (this.data.getCreakingHeartActive() != null)
                jsonWriter.name("creaking_heart_active").value(this.data.getCreakingHeartActive());
            if (this.data.getCreakingHeartNatural() != null)
                jsonWriter.name("creaking_heart_natural").value(this.data.getCreakingHeartNatural());
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
                            case "wall_heights" -> {
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String faceString = jsonReader.nextName();
                                    String wallHeightString = jsonReader.nextString();
                                    try {
                                        blockDataSettings.setWallHeights(faceString, wallHeightString);
                                    } catch (Exception ex) {
                                        logger.warning("Unknown face \"" + faceString + "\" or wall height \"" + wallHeightString + "\", skipped!");
                                    }
                                }
                                jsonReader.endObject();
                            }
                            case "mossy_carpet_heights" -> {
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String faceString = jsonReader.nextName();
                                    String mossyCarpetHeightString = jsonReader.nextString();
                                    try {
                                        blockDataSettings.setMossyCarpetHeights(faceString, mossyCarpetHeightString);
                                    } catch (Exception ex) {
                                        logger.warning("Unknown face \"" + faceString + "\" or mossy carpet height \"" + mossyCarpetHeightString + "\", skipped!");
                                    }
                                }
                                jsonReader.endObject();
                            }
                            case "redstone_connections" -> {
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String faceString = jsonReader.nextName();
                                    String redstoneWireConnectionString = jsonReader.nextString();
                                    try {
                                        blockDataSettings.setRedstoneWireConnections(faceString, redstoneWireConnectionString);
                                    } catch (Exception ex) {
                                        logger.warning("Unknown face \"" + faceString + "\" or redstone wire connection \"" + redstoneWireConnectionString + "\", skipped!");
                                    }
                                }
                                jsonReader.endObject();
                            }
                            case "faces" -> {
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String faceString = jsonReader.nextName();
                                    boolean faceValue = jsonReader.nextBoolean();
                                    try {
                                        blockDataSettings.setFaces(faceString, faceValue);
                                    } catch (Exception ex) {
                                        logger.warning("Unknown face \"" + faceString + "\", skipped!");
                                    }
                                }
                                jsonReader.endObject();
                            }
                            case "wall_up" -> blockDataSettings.setWallUp(jsonReader.nextBoolean());
                            case "mossy_carpet_bottom" ->
                                    blockDataSettings.setMossyCarpetBottom(jsonReader.nextBoolean());
                            case "bamboo_leaves" -> {
                                String bambooLeavesString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setBambooLeaves(bambooLeavesString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown bamboo leaves \"" + bambooLeavesString + "\", skipped!");
                                }
                            }
                            case "waterlogged" -> blockDataSettings.setWaterlogged(jsonReader.nextBoolean());
                            case "switch_face" -> {
                                String switchFaceString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setSwitchFace(switchFaceString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown switch face \"" + switchFaceString + "\", skipped!");
                                }
                            }
                            case "door_hinge" -> {
                                String doorHingeString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setDoorHinge(doorHingeString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown door hinge \"" + doorHingeString + "\", skipped!");
                                }
                            }
                            case "in_wall" -> blockDataSettings.setIsInWall(jsonReader.nextBoolean());
                            case "facing" -> {
                                String facingString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setFacing(facingString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown facing \"" + facingString + "\", skipped!");
                                }
                            }
                            case "open" -> blockDataSettings.setOpen(jsonReader.nextBoolean());
                            case "power" -> blockDataSettings.setPower(jsonReader.nextInt());
                            case "attached" -> blockDataSettings.setAttached(jsonReader.nextBoolean());
                            case "rotation" -> {
                                String rotationString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setRotation(rotationString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown rotation \"" + rotationString + "\", skipped!");
                                }
                            }
                            case "leaves_distance" -> blockDataSettings.setLeavesDistance(jsonReader.nextInt());
                            case "leaves_persistent" -> blockDataSettings.setLeavesPersistent(jsonReader.nextBoolean());
                            case "axis" -> {
                                String axisString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setAxis(axisString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown axis \"" + axisString + "\", skipped!");
                                }
                            }
                            case "age" -> blockDataSettings.setAge(jsonReader.nextInt());
                            case "sculk_phase" -> {
                                String sculkPhaseString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setSculkPhase(sculkPhaseString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown sculk phase \"" + sculkPhaseString + "\", skipped!");
                                }
                            }
                            case "inverted" -> blockDataSettings.setInverted(jsonReader.nextBoolean());
                            case "crop_state" -> {
                                String cropStateString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setCropState(cropStateString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown crop state \"" + cropStateString + "\", skipped!");
                                }
                            }
                            case "color" -> {
                                String colorString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setColor(colorString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown color \"" + colorString + "\", skipped!");
                                }
                            }
                            case "bed_part" -> {
                                String bedPartString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setBedPart(bedPartString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown bed part \"" + bedPartString + "\", skipped!");
                                }
                            }
                            case "honey_level" -> blockDataSettings.setHoneyLevel(jsonReader.nextInt());
                            case "bell_attachment" -> {
                                String bellAttachmentString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setBellAttachment(bellAttachmentString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown bell attachment \"" + bellAttachmentString + "\", skipped!");
                                }
                            }
                            case "dripleaf_tilt" -> {
                                String dripleafTiltString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setDripleafTilt(dripleafTiltString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown dripleaf tilt \"" + dripleafTiltString + "\", skipped!");
                                }
                            }
                            case "bisected_half" -> {
                                String bisectedHalfString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setBisectedHalf(bisectedHalfString);
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
                                String chestTypeString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setChestType(chestTypeString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown chest type \"" + chestTypeString + "\", skipped!");
                                }
                            }
                            case "conditional" -> blockDataSettings.setConditional(jsonReader.nextBoolean());
                            case "comparator_mode" -> {
                                String comparatorModeString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setComparatorMode(comparatorModeString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown comparator mode \"" + comparatorModeString + "\", skipped!");
                                }
                            }
                            case "crafter_orientation" -> {
                                String crafterOrientationString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setCrafterOrientation(crafterOrientationString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown crafter orientation \"" + crafterOrientationString + "\", skipped!");
                                }
                            }
                            case "crafter_triggered" -> blockDataSettings.setCrafterTriggered(jsonReader.nextBoolean());
                            case "crafter_crafting" -> blockDataSettings.setCrafterCrafting(jsonReader.nextBoolean());
                            case "ender_eye" -> blockDataSettings.setEnderEye(jsonReader.nextBoolean());
                            case "moisture" -> blockDataSettings.setMoisture(jsonReader.nextInt());
                            case "hanging" -> blockDataSettings.setHanging(jsonReader.nextBoolean());
                            case "hatch" -> blockDataSettings.setHatch(jsonReader.nextInt());
                            case "hopper_enabled" -> blockDataSettings.setHopperEnabled(jsonReader.nextBoolean());
                            case "jigsaw_orientation" -> {
                                String jigsawOrientationString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setJigsawOrientation(jigsawOrientationString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown jigsaw orientation \"" + jigsawOrientationString + "\", skipped!");
                                }
                            }
                            case "level" -> blockDataSettings.setLevel(jsonReader.nextInt());
                            case "instrument" -> {
                                String instrumentString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setInstrument(instrumentString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown instrument \"" + instrumentString + "\", skipped!");
                                }
                            }
                            case "note" -> blockDataSettings.setNote(jsonReader.nextInt());
                            case "piston_extended" -> blockDataSettings.setExtended(jsonReader.nextBoolean());
                            case "dripstone_thickness" -> {
                                String dripstoneThicknessString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setDripstoneThickness(dripstoneThicknessString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown dripstone thickness \"" + dripstoneThicknessString + "\", skipped!");
                                }
                            }
                            case "dripstone_vertical_direction" -> {
                                String dripstoneVerticalDirectionString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setDripstoneVerticalDirection(dripstoneVerticalDirectionString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown dripstone vertical direction \"" + dripstoneVerticalDirectionString + "\", skipped!");
                                }
                            }
                            case "rail_shape" -> {
                                String railShapeString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setRailShape(railShapeString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown rail shape \"" + railShapeString + "\", skipped!");
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
                            case "getSculkShriekerShrieking" ->
                                    blockDataSettings.setSculkShriekerShrieking(jsonReader.nextBoolean());
                            case "sculk_catalyst_bloom" ->
                                    blockDataSettings.setSculkCatalystBloom(jsonReader.nextBoolean());
                            case "pickles" -> blockDataSettings.setPickles(jsonReader.nextInt());
                            case "slab_type" -> {
                                String slabTypeString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setSlabType(slabTypeString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown slab type \"" + slabTypeString + "\", skipped!");
                                }
                            }
                            case "snow_layers" -> blockDataSettings.setSnowLayers(jsonReader.nextInt());
                            case "snowy" -> blockDataSettings.setSnowy(jsonReader.nextBoolean());
                            case "stairs_shape" -> {
                                String stairsShapeString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setStairsShape(stairsShapeString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown stairs shape \"" + stairsShapeString + "\", skipped!");
                                }
                            }
                            case "structure_block_mode" -> {
                                String structureBlockModeString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setStructureBlockMode(structureBlockModeString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown structure block mode \"" + structureBlockModeString + "\", skipped!");
                                }
                            }
                            case "piston_type" -> {
                                String pistonTypeString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setPistonType(pistonTypeString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown piston type \"" + pistonTypeString + "\", skipped!");
                                }
                            }
                            case "trial_spawner_ominous" ->
                                    blockDataSettings.setTrialSpawnerOminous(jsonReader.nextBoolean());
                            case "trial_spawner_state" -> {
                                String trialSpawnerStateString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setTrialSpawnerState(trialSpawnerStateString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown trial spawner state \"" + trialSpawnerStateString + "\", skipped!");
                                }
                            }
                            case "vault_ominous" -> blockDataSettings.setVaultOminous(jsonReader.nextBoolean());
                            case "vault_state" -> {
                                String vaultStateString = jsonReader.nextString();
                                try {
                                    blockDataSettings.setVaultState(vaultStateString);
                                } catch (Exception ex) {
                                    logger.warning("Unknown vault state \"" + vaultStateString + "\", skipped!");
                                }
                            }
                            case "tripwire_hook_disarmed" ->
                                    blockDataSettings.setTripwireDisarmed(jsonReader.nextBoolean());
                            case "turtle_eggs" -> blockDataSettings.setTurtleEggs(jsonReader.nextInt());
                            case "dusted" -> blockDataSettings.setDusted(jsonReader.nextInt());
                            case "flower_amount" -> blockDataSettings.setFlowerAmount(jsonReader.nextInt());
                            case "segment_amount" -> blockDataSettings.setSegmentAmount(jsonReader.nextInt());
                            case "creaking_heart_state" ->
                                    blockDataSettings.setCreakingHeartState(jsonReader.nextString());
                            case "creaking_heart_active" ->
                                    blockDataSettings.setCreakingHeartActive(jsonReader.nextBoolean());
                            case "creaking_heart_natural" ->
                                    blockDataSettings.setCreakingHeartNatural(jsonReader.nextBoolean());
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
