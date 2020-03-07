package me.fizal.repeller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

  private Banlist banlist = new Banlist();

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

    return true;
  }

  @Override
  public void onEnable() {
    this.getLogger().info("Repeller Plugin activated. Tresspassers will be teleported!");
    this.getLogger().info(banlist.toString());
  }

  @Override
  public void onDisable() {
    this.getLogger().info("Attempting to save banlist to disk");
    banlist.save();
  }

}