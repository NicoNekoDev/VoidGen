package de.xtkq.voidgen.events;

import de.xtkq.voidgen.VoidGen;
import de.xtkq.voidgen.utils.UpdateUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerLoginListener implements Listener {

    private final JavaPlugin plugin;

    public PlayerLoginListener(JavaPlugin paramPlugin) {
        this.plugin = paramPlugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if (UpdateUtils.isUpdateAvailable()) {
            if (player.isOp()) {
                VoidGen.morePaperLib.scheduling().entitySpecificScheduler(player).runDelayed(() -> player.sendMessage(this.getUpdateMessage()),null, 60L);
            }
        }
    }

    private String getUpdateMessage() {
        String updateMessage = String.format("&e%s &7v.%s is available here: &e%s&r", this.plugin.getName(), UpdateUtils.getLatestRelease(), UpdateUtils.getLatestReleaseURL());
        return ChatColor.translateAlternateColorCodes('&', updateMessage);
    }

    public void terminate() {
        PlayerLoginEvent.getHandlerList().unregister(this.plugin);
    }
}
