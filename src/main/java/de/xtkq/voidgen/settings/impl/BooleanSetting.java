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
