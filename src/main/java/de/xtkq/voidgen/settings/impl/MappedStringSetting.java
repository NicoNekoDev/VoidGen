package de.xtkq.voidgen.settings.impl;

import de.xtkq.voidgen.settings.Setting;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class MappedStringSetting extends Setting<Map<String, String>> {

    public MappedStringSetting(String key, Map<String, String> defaultValue, List<String> comments, List<String> inlineComments) {
        super(key, defaultValue, comments, inlineComments);
    }

    public MappedStringSetting(String key, Map<String, String> defaultValue, List<String> comments) {
        super(key, defaultValue, comments, List.of());
    }

    public MappedStringSetting(String key, Map<String, String> defaultValue) {
        super(key, defaultValue, List.of(), List.of());
    }

    @Override
    public final MappedStringSetting load(ConfigurationSection section, boolean firstTime, Logger logger) {
        if (section.isConfigurationSection(super.key)) {
            section = section.getConfigurationSection(super.key);
            this.value = new HashMap<>();
            for (String key : section.getKeys(false))
                if (section.isString(key))
                    this.value.put(key, section.getString(key));
        } else {
            if (!firstTime)
                logger.info("Mapped strings at key: " + section.getCurrentPath() + super.key + " doesn't exists, creating...");
            section = section.createSection(super.key);
            this.value = super.defaultValue;
            for (Map.Entry<String, String> entry : super.defaultValue.entrySet())
                section.set(entry.getKey(), entry.getValue());
            return this;
        }
        return this;
    }
}
