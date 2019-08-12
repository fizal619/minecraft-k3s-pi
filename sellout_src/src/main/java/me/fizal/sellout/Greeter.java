package me.fizal.sellout;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;


public class Greeter implements Listener {

  JavaPlugin plugin;

  NotifyDiscord notifyDiscord = new NotifyDiscord();

  Greeter(JavaPlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void PlayerJoin(PlayerJoinEvent event) {
    Player person =  event.getPlayer();
    Location loc = person.getLocation();
    String displayName = person.getDisplayName();

    person.sendMessage(ChatColor.AQUA + "Welcome to PiCraft. Please expect this server to lag sometimes.");

    String message = String.format("@here %s logged in at x: %s, y: %s, z: %s.",
      displayName,
      loc.getBlockX(),
      loc.getBlockY(),
      loc.getBlockZ()
    );
    person.sendMessage(ChatColor.RED + message);

    notifyDiscord.call(message);

    this.plugin.getLogger().info(message);

  }
}