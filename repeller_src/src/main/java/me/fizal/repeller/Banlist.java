package me.fizal.repeller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class Banlist {

  public HashMap<String, BanItem> items;

  Banlist() {
    try {
      System.out.println("REPELLER ===> attempting to read config.yml");
      YamlReader reader = new YamlReader(new FileReader("plugins/RepellerPlugin/config.yml"));
      reader.getConfig().setClassTag(BanItem.class.getSimpleName(), BanItem.class);
      Object object = reader.read();
      System.out.println(object);
      items = (HashMap<String, BanItem>) object;
      // items = (List)object;
      // HashMap<String,BanItem> map = (HashMap)object;

    } catch (Exception e) {
      System.out.println("[ERROR REPELLER] Cannot read banlist or it's malformed.");
      e.printStackTrace();
      items = new HashMap<String, BanItem>();
    }
  }

  public String savePlayerPosition(String name, JavaPlugin plugin) {
    BanItem entry;
    if (items.containsKey(name)) {
      entry = items.get(name);
      entry.coords = new ArrayList<Integer>();
    } else {
      entry = new BanItem();
    }

    Location xyz = plugin.getServer().getPlayer(name).getLocation();
    entry.coords.add(xyz.getBlockX());
    entry.coords.add(xyz.getBlockY());
    entry.coords.add(xyz.getBlockZ());
    items.put(name, entry);
    return "Saved your current location. Banned people will be repelled!";
  }

  public String toggleName(String name, String playerName) {
    BanItem entry;
    if (items.containsKey(name)) {
      entry = items.get(name);
    } else {
      entry = new BanItem();
      entry.bans = new HashSet<String>();
    }

    if (!entry.bans.contains(playerName)) {
      try {
        entry.bans.add(playerName);
      } catch (Exception e) {
        return "Your banlist might be full, please remove a name.";
      }
    } else {
      entry.bans.remove(playerName);
    }
    return "That idiot won't bother you no more.";
  }

  public void save() {
    try {
      YamlWriter writer = new YamlWriter(new FileWriter("plugins/RepellerPlugin/config.yml"));
      System.out.println(items);
      writer.write(items);
      writer.close();
    } catch (IOException e) {
      System.out.println("Error saving banlist :(");
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    String response = "";

    for (Entry item : items.entrySet()) {
      String key = (String)item.getKey();
      BanItem value = (BanItem)item.getValue();
      response = response.concat(
        String.format("\n -> %s: %s \n", key, value)
      );
    }

    return response;
  }

}
