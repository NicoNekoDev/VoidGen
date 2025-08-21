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

public class BooleanSetting extends Setting<Boolean> {

    public BooleanSetting(String value, Boolean defaultValue, List<String> comments, List<String> inlineComments) {
        super(value, defaultValue, comments, inlineComments);
    }

    public BooleanSetting(String value, Boolean defaultValue, List<String> comments) {
        super(value, defaultValue, comments, List.of());
    }

    public BooleanSetting(String value, Boolean defaultValue) {
        super(value, defaultValue, List.of(), List.of());
    }

    @Override
    public final BooleanSetting load(ConfigurationSection section, boolean firstTime, Logger logger) {
        if (section.isBoolean(super.key))
            super.value = section.getBoolean(super.key);
        else if (section.isString(super.key)) {
            String str = section.getString(super.key, this.defaultValue ? "yes" : "no");
            if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false"))
                super.value = Boolean.parseBoolean(str);
            else if (str.equalsIgnoreCase("yes"))
                super.value = true;
            else if (str.equalsIgnoreCase("no"))
                super.value = false;
            else this.setup(section);
        } else {
            if (!firstTime)
                logger.info("Boolean at key: " + section.getCurrentPath() + super.key + " doesn't exists, creating...");
            super.setup(section);
        }
        return this;
    }
}
