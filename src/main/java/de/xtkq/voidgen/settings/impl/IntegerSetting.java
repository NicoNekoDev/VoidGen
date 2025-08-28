package de.xtkq.voidgen.settings.impl;

import de.xtkq.voidgen.settings.Setting;
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
