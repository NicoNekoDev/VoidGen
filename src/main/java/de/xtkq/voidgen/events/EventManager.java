package de.xtkq.voidgen.events;

import de.xtkq.voidgen.VoidGen;

public class EventManager {

    private final VoidGen voidGen;
    private PlayerLoginListener playerLogin;
    private PluginEnableListener pluginEnable;

    public EventManager(VoidGen voidGen) {
        this.voidGen = voidGen;
    }

    public void initialize() {
        this.playerLogin = new PlayerLoginListener(this.voidGen);
        this.pluginEnable = new PluginEnableListener(this.voidGen);
    }

    public void terminate() {
        if (this.playerLogin != null)
            this.playerLogin.terminate();
        if (this.pluginEnable != null)
            this.pluginEnable.terminate();
    }
}

