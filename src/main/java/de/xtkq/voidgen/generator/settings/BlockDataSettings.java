package de.xtkq.voidgen.generator.settings;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.*;
import org.bukkit.block.data.type.*;
import org.bukkit.material.Colorable;
import org.bukkit.material.Crops;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("deprecation")
@Getter
@Setter
public class BlockDataSettings {
    private final Class<?> FLOWED_BED_CLASS;
    private final Class<?> LEAF_LITTER_CLASS;
    private final Class<?> CREAKING_HEART_CLASS;
    private final Class<? extends Enum<?>> CREAKING_HEART_STATE_CLASS;
    private final Class<?> MOSSY_CARPET_CLASS;
    private final Class<? extends Enum<?>> MOSSY_CARPET_HEIGHT_CLASS;

    @SuppressWarnings("unchecked")
    public BlockDataSettings() {
        Class<?> flowedBedClassVar;
        try {
            flowedBedClassVar = Class.forName("org.bukkit.block.data.type.FlowedBed");
        } catch (Exception e) {
            flowedBedClassVar = null;
        }
        this.FLOWED_BED_CLASS = flowedBedClassVar;
        Class<?> leafLitterClassVar;
        try {
            leafLitterClassVar = Class.forName("org.bukkit.block.data.type.LeafLitter");
        } catch (Exception e) {
            leafLitterClassVar = null;
        }
        this.LEAF_LITTER_CLASS = leafLitterClassVar;
        Class<?> creakingHeartClassVar;
        try {
            creakingHeartClassVar = Class.forName("org.bukkit.block.data.type.CreakingHeart");
        } catch (Exception e) {
            creakingHeartClassVar = null;
        }
        this.CREAKING_HEART_CLASS = creakingHeartClassVar;
        Class<? extends Enum<?>> creakingHeartStateClassVar;
        try {
            creakingHeartStateClassVar = (Class<? extends Enum<?>>) Class.forName("org.bukkit.block.data.type.CreakingHeart$State");
        } catch (Exception e) {
            creakingHeartStateClassVar = null;
        }
        this.CREAKING_HEART_STATE_CLASS = creakingHeartStateClassVar;
        Class<?> mossyCarpetClassVar;
        try {
            mossyCarpetClassVar = Class.forName("org.bukkit.block.data.type.MossyCarpet");
        } catch (Exception e) {
            mossyCarpetClassVar = null;
        }
        this.MOSSY_CARPET_CLASS = mossyCarpetClassVar;
        Class<? extends Enum<?>> mossyCarpetHeightClassVar;
        try {
            mossyCarpetHeightClassVar = (Class<? extends Enum<?>>) Class.forName("org.bukkit.block.data.type.MossyCarpet$Height");
        } catch (Exception e) {
            mossyCarpetHeightClassVar = null;
        }
        this.MOSSY_CARPET_HEIGHT_CLASS = mossyCarpetHeightClassVar;
    }

    @Nullable
    private Map<BlockFace, Boolean> faces;

    public void applyFaces(BlockData blockData) {
        if (blockData instanceof MultipleFacing instance && this.faces != null)
            this.faces.forEach(instance::setFace);
    }

    public void setFaces(String faceString, boolean value) throws IllegalArgumentException {
        if (this.faces == null)
            this.faces = new HashMap<>();
        this.faces.put(BlockFace.valueOf(faceString.toUpperCase()), value);
    }

    @Nullable
    private Map<BlockFace, Wall.Height> wallHeights;

    public void applyWallHeight(BlockData blockData) {
        if (blockData instanceof Wall instance && this.wallHeights != null)
            this.wallHeights.forEach(instance::setHeight);
    }

    public void setWallHeights(String faceString, String wallHeightString) throws IllegalArgumentException {
        if (this.wallHeights == null)
            this.wallHeights = new HashMap<>();
        this.wallHeights.put(BlockFace.valueOf(faceString.toUpperCase()), Wall.Height.valueOf(wallHeightString.toUpperCase()));
    }

    @Nullable
    private Map<BlockFace, RedstoneWire.Connection> redstoneWireConnections;

    public void applyRedstoneWireConnections(BlockData blockData) {
        if (blockData instanceof RedstoneWire instance && this.redstoneWireConnections != null)
            this.redstoneWireConnections.forEach(instance::setFace);
    }

    public void setRedstoneWireConnections(String faceString, String redstoneWireConnectionString) throws IllegalArgumentException {
        if (this.redstoneWireConnections == null)
            this.redstoneWireConnections = new HashMap<>();
        this.redstoneWireConnections.put(BlockFace.valueOf(faceString.toUpperCase()), RedstoneWire.Connection.valueOf(redstoneWireConnectionString.toUpperCase()));
    }

    @Nullable
    private Bamboo.Leaves bambooLeaves;

    public void applyBambooLeaves(BlockData blockData) {
        if (blockData instanceof Bamboo instance && this.bambooLeaves != null)
            instance.setLeaves(this.bambooLeaves);
    }

    public void setBambooLeaves(String bambooLeavesString) throws IllegalArgumentException {
        this.bambooLeaves = Bamboo.Leaves.valueOf(bambooLeavesString.toUpperCase());
    }

    @Nullable
    private Boolean waterlogged;

    public void applyWaterlogged(BlockData blockData) {
        if (blockData instanceof Waterlogged instance && this.waterlogged != null)
            instance.setWaterlogged(this.waterlogged);
    }

    @Nullable
    private Switch.Face switchFace;

    public void applySwitchFace(BlockData blockData) {
        if (blockData instanceof Switch instance && this.switchFace != null)
            instance.setFace(this.switchFace);
    }

    public void setSwitchFace(String switchFaceString) throws IllegalArgumentException {
        this.switchFace = Switch.Face.valueOf(switchFaceString.toUpperCase());
    }

    @Nullable
    private Door.Hinge doorHinge;

    public void applyDoorHinge(BlockData blockData) {
        if (blockData instanceof Door instance && this.doorHinge != null)
            instance.setHinge(this.doorHinge);
    }

    public void setDoorHinge(String doorHingeString) throws IllegalArgumentException {
        this.doorHinge = Door.Hinge.valueOf(doorHingeString.toUpperCase());
    }

    @Nullable
    private Boolean isInWall;

    public void applyInWall(BlockData blockData) {
        if (blockData instanceof Gate instance && this.isInWall != null)
            instance.setInWall(this.isInWall);
    }

    @Nullable
    private BlockFace facing;

    public void applyFacing(BlockData blockData) {
        if (blockData instanceof Directional instance && this.facing != null)
            instance.setFacing(this.facing);
    }

    public void setFacing(String facingString) throws IllegalArgumentException {
        this.facing = BlockFace.valueOf(facingString.toUpperCase());
    }

    @Nullable
    private Boolean open;

    public void applyOpen(BlockData blockData) {
        if (blockData instanceof Door instance && this.open != null)
            instance.setOpen(this.open);
    }

    @Nullable
    private Integer power;

    public void applyPower(BlockData blockData) {
        if (blockData instanceof AnaloguePowerable instance && this.power != null)
            instance.setPower(this.power);
    }

    @Nullable
    private Boolean powered;

    public void applyPowered(BlockData blockData) {
        if (blockData instanceof Powerable instance && this.powered != null)
            instance.setPowered(this.powered);
    }

    @Nullable
    private Boolean attached;

    public void applyAttached(BlockData blockData) {
        if (blockData instanceof Attachable instance && this.attached != null)
            instance.setAttached(this.attached);
    }

    @Nullable
    private BlockFace rotation;

    public void applyRotation(BlockData blockData) {
        if (blockData instanceof Rotatable instance && this.rotation != null)
            instance.setRotation(this.rotation);
    }

    public void setRotation(String rotationString) throws IllegalArgumentException {
        this.rotation = BlockFace.valueOf(rotationString.toUpperCase());
    }

    @Nullable
    private Integer leavesDistance;

    public void applyLeavesDistance(BlockData blockData) {
        if (blockData instanceof Leaves instance && this.leavesDistance != null)
            instance.setDistance(this.leavesDistance);
    }

    @Nullable
    private Boolean leavesPersistent;

    public void applyLeavesPersistent(BlockData blockData) {
        if (blockData instanceof Leaves instance && this.leavesPersistent != null)
            instance.setPersistent(this.leavesPersistent);
    }

    @Nullable
    private Axis axis;

    public void applyAxis(BlockData blockData) {
        if (blockData instanceof Orientable instance && this.axis != null)
            instance.setAxis(this.axis);
    }

    public void setAxis(String axisString) throws IllegalArgumentException {
        this.axis = Axis.valueOf(axisString.toUpperCase());
    }

    @Nullable
    private Integer age;

    public void applyAge(BlockData blockData) {
        if (blockData instanceof Ageable instance && this.age != null)
            instance.setAge(this.age);
    }

    @Nullable
    private SculkSensor.Phase sculkPhase;

    public void applySculkPhase(BlockData blockData) {
        if (blockData instanceof SculkSensor instance && this.sculkPhase != null)
            instance.setPhase(this.sculkPhase);
    }

    public void setSculkPhase(String sculkPhaseString) throws IllegalArgumentException {
        this.sculkPhase = SculkSensor.Phase.valueOf(sculkPhaseString.toUpperCase());
    }

    @Nullable
    private Boolean inverted;

    public void applyInverted(BlockData blockData) {
        if (blockData instanceof DaylightDetector instance && this.inverted != null)
            instance.setInverted(this.inverted);
    }

    @Nullable
    private CropState cropState;

    public void applyCropState(BlockData blockData) {
        if (blockData instanceof Crops instance && this.cropState != null)
            instance.setState(this.cropState);
    }

    public void setCropState(String cropStateString) throws IllegalArgumentException {
        this.cropState = CropState.valueOf(cropStateString.toUpperCase());
    }

    @Nullable
    private DyeColor color;

    public void applyColor(BlockData blockData) {
        if (blockData instanceof Colorable instance && this.color != null)
            instance.setColor(this.color);
    }

    public void setColor(String colorString) throws IllegalArgumentException {
        this.color = DyeColor.valueOf(colorString.toUpperCase());
    }

    @Nullable
    private Bed.Part bedPart;

    public void applyBedPart(BlockData blockData) {
        if (blockData instanceof Bed instance && this.bedPart != null)
            instance.setPart(this.bedPart);
    }

    public void setBedPart(String bedPartString) throws IllegalArgumentException {
        this.bedPart = Bed.Part.valueOf(bedPartString.toUpperCase());
    }

    @Nullable
    private Integer honeyLevel;

    public void applyHoneyLevel(BlockData blockData) {
        if (blockData instanceof Beehive instance && this.honeyLevel != null)
            instance.setHoneyLevel(this.honeyLevel);
    }

    @Nullable
    private Bell.Attachment bellAttachment;

    public void applyBellAttachment(BlockData blockData) {
        if (blockData instanceof Bell instance && this.bellAttachment != null)
            instance.setAttachment(this.bellAttachment);
    }

    public void setBellAttachment(String bellAttachmentString) throws IllegalArgumentException {
        this.bellAttachment = Bell.Attachment.valueOf(bellAttachmentString.toUpperCase());
    }

    @Nullable
    private BigDripleaf.Tilt dripleafTilt;

    public void applyDripleafTilt(BlockData blockData) {
        if (blockData instanceof BigDripleaf instance && this.dripleafTilt != null)
            instance.setTilt(this.dripleafTilt);
    }

    public void setDripleafTilt(String dripleafTiltString) throws IllegalArgumentException {
        this.dripleafTilt = BigDripleaf.Tilt.valueOf(dripleafTiltString.toUpperCase());
    }

    @Nullable
    private Bisected.Half bisectedHalf;

    public void applyBisectedHalf(BlockData blockData) {
        if (blockData instanceof Bisected instance && this.bisectedHalf != null)
            instance.setHalf(this.bisectedHalf);
    }

    public void setBisectedHalf(String bisectedHalfString) throws IllegalArgumentException {
        this.bisectedHalf = Bisected.Half.valueOf(bisectedHalfString.toUpperCase());
    }

    @Nullable
    private Boolean bubbleDrag;

    public void applyBubbleDrag(BlockData blockData) {
        if (blockData instanceof BubbleColumn instance && this.bubbleDrag != null)
            instance.setDrag(this.bubbleDrag);
    }

    @Nullable
    private Integer cakeBites;

    public void applyCakeBites(BlockData blockData) {
        if (blockData instanceof Cake instance && this.cakeBites != null)
            instance.setBites(this.cakeBites);
    }

    @Nullable
    private Boolean signalFire;

    public void applySignalFire(BlockData blockData) {
        if (blockData instanceof Campfire instance && this.signalFire != null)
            instance.setSignalFire(this.signalFire);
    }

    @Nullable
    private Integer candles;

    public void applyCandles(BlockData blockData) {
        if (blockData instanceof Candle instance && this.candles != null)
            instance.setCandles(this.candles);
    }

    @Nullable
    private Boolean lit;

    public void applyLit(BlockData blockData) {
        if (blockData instanceof Lightable instance && this.lit != null)
            instance.setLit(this.lit);
    }

    @Nullable
    private Boolean berries;

    public void applyBerries(BlockData blockData) {
        if (blockData instanceof CaveVinesPlant instance && this.berries != null)
            instance.setBerries(this.berries);
    }

    @Nullable
    private Chest.Type chestType;

    public void applyChestType(BlockData blockData) {
        if (blockData instanceof Chest instance && this.chestType != null)
            instance.setType(this.chestType);
    }

    public void setChestType(String chestTypeString) throws IllegalArgumentException {
        this.chestType = Chest.Type.valueOf(chestTypeString.toUpperCase());
    }

    @Nullable
    private Boolean conditional;

    public void applyConditional(BlockData blockData) {
        if (blockData instanceof CommandBlock instance && this.conditional != null)
            instance.setConditional(this.conditional);
    }

    @Nullable
    private Comparator.Mode comparatorMode;

    public void applyComparatorMode(BlockData blockData) {
        if (blockData instanceof Comparator instance && this.comparatorMode != null)
            instance.setMode(this.comparatorMode);
    }

    public void setComparatorMode(String comparatorModeString) throws IllegalArgumentException {
        this.comparatorMode = Comparator.Mode.valueOf(comparatorModeString.toUpperCase());
    }

    @Nullable
    private Crafter.Orientation crafterOrientation;

    public void applyCrafterOrientation(BlockData blockData) {
        if (blockData instanceof Crafter instance && this.crafterOrientation != null)
            instance.setOrientation(this.crafterOrientation);
    }

    public void setCrafterOrientation(String crafterOrientationString) throws IllegalArgumentException {
        this.crafterOrientation = Crafter.Orientation.valueOf(crafterOrientationString.toUpperCase());
    }

    @Nullable
    private Boolean crafterCrafting;

    public void applyCrafterCrafting(BlockData blockData) {
        if (blockData instanceof Crafter instance && this.crafterCrafting != null)
            instance.setCrafting(this.crafterCrafting);
    }

    @Nullable
    private Boolean crafterTriggered;

    public void applyCrafterTriggered(BlockData blockData) {
        if (blockData instanceof Crafter instance && this.crafterTriggered != null)
            instance.setTriggered(this.crafterTriggered);
    }

    @Nullable
    private Boolean enderEye;

    public void applyHasEye(BlockData blockData) {
        if (blockData instanceof EndPortalFrame instance && this.enderEye != null)
            instance.setEye(this.enderEye);
    }

    @Nullable
    private Integer moisture;

    public void applyMoisture(BlockData blockData) {
        if (blockData instanceof Farmland instance && this.moisture != null)
            instance.setMoisture(this.moisture);
    }

    @Nullable
    private Boolean hanging;

    public void applyHanging(BlockData blockData) {
        if (blockData instanceof Hangable instance && this.hanging != null)
            instance.setHanging(this.hanging);
    }

    @Nullable
    private Integer hatch;

    public void applyHatch(BlockData blockData) {
        if (blockData instanceof Hatchable instance && this.hatch != null)
            instance.setHatch(this.hatch);
    }

    @Nullable
    private Boolean hopperEnabled;

    public void applyHopperEnabled(BlockData blockData) {
        if (blockData instanceof Hopper instance && this.hopperEnabled != null)
            instance.setEnabled(this.hopperEnabled);
    }

    @Nullable
    private Jigsaw.Orientation jigsawOrientation;

    public void applyJigsawOrientation(BlockData blockData) {
        if (blockData instanceof Jigsaw instance && this.jigsawOrientation != null)
            instance.setOrientation(this.jigsawOrientation);
    }

    public void setJigsawOrientation(String jigsawOrientationString) throws IllegalArgumentException {
        this.jigsawOrientation = Jigsaw.Orientation.valueOf(jigsawOrientationString.toUpperCase());
    }

    @Nullable
    private Integer level;

    public void applyLevel(BlockData blockData) {
        if (blockData instanceof Levelled instance && this.level != null)
            instance.setLevel(this.level);
    }

    @Nullable
    private Instrument instrument;

    public void applyInstrument(BlockData blockData) {
        if (blockData instanceof NoteBlock instance && this.instrument != null)
            instance.setInstrument(this.instrument);
    }

    public void setInstrument(String instrumentString) throws IllegalArgumentException {
        this.instrument = Instrument.valueOf(instrumentString.toUpperCase());
    }

    @Nullable
    private Integer note;

    public void applyNote(BlockData blockData) {
        if (blockData instanceof NoteBlock instance && this.note != null)
            instance.setNote(new Note(this.note));
    }

    @Nullable
    private Boolean extended;

    public void applyExtended(BlockData blockData) {
        if (blockData instanceof Piston instance && this.extended != null)
            instance.setExtended(this.extended);
    }

    @Nullable
    private PointedDripstone.Thickness dripstoneThickness;

    public void applyDripstoneThickness(BlockData blockData) {
        if (blockData instanceof PointedDripstone instance && this.dripstoneThickness != null)
            instance.setThickness(this.dripstoneThickness);
    }

    public void setDripstoneThickness(String dripstoneThicknessString) throws IllegalArgumentException {
        this.dripstoneThickness = PointedDripstone.Thickness.valueOf(dripstoneThicknessString.toUpperCase());
    }

    @Nullable
    private BlockFace dripstoneVerticalDirection;

    public void applyDripstoneVerticalDirection(BlockData blockData) {
        if (blockData instanceof PointedDripstone instance && this.dripstoneVerticalDirection != null)
            instance.setVerticalDirection(this.dripstoneVerticalDirection);
    }

    public void setDripstoneVerticalDirection(String dripstoneVerticalDirectionString) throws IllegalArgumentException {
        this.dripstoneVerticalDirection = BlockFace.valueOf(dripstoneVerticalDirectionString.toUpperCase());
    }

    @Nullable
    private Rail.Shape railShape;

    public void applyRailShape(BlockData blockData) {
        if (blockData instanceof Rail instance && this.railShape != null)
            instance.setShape(this.railShape);
    }

    public void setRailShape(String railShapeString) throws IllegalArgumentException {
        this.railShape = Rail.Shape.valueOf(railShapeString.toUpperCase());
    }

    @Nullable
    private Integer repeaterDelay;

    public void applyRepeaterDelay(BlockData blockData) {
        if (blockData instanceof Repeater instance && this.repeaterDelay != null)
            instance.setDelay(this.repeaterDelay);
    }

    @Nullable
    private Boolean repeaterLocked;

    public void applyRepeaterLocked(BlockData blockData) {
        if (blockData instanceof Repeater instance && this.repeaterLocked != null)
            instance.setLocked(this.repeaterLocked);
    }

    @Nullable
    private Integer charges;

    public void applyCharges(BlockData blockData) {
        if (blockData instanceof RespawnAnchor instance && this.charges != null)
            instance.setCharges(this.charges);
    }

    @Nullable
    private Integer scaffoldingDistance;

    public void applyScaffoldingDistance(BlockData blockData) {
        if (blockData instanceof Scaffolding instance && this.scaffoldingDistance != null)
            instance.setDistance(this.scaffoldingDistance);
    }

    @Nullable
    private Boolean scaffoldingBottom;

    public void applyScaffoldingBottom(BlockData blockData) {
        if (blockData instanceof Scaffolding instance && this.scaffoldingBottom != null)
            instance.setBottom(this.scaffoldingBottom);
    }

    @Nullable
    private Boolean sculkShriekerCanSummon;

    public void applySculkShriekerCanSummon(BlockData blockData) {
        if (blockData instanceof SculkShrieker instance && this.sculkShriekerCanSummon != null)
            instance.setCanSummon(this.sculkShriekerCanSummon);
    }

    @Nullable
    private Boolean sculkCatalystBloom;

    public void applySculkCatalystBloom(BlockData blockData) {
        if (blockData instanceof SculkCatalyst instance && this.sculkCatalystBloom != null)
            instance.setBloom(this.sculkCatalystBloom);
    }

    @Nullable
    private Boolean sculkShriekerShrieking;

    public void applySculkShriekerShrieking(BlockData blockData) {
        if (blockData instanceof SculkShrieker instance && this.sculkShriekerShrieking != null)
            instance.setShrieking(this.sculkShriekerShrieking);
    }

    @Nullable
    private Integer pickles;

    public void applyPickles(BlockData blockData) {
        if (blockData instanceof SeaPickle instance && this.pickles != null)
            instance.setPickles(this.pickles);
    }

    @Nullable
    private Slab.Type slabType;

    public void applySlabType(BlockData blockData) {
        if (blockData instanceof Slab instance && this.slabType != null)
            instance.setType(this.slabType);
    }

    public void setSlabType(String slabTypeString) throws IllegalArgumentException {
        this.slabType = Slab.Type.valueOf(slabTypeString.toUpperCase());
    }

    @Nullable
    private Integer snowLayers;

    public void applySnowLayers(BlockData blockData) {
        if (blockData instanceof Snow instance && this.snowLayers != null)
            instance.setLayers(this.snowLayers);
    }

    @Nullable
    private Boolean snowy;

    public void applySnowy(BlockData blockData) {
        if (blockData instanceof Snowable instance && this.snowy != null)
            instance.setSnowy(this.snowy);
    }

    @Nullable
    private Stairs.Shape stairsShape;

    public void applyStairsShape(BlockData blockData) {
        if (blockData instanceof Stairs instance && this.stairsShape != null)
            instance.setShape(this.stairsShape);
    }

    public void setStairsShape(String stairsShapeString) throws IllegalArgumentException {
        this.stairsShape = Stairs.Shape.valueOf(stairsShapeString.toUpperCase());
    }

    @Nullable
    private StructureBlock.Mode structureBlockMode;

    public void applyStructureBlockMode(BlockData blockData) {
        if (blockData instanceof StructureBlock instance && this.structureBlockMode != null)
            instance.setMode(this.structureBlockMode);
    }

    public void setStructureBlockMode(String structureBlockModeString) throws IllegalArgumentException {
        this.structureBlockMode = StructureBlock.Mode.valueOf(structureBlockModeString.toUpperCase());
    }

    @Nullable
    private TechnicalPiston.Type pistonType;

    public void applyPistonType(BlockData blockData) {
        if (blockData instanceof TechnicalPiston instance && this.pistonType != null)
            instance.setType(this.pistonType);
    }

    public void setPistonType(String pistonTypeString) throws IllegalArgumentException {
        this.pistonType = TechnicalPiston.Type.valueOf(pistonTypeString.toUpperCase());
    }

    @Nullable
    private Boolean trialSpawnerOminous;

    public void applyTrialSpawnerOminous(BlockData blockData) {
        if (blockData instanceof TrialSpawner instance && this.trialSpawnerOminous != null)
            instance.setOminous(this.trialSpawnerOminous);
    }

    @Nullable
    private TrialSpawner.State trialSpawnerState;

    public void applyTrialSpawnerState(BlockData blockData) {
        if (blockData instanceof TrialSpawner instance && this.trialSpawnerState != null)
            instance.setTrialSpawnerState(this.trialSpawnerState);
    }

    public void setTrialSpawnerState(String trialSpawnerStateString) throws IllegalArgumentException {
        this.trialSpawnerState = TrialSpawner.State.valueOf(trialSpawnerStateString.toUpperCase());
    }

    @Nullable
    private Boolean vaultOminous;

    public void applyVaultOminous(BlockData blockData) {
        if (blockData instanceof Vault instance && this.vaultOminous != null)
            instance.setOminous(this.vaultOminous);
    }

    @Nullable
    private Vault.State vaultState;

    public void applyVaultState(BlockData blockData) {
        if (blockData instanceof Vault instance && this.vaultState != null)
            instance.setTrialSpawnerState(this.vaultState);
    }

    public void setVaultState(String vaultStateString) throws IllegalArgumentException {
        this.vaultState = Vault.State.valueOf(vaultStateString.toUpperCase());
    }

    @Nullable
    private Boolean tripwireDisarmed;

    public void applyTripwireDisarmed(BlockData blockData) {
        if (blockData instanceof Tripwire instance && this.tripwireDisarmed != null)
            instance.setDisarmed(this.tripwireDisarmed);
    }

    @Nullable
    private Integer turtleEggs;

    public void applyTurtleEggs(BlockData blockData) {
        if (blockData instanceof TurtleEgg instance && this.turtleEggs != null)
            instance.setEggs(this.turtleEggs);
    }

    @Nullable
    private Integer dusted;

    public void applyDusted(BlockData blockData) {
        if (blockData instanceof Brushable instance && this.dusted != null)
            instance.setDusted(this.dusted);
    }

    @Nullable
    private Integer flowerAmount;

    public void applyFlowerAmount(BlockData blockData) {
        if (this.FLOWED_BED_CLASS != null && this.FLOWED_BED_CLASS.isInstance(blockData) && this.flowerAmount != null) {
            try {
                this.FLOWED_BED_CLASS.getMethod("setFlowerAmount", int.class).invoke(blockData, this.flowerAmount);
            } catch (Exception ignored) {
            }
        }
    }

    @Nullable
    private Integer segmentAmount;

    public void applySegmentAmount(BlockData blockData) {
        if (this.LEAF_LITTER_CLASS != null && this.LEAF_LITTER_CLASS.isInstance(blockData) && this.segmentAmount != null) {
            try {
                this.LEAF_LITTER_CLASS.getMethod("setSegmentAmount", int.class).invoke(blockData, this.segmentAmount);
            } catch (Exception ignored) {
            }
        }
    }

    @Nullable
    private Enum<?> creakingHeartState;

    public void applyCreakingHeartState(BlockData blockData) {
        if (this.CREAKING_HEART_CLASS != null && this.CREAKING_HEART_CLASS.isInstance(blockData) && this.creakingHeartState != null) {
            try {
                this.CREAKING_HEART_CLASS.getMethod("setState", Enum.class).invoke(blockData, this.creakingHeartState);
            } catch (Exception ignored) {
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void setCreakingHeartState(String creakingHeartStateString) throws IllegalArgumentException {
        if (this.CREAKING_HEART_STATE_CLASS != null)
            this.creakingHeartState = Enum.valueOf((Class) this.CREAKING_HEART_STATE_CLASS, creakingHeartStateString.toUpperCase());
    }

    @Nullable
    private Boolean creakingHeartActive;

    public void applyCreakingHeartActive(BlockData blockData) {
        if (this.CREAKING_HEART_CLASS != null && this.CREAKING_HEART_CLASS.isInstance(blockData) && this.creakingHeartActive != null) {
            try {
                this.CREAKING_HEART_CLASS.getMethod("setActive", boolean.class).invoke(blockData, this.creakingHeartActive);
            } catch (Exception ignored) {
            }
        }
    }

    @Nullable
    private Boolean creakingHeartNatural;

    public void applyCreakingHeartNatural(BlockData blockData) {
        if (this.CREAKING_HEART_CLASS != null && this.CREAKING_HEART_CLASS.isInstance(blockData) && this.creakingHeartNatural != null) {
            try {
                this.CREAKING_HEART_CLASS.getMethod("setNatural", boolean.class).invoke(blockData, this.creakingHeartNatural);
            } catch (Exception ignored) {
            }
        }
    }

    @Nullable
    private Map<BlockFace, Enum<?>> mossyCarpetHeights;

    public void applyMossyCarpetHeights(BlockData blockData) {
        if (this.MOSSY_CARPET_CLASS != null && this.MOSSY_CARPET_CLASS.isInstance(blockData) && this.mossyCarpetHeights != null) {
            try {
                Method setHeightMethod = this.MOSSY_CARPET_CLASS.getMethod("setHeight", BlockFace.class, this.MOSSY_CARPET_HEIGHT_CLASS);
                for (Map.Entry<BlockFace, Enum<?>> entry : this.mossyCarpetHeights.entrySet())
                    setHeightMethod.invoke(blockData, entry.getKey(), entry.getValue());
            } catch (Exception ignored) {
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void setMossyCarpetHeights(String faceString, String mossyCarpetHeightString) throws IllegalArgumentException {
        if (this.mossyCarpetHeights == null)
            this.mossyCarpetHeights = new HashMap<>();
        if (this.MOSSY_CARPET_HEIGHT_CLASS != null)
            this.mossyCarpetHeights.put(BlockFace.valueOf(faceString.toUpperCase()), Enum.valueOf((Class) this.MOSSY_CARPET_HEIGHT_CLASS, mossyCarpetHeightString.toUpperCase()));
    }

    @Nullable
    private Boolean wallUp;

    public void applyWallUp(BlockData blockData) {
        if (blockData instanceof Wall instance && this.wallUp != null)
            instance.setUp(this.wallUp);
    }

    @Nullable
    private Boolean mossyCarpetBottom;

    public void applyMossyCarpetBottom(BlockData blockData) {
        if (this.MOSSY_CARPET_CLASS != null && this.MOSSY_CARPET_CLASS.isInstance(blockData) && this.mossyCarpetHeights != null) {
            try {
                this.MOSSY_CARPET_CLASS.getMethod("setBottom", boolean.class).invoke(blockData, this.mossyCarpetBottom);
            } catch (Exception ignored) {
            }
        }
    }
}
