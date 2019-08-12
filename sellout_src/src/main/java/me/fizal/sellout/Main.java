package me.fizal.sellout;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import me.fizal.sellout.Greeter;

public class Main extends JavaPlugin {

  NotifyDiscord notifyDiscord = new NotifyDiscord();

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(cmd.getName().equalsIgnoreCase("so")) {
      notifyDiscord.saveWebhook(args[0]);
      return true;
    }
    return true;
  }

  @Override
  public void onEnable() {
    notifyDiscord.call("Server online ✨");
    getServer().getPluginManager().registerEvents(new Greeter(this), this);
  }

  @Override
  public void onDisable() {
    notifyDiscord.call("Server shut down gracefully ☠");
  }
}