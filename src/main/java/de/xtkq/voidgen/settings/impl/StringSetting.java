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
