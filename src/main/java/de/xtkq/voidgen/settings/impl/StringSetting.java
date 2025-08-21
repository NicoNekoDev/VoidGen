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

package de.xtkq.voidgen.settings.impl;

import de.xtkq.voidgen.settings.Setting;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;
import java.util.logging.Logger;

public class StringSetting extends Setting<String> {

    public StringSetting(String key, String defaultValue, List<String> comments, List<String> inlineComments) {
        super(key, defaultValue, comments, inlineComments);
    }

    public StringSetting(String key, String defaultValue, List<String> comments) {
        super(key, defaultValue, comments, List.of());
    }

    public StringSetting(String key, String defaultValue) {
        super(key, defaultValue, List.of(), List.of());
    }

    @Override
    public final StringSetting load(ConfigurationSection section, boolean firstTime, Logger logger) {
        if (section.isString(super.key))
            super.value = section.getString(super.key, super.defaultValue);
        else {
            if (!firstTime)
                logger.info("String at key: " + section.getCurrentPath() + super.key + " doesn't exists, creating...");
            super.setup(section);
        }
        return this;
    }
}
