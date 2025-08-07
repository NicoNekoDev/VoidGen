package de.xtkq.voidgen;

import com.tcoded.folialib.FoliaLib;
import de.xtkq.voidgen.events.EventManager;
import de.xtkq.voidgen.generator.annotations.VoidChunkGenInfo;
import de.xtkq.voidgen.generator.instances.*;
import de.xtkq.voidgen.settings.ConfigManager;
import de.xtkq.voidgen.utils.MetricsUtils;
import de.xtkq.voidgen.utils.UpdateUtils;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public final class VoidGen extends JavaPlugin {
    @Getter
    private FoliaLib foliaLib;
    private ChunkGenVersion chunkGenVersion;
    private EventManager eventManager;

    @Override
    public ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, String id) {
        return switch (this.chunkGenVersion) {
            case VERSION_1_8 -> throw new UnsupportedOperationException("VoidGen is not supported anymore for versions bellow 1.15!");
            case VERSION_1_15 -> new VoidChunkGen_1_15(this, id);
            case VERSION_1_17 -> new VoidChunkGen_1_17(this, id);
            case VERSION_1_17_1 -> new VoidChunkGen_1_17_1(this, id);
            case VERSION_1_19 -> new VoidChunkGen_1_19(this, id);
            default -> new VoidChunkGen_1_21_3(this, id);
        };
    }

    @Override
    public void onEnable() {
        this.foliaLib = new FoliaLib(this);
        this.chunkGenVersion = this.setupVoidChunkGen();
        this.getLogger().info("Using VoidChunkGen: " + this.chunkGenVersion.name());

        ConfigManager configManager = new ConfigManager(this);
        UpdateUtils updateUtils = new UpdateUtils(this);
        this.eventManager = new EventManager(this);

        if (configManager.getConfiguration().getCheckForUpdates()) {
            updateUtils.checkForUpdates();
            this.eventManager.initialize();
        }

        if (configManager.getConfiguration().getMetrics()) {
            new MetricsUtils(this, 26816);
        }
    }

    @Override
    public void onDisable() {
        this.foliaLib.getScheduler().cancelAllTasks();
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

        annotation = VoidChunkGen_1_19.class.getAnnotation(VoidChunkGenInfo.class);
        if (Arrays.asList(annotation.versions()).contains(bukkitVersion)) {
            return ChunkGenVersion.VERSION_1_19;
        }

        annotation = VoidChunkGen_1_21_3.class.getAnnotation(VoidChunkGenInfo.class);
        if (Arrays.asList(annotation.versions()).contains(bukkitVersion)) {
            return ChunkGenVersion.VERSION_1_21_3;
        }

        return ChunkGenVersion.VERSION_UNKNOWN;
    }
}
