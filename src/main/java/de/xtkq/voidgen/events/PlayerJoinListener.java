package de.xtkq.voidgen.events;

import de.xtkq.voidgen.VoidGen;
import de.xtkq.voidgen.utils.UpdateUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.concurrent.TimeUnit;

public class PlayerJoinListener implements Listener {

    private final VoidGen voidGen;

    public PlayerJoinListener(VoidGen voidGen) {
        this.voidGen = voidGen;
        this.voidGen.getServer().getPluginManager().registerEvents(this, voidGen);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (UpdateUtils.isUpdateAvailable()) {
            if (player.isOp()) {
                this.voidGen.getFoliaLib().getScheduler().runAtEntityLater(player, () -> player.sendMessage(this.getUpdateMessage()), 3L, TimeUnit.SECONDS);
            }
        }
    }

    private String getUpdateMessage() {
        String updateMessage = String.format("&e%s &7v.%s is available here: &e%s&r", this.voidGen.getName(), UpdateUtils.getLatestRelease(), UpdateUtils.getLatestReleaseURL());
        return ChatColor.translateAlternateColorCodes('&', updateMessage);
    }

    public void terminate() {
        PlayerLoginEvent.getHandlerList().unregister(this.voidGen);
    }
}
