package de.xtkq.voidgen.settings.impl;

import de.xtkq.voidgen.settings.Setting;
import lombok.SneakyThrows;
import org.bukkit.configuration.ConfigurationSection;

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;

public class SectionSetting extends Setting<SectionSetting> {

    public SectionSetting(final String key, final List<String> comments, final List<String> inlineComments) {
        super(key, null, comments, inlineComments);
    }

    public SectionSetting(final String key, final List<String> comments) {
        super(key, null, comments, List.of());
    }

    public SectionSetting(final String key) {
        super(key, null, List.of(), List.of());
    }

    @Override
    public SectionSetting get() {
        return this;
    }

    @SneakyThrows
    @Override
    public SectionSetting load(ConfigurationSection section, boolean firstTime, Logger logger) {
        ConfigurationSection upperSection = section.getConfigurationSection(super.key);
        if (upperSection == null) this.setup(section);
        this.loadValues(upperSection, firstTime, logger);
        return this;
    }

    @Override
    protected void setup(ConfigurationSection section) {
        ConfigurationSection upperSection = section.createSection(super.key);
        if (!this.comments.isEmpty()) upperSection.setComments(this.key, this.comments);
        if (!this.inlineComments.isEmpty()) upperSection.setInlineComments(this.key, this.inlineComments);
    }

    private void loadValues(ConfigurationSection section, boolean firstTime, Logger logger) throws IllegalAccessException {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.get(super.value) instanceof Setting<?> setting)
                setting.load(section, firstTime, logger);
        }
    }
}