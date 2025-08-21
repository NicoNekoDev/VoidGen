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

import org.bukkit.configuration.ConfigurationSection;

import java.util.List;
import java.util.logging.Logger;

public abstract class Setting<T> {
    protected T value;
    protected final String key;
    protected final T defaultValue;
    protected final List<String> comments;
    protected final List<String> inlineComments;

    protected Setting(final String key, final T defaultValue, final List<String> comments, final List<String> inlineComments) {
        this.key = key;
        this.defaultValue = defaultValue;
        this.comments = comments;
        this.inlineComments = inlineComments;
    }

    protected void setup(ConfigurationSection section) {
        section.set(this.key, this.defaultValue);
        if (!this.comments.isEmpty()) section.setComments(this.key, this.comments);
        if (!this.inlineComments.isEmpty()) section.setInlineComments(this.key, this.inlineComments);
        this.value = this.defaultValue;
    }

    public abstract Setting<T> load(ConfigurationSection section, boolean firstTime, Logger logger);

    public T get() {
        return this.value;
    }

    public Setting<T> set(T value) {
        this.value = value;
        return this;
    }
}
