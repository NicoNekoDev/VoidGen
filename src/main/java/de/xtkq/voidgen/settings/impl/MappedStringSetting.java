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
        ConfigurationSection upperSection = section.getConfigurationSection(super.key);
        if (upperSection != null) {
            this.value = new HashMap<>();
            for (String key : upperSection.getKeys(false))
                if (upperSection.isString(key))
                    this.value.put(key, upperSection.getString(key));
        } else {
            if (!firstTime)
                logger.info("Mapped strings at key: " + section.getCurrentPath() + super.key + " doesn't exists, creating...");
            this.setup(section);
        }
        return this;
    }

    @Override
    protected void setup(ConfigurationSection section) {
        ConfigurationSection upperSection = section.createSection(super.key);
        for (Map.Entry<String, String> entry : this.defaultValue.entrySet())
            upperSection.set(entry.getKey(), entry.getValue());
        this.value = super.defaultValue;
        if (!super.comments.isEmpty()) upperSection.setComments(super.key, super.comments);
        if (!super.inlineComments.isEmpty()) upperSection.setInlineComments(super.key, super.inlineComments);
    }
}
