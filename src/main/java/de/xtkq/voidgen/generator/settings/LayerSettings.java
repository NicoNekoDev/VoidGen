package de.xtkq.voidgen.generator.settings;

import lombok.*;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    public BlockData getBlockData() {
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
}
