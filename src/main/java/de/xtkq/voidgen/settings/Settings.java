package de.xtkq.voidgen.settings;

import de.xtkq.voidgen.settings.impl.BooleanSetting;

import java.util.List;

public class Settings {
    public static final BooleanSetting CHECK_FOR_UPDATES = new BooleanSetting("check_for_updates", true,
            List.of(
                    "Whether or not to check for updates."
            )
    );
    public static final BooleanSetting ENABLE_METRICS = new BooleanSetting("enable_metrics", true,
            List.of(
                    "bStats metrics collected by this plugin.",
                    "https://bstats.org/plugin/bukkit/VoidGen/26816"
            )
    );
    public static final BooleanSetting ENABLE_VERBOSE = new BooleanSetting("enable_verbose", true,
            List.of(
                    "Setting it to false will disable all debug messages."
            )
    );
}