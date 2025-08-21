/*
 *     CitizensBooks
 *     Copyright (c) 2023 @ Drăghiciu 'NicoNekoDev' Nicolae
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package de.xtkq.voidgen.settings;

import de.xtkq.voidgen.VoidGen;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.logging.Logger;

public class SettingsManager {

    public static void load(VoidGen plugin) {
        final File settingsFile = new File(plugin.getDataFolder(), "settings.yml");
        boolean firstTime = !settingsFile.exists();
        if (firstTime)
            plugin.getLogger().info("Creating settings.yml...");
        try {
            final YamlConfiguration settings = YamlConfiguration.loadConfiguration(settingsFile);
            loadValues(settings, Settings.class, firstTime, plugin.getLogger());
            settings.save(settingsFile);
            if (firstTime)
                plugin.getLogger().info("Successfully created settings.yml!");
        } catch (IOException | IllegalAccessException ex) {
            if (firstTime)
                plugin.getLogger().info("Failed to create settings.yml!");
        }
    }

    public static void loadValues(ConfigurationSection section, Class<?> clazz, boolean firstTime, Logger logger) throws IllegalAccessException {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.get(null) instanceof Setting<?> setting)
                setting.load(section, firstTime, logger);
        }
    }
}
