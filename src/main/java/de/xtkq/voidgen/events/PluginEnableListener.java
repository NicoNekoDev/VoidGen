package de.xtkq.voidgen.events;

import de.xtkq.voidgen.VoidGen;
import de.xtkq.voidgen.hooks.MultiverseGeneratorPluginHook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.mvplugins.multiverse.core.MultiverseCoreApi;

public class PluginEnableListener implements Listener {

    private final VoidGen voidGen;

    public PluginEnableListener(VoidGen voidGen) {
        this.voidGen = voidGen;
        this.voidGen.getServer().getPluginManager().registerEvents(this, voidGen);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPluginLoad(PluginEnableEvent event) {
        if (event.getPlugin().getName().equals("Multiverse-Core")) {
            try {
                Class.forName("org.mvplugins.multiverse.core.MultiverseCoreApi");
                MultiverseCoreApi.get().getGeneratorProvider().registerGeneratorPlugin(new MultiverseGeneratorPluginHook());
            } catch (ClassNotFoundException ignore) {
                // ignore - assume multiverse not installed
            }
        }
    }

    public void terminate() {
        PlayerLoginEvent.getHandlerList().unregister(this.voidGen);
    }
}
