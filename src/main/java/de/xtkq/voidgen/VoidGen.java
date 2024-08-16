package de.xtkq.voidgen;

import de.xtkq.voidgen.events.EventManager;
import de.xtkq.voidgen.generator.annotations.VoidChunkGenInfo;
import de.xtkq.voidgen.generator.instances.VoidChunkGen_1_15;
import de.xtkq.voidgen.generator.instances.VoidChunkGen_1_17;
import de.xtkq.voidgen.generator.instances.VoidChunkGen_1_17_1;
import de.xtkq.voidgen.generator.instances.VoidChunkGen_1_8_8;
import de.xtkq.voidgen.settings.ConfigManager;
import de.xtkq.voidgen.utils.UpdateUtils;
import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import space.arim.morepaperlib.MorePaperLib;

import java.util.Arrays;

public final class VoidGen extends JavaPlugin {

    public static MorePaperLib morePaperLib;

    private ChunkGenVersion chunkGenVersion;
    private EventManager eventManager;

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        switch (this.chunkGenVersion) {
            case VERSION_1_8:
                return new VoidChunkGen_1_8_8(this, id);
            case VERSION_1_15:
                return new VoidChunkGen_1_15(this, id);
            case VERSION_1_17:
                return new VoidChunkGen_1_17(this, id);
            default:
                return new VoidChunkGen_1_17_1(this, id);
        }
    }

    @Override
    public void onEnable() {
        this.morePaperLib = new MorePaperLib(this);
        this.chunkGenVersion = this.setupVoidChunkGen();
        this.getLogger().info("Using VoidChunkGen: " + this.chunkGenVersion.name());

        ConfigManager configManager = new ConfigManager(this);
        UpdateUtils updateUtils = new UpdateUtils(this);
        this.eventManager = new EventManager(this);

        if (configManager.getConfiguration().getCheckForUpdates()) {
            updateUtils.checkForUpdates();
            this.eventManager.initialize();
        }
    }

    @Override
    public void onDisable() {
        morePaperLib.scheduling().cancelGlobalTasks();
        this.eventManager.terminate();
    }

    private ChunkGenVersion setupVoidChunkGen() {
        VoidChunkGenInfo annotation;
        String bukkitVersion = Bukkit.getBukkitVersion().split("-")[0];

        annotation = VoidChunkGen_1_8_8.class.getAnnotation(VoidChunkGenInfo.class);
        if (Arrays.asList(annotation.versions()).contains(bukkitVersion)) {
            return ChunkGenVersion.VERSION_1_8;
        }

        annotation = VoidChunkGen_1_15.class.getAnnotation(VoidChunkGenInfo.class);
        if (Arrays.asList(annotation.versions()).contains(bukkitVersion)) {
            return ChunkGenVersion.VERSION_1_15;
        }

        annotation = VoidChunkGen_1_17.class.getAnnotation(VoidChunkGenInfo.class);
        if (Arrays.asList(annotation.versions()).contains(bukkitVersion)) {
            return ChunkGenVersion.VERSION_1_17;
        }

        annotation = VoidChunkGen_1_17_1.class.getAnnotation(VoidChunkGenInfo.class);
        if (Arrays.asList(annotation.versions()).contains(bukkitVersion)) {
            return ChunkGenVersion.VERSION_1_17_1;
        }

        return ChunkGenVersion.VERSION_UNKNOWN;
    }
}
