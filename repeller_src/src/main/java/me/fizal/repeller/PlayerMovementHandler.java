package me.fizal.repeller;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerMovementHandler implements Listener {

  Banlist banlist;
  JavaPlugin plugin;

  PlayerMovementHandler(JavaPlugin plugin){
    this.plugin = plugin;
    banlist = Banlist.getInstance();
  }

  @EventHandler
  public void PlayerMove(PlayerMoveEvent event) {
    Location nextLoc = event.getTo();
    Location lastLoc = event.getFrom();
    Player player = event.getPlayer();
    World zaWarudo = player.getWorld();
    double border = 100;

    ArrayList<BanItem> coordsBannedFrom = banlist.check(player.getName());

    if (coordsBannedFrom.size() == 0) {
      return;
    }


    for (BanItem banItem : coordsBannedFrom) {
      Location coords = new Location(
        zaWarudo,
        Double.parseDouble(banItem.coords.get(0)),
        Double.parseDouble(banItem.coords.get(1)),
        Double.parseDouble(banItem.coords.get(2))
      );
      try {
        double distance = coords.distanceSquared(nextLoc);
        if (distance <= border) {
          player.teleport(lastLoc);
        }
        plugin.getServer().broadcastMessage(Double.toString(distance));
      } catch (Exception e) {
        plugin.getLogger().warning("Could not calculate distance.");
      }
    }


  }
}