package me.fizal.repeller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

  public Banlist banlist = new Banlist();

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    if(cmd.getName().equalsIgnoreCase("save")) {
      String message = banlist.savePlayerPosition(sender.getName(), this);
      sender.sendMessage(message);
    }

    if (cmd.getName().equalsIgnoreCase("toggle")) {
      String message = banlist.toggleName(sender.getName(), args[0]);
      sender.sendMessage(message);
    }

    if (cmd.getName().equalsIgnoreCase("list")) {
      sender.sendMessage(banlist.toString());
    }

    return true;
  }

  /**
   * @return the banlist
   */
  public Banlist getBanlist() {
    return banlist;
  }

  @Override
  public void onEnable() {
    this.getLogger().info("Repeller Plugin activated. Tresspassers will be teleported!");
    this.getLogger().info(banlist.toString());
    getServer().getPluginManager().registerEvents(new PlayerMovementHandler(this), this);
  }

  @Override
  public void onDisable() {
    this.getLogger().info("Attempting to save banlist to disk");
    banlist.save();
  }

}