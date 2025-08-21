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
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;
import java.util.logging.Logger;

public class IntegerSetting extends Setting<Integer> {
    private final int min, max;

    public IntegerSetting(String value, Integer defaultValue, List<String> comments, List<String> inlineComments, int min, int max) {
        super(value, defaultValue, comments, inlineComments);
        this.min = min;
        this.max = max;
    }

    public IntegerSetting(String value, Integer defaultValue, List<String> comments, List<String> inlineComments, int min) {
        this(value, defaultValue, comments, inlineComments, min, Integer.MAX_VALUE);
    }

    public IntegerSetting(String value, Integer defaultValue, List<String> comments, List<String> inlineComments) {
        this(value, defaultValue, comments, inlineComments, Integer.MIN_VALUE);
    }

    public IntegerSetting(String value, Integer defaultValue, List<String> comments, int min, int max) {
        this(value, defaultValue, comments, List.of(), min, max);
    }

    public IntegerSetting(String value, Integer defaultValue, List<String> comments, int min) {
        this(value, defaultValue, comments, List.of(), min);
    }

    public IntegerSetting(String value, Integer defaultValue, List<String> comments) {
        this(value, defaultValue, comments, List.of());
    }

    public IntegerSetting(String value, Integer defaultValue, int min, int max) {
        this(value, defaultValue, List.of(), min, max);
    }

    public IntegerSetting(String value, Integer defaultValue, int min) {
        this(value, defaultValue, List.of(), min);
    }

    public IntegerSetting(String value, Integer defaultValue) {
        this(value, defaultValue, List.of());
    }

    @Override
    public final IntegerSetting load(ConfigurationSection section, boolean firstTime, Logger logger) {
        if (section.isInt(super.key))
            super.value = section.getInt(super.key, super.defaultValue);
        else {
            if (!firstTime)
                logger.info("Integer at key: " + section.getCurrentPath() + super.key + " doesn't exists, creating...");
            super.setup(section);
        }
        if (super.value < min) {
            logger.info("Value for integer at key: " + section.getCurrentPath() + super.key + " is too small! Setting to the minimum value: " + this.min);
            super.value = min;
            section.set(this.key, this.value);
        } else if (super.value > max) {
            logger.info("Value for integer at key: " + section.getCurrentPath() + super.key + " is too big! Setting to the maximum value: " + this.max);
            super.value = max;
            section.set(this.key, this.value);
        }
        return this;
    }
}
