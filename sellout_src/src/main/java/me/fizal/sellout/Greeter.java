package me.fizal.sellout;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import org.bukkit.ChatColor;
import org.bukkit.Location;


public class Greeter implements Listener {

  JavaPlugin plugin;

  Greeter(JavaPlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void PlayerJoin(PlayerJoinEvent event) {
    String URI = "https://discordapp.com/api/webhooks/370022586182139904/OHVX9i5WZU5y6CTKFTJmh3uM5R4Y-n4SS5qFhK55ox5ONqA3MfnqTU5ORzvRyy7FyaFu";
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

    try {
      HttpResponse<String> response = Unirest.post(URI)
        .header("accept", "application/json")
        .field("content", message)
        .asString();
      this.plugin.getLogger().info(response.toString());
    } catch (Exception e) {
      this.plugin.getLogger().info("Error making API call.");
    }

    this.plugin.getLogger().info(message);

  }
}