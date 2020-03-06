package me.fizal.repeller;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

  private Banlist banlist = new Banlist();

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    if(cmd.getName().equalsIgnoreCase("save")) {
      BanItem entry;
      if (banlist.items.containsKey(sender.getName())) {
        entry = banlist.items.get(sender.getName());
        entry.coords = new ArrayList<Integer>();
      } else {
        entry = new BanItem();
      }

      Location xyz = this.getServer()
        .getPlayer(sender.getName())
        .getLocation();
      entry.coords.add(xyz.getBlockX());
      entry.coords.add(xyz.getBlockY());
      entry.coords.add(xyz.getBlockZ());
      banlist.items.put(sender.getName(), entry);
      banlist.save();

    }
    return true;
  }

  @Override
  public void onEnable() {
    this.getLogger().info("Repeller Plugin activated. Tresspassers will be teleported!");

  }
}