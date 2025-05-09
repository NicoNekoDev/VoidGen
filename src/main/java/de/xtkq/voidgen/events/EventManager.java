package de.xtkq.voidgen.events;

import org.bukkit.plugin.java.JavaPlugin;

public class EventManager {

    private final JavaPlugin javaPlugin;
    private PlayerLoginListener playerLogin;
    private PluginEnableListener pluginEnable;

    public EventManager(JavaPlugin paramPlugin) {
        this.javaPlugin = paramPlugin;
    }

    public void initialize() {
        this.playerLogin = new PlayerLoginListener(this.javaPlugin);
        this.pluginEnable = new PluginEnableListener(this.javaPlugin);
    }

    public void terminate() {
        if (this.playerLogin != null) {
            this.playerLogin.terminate();
        }
        if (this.pluginEnable != null) {
            this.pluginEnable.terminate();
        }
    }
}

