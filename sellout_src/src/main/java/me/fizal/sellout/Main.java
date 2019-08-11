package me.fizal.sellout;

import org.bukkit.plugin.java.JavaPlugin;
import me.fizal.sellout.Greeter;

public class Main extends JavaPlugin {

  @Override
  public void onEnable() {
    getLogger().info("Hello, SpigotMC!");
    getServer().getPluginManager().registerEvents(new Greeter(this), this);
  }
  @Override
  public void onDisable() {
    getLogger().info("See you again, SpigotMC!");
  }
}