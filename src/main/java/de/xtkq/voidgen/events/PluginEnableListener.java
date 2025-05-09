package de.xtkq.voidgen.events;

import de.xtkq.voidgen.hook.MultiverseGeneratorPluginHook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.mvplugins.multiverse.core.MultiverseCoreApi;

public class PluginEnableListener implements Listener {

    private final JavaPlugin plugin;

    public PluginEnableListener(JavaPlugin paramPlugin) {
        this.plugin = paramPlugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPluginLoad(PluginEnableEvent event) {
        if (event.getPlugin().getName().equals("Multiverse-Core")) {
            try {
                Class.forName("org.mvplugins.multiverse.core.MultiverseCoreApi");
                MultiverseCoreApi.get().getGeneratorProvider().registerGeneratorPlugin(new MultiverseGeneratorPluginHook());
            } catch (ClassNotFoundException e) {
                // ignore - assume multiverse not installed
            }
        }
    }

    public void terminate() {
        PlayerLoginEvent.getHandlerList().unregister(this.plugin);
    }
}
