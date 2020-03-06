package me.fizal.repeller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

  private Banlist banlist = new Banlist();

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(cmd.getName().equalsIgnoreCase("save")) {



    }
    return true;
  }

  @Override
  public void onEnable() {
    this.getLogger().info("Repeller Plugin activated. Tresspassers will be teleported!");

  }
}