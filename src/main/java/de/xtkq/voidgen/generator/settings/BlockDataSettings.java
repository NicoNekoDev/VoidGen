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

@SuppressWarnings("deprecation")
@Getter
@Setter
public class BlockDataSettings {

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

    @Nullable
    private DyeColor color;

    public void applyColor(BlockData blockData) {
        if (blockData instanceof Colorable instance && this.color != null)
            instance.setColor(this.color);
    }

    @Nullable
    private Bed.Part bedPart;

    public void applyBedPart(BlockData blockData) {
        if (blockData instanceof Bed instance && this.bedPart != null)
            instance.setPart(this.bedPart);
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

    @Nullable
    private BigDripleaf.Tilt dripleafTilt;

    public void applyDripleafTilt(BlockData blockData) {
        if (blockData instanceof BigDripleaf instance && this.dripleafTilt != null)
            instance.setTilt(this.dripleafTilt);
    }

    @Nullable
    private Bisected.Half bisectedHalf;

    public void applyBisectedHalf(BlockData blockData) {
        if (blockData instanceof Bisected instance && this.bisectedHalf != null)
            instance.setHalf(this.bisectedHalf);
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

    @Nullable
    private Crafter.Orientation crafterOrientation;

    public void applyCrafterOrientation(BlockData blockData) {
        if (blockData instanceof Crafter instance && this.crafterOrientation != null)
            instance.setOrientation(this.crafterOrientation);
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
    private Boolean hasEye;

    public void applyHasEye(BlockData blockData) {
        if (blockData instanceof EndPortalFrame instance && this.hasEye != null)
            instance.setEye(this.hasEye);
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

    @Nullable
    private BlockFace dripstoneVerticalDirection;

    public void applyDripstoneVerticalDirection(BlockData blockData) {
        if (blockData instanceof PointedDripstone instance && this.dripstoneVerticalDirection != null)
            instance.setVerticalDirection(this.dripstoneVerticalDirection);
    }

    @Nullable
    private Rail.Shape railShape;

    public void applyRailShape(BlockData blockData) {
        if (blockData instanceof Rail instance && this.railShape != null)
            instance.setShape(this.railShape);
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

    @Nullable
    private StructureBlock.Mode structureBlockMode;

    public void applyStructureBlockMode(BlockData blockData) {
        if (blockData instanceof StructureBlock instance && this.structureBlockMode != null)
            instance.setMode(this.structureBlockMode);
    }

    @Nullable
    private TechnicalPiston.Type pistonType;

    public void applyPistonType(BlockData blockData) {
        if (blockData instanceof TechnicalPiston instance && this.pistonType != null)
            instance.setType(this.pistonType);
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

    @Nullable
    private Vault.State vaultState;

    public void applyVaultState(BlockData blockData) {
        if (blockData instanceof Vault instance && this.vaultState != null)
            instance.setTrialSpawnerState(this.vaultState);
    }

    @Nullable
    private Boolean tripwireHookDisarmed;

    public void applyTripwireHookDisarmed(BlockData blockData) {
        if (blockData instanceof Tripwire instance && this.tripwireHookDisarmed != null)
            instance.setDisarmed(this.tripwireHookDisarmed);
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
}
