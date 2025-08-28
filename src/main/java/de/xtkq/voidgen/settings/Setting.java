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
