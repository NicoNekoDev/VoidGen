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
import lombok.SneakyThrows;
import org.bukkit.configuration.ConfigurationSection;

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;

public class SectionSetting<T> extends Setting<T> {
    private final Class<T> clazz;

    public SectionSetting(final String key, Class<T> clazz, final List<String> comments, final List<String> inlineComments) {
        super(key, null, comments, inlineComments);
        this.clazz = clazz;
    }

    public SectionSetting(final String key, Class<T> clazz, final List<String> comments) {
        super(key, null, comments, List.of());
        this.clazz = clazz;
    }

    public SectionSetting(final String key, Class<T> clazz) {
        super(key, null, List.of(), List.of());
        this.clazz = clazz;
    }

    @Override
    public T get() {
        return this.clazz.cast(this);
    }

    @SneakyThrows
    @Override
    public SectionSetting<T> load(ConfigurationSection section, boolean firstTime, Logger logger) {
        ConfigurationSection upper;
        if (section.isConfigurationSection(super.key))
            upper = section.getConfigurationSection(super.key);
        else {
            if (!firstTime)
                logger.info("Section at key: " + section.getCurrentPath() + super.key + " doesn't exists, creating...");
            upper = section.createSection(super.key);
            if (!this.comments.isEmpty()) section.setComments(this.key, this.comments);
            if (!this.inlineComments.isEmpty()) section.setInlineComments(this.key, this.inlineComments);
        }
        this.loadValues(upper, firstTime, logger);
        return this;
    }

    @Override
    public void setup(ConfigurationSection section) {
        section.createSection(super.key);
        if (!this.comments.isEmpty()) section.setComments(this.key, this.comments);
        if (!this.inlineComments.isEmpty()) section.setInlineComments(this.key, this.inlineComments);
    }

    private void loadValues(ConfigurationSection section, boolean firstTime, Logger logger) throws IllegalAccessException {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.get(this) instanceof Setting<?> setting)
                setting.load(section, firstTime, logger);
        }
    }
}
