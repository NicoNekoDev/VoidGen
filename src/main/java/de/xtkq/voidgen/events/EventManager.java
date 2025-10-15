package de.xtkq.voidgen.events;

import de.xtkq.voidgen.VoidGen;

public class EventManager {

    private final VoidGen voidGen;
    private PlayerJoinListener playerJoin;
    private PluginEnableListener pluginEnable;

    public EventManager(VoidGen voidGen) {
        this.voidGen = voidGen;
    }

    public void initialize() {
        this.playerJoin = new PlayerJoinListener(this.voidGen);
        this.pluginEnable = new PluginEnableListener(this.voidGen);
    }

    public void terminate() {
        if (this.playerJoin != null)
            this.playerJoin.terminate();
        if (this.pluginEnable != null)
            this.pluginEnable.terminate();
    }
}

