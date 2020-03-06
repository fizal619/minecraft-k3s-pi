package me.fizal.repeller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;

public class Banlist {

  public HashMap<String,BanItem> items;

  Banlist(){
    try {
      System.out.println("REPELLER ===> attempting to read config.yml");
      YamlReader reader = new YamlReader(
        new FileReader("plugins/RepellerPlugin/config.yml")
      );
      reader.getConfig().setClassTag(BanItem.class.getSimpleName(), BanItem.class);
      Object object = reader.read();
      System.out.println(object);
      items = (HashMap<String, BanItem>) object;
      // items = (List)object;
      // HashMap<String,BanItem> map = (HashMap)object;

    } catch (Exception e) {
      System.out.println("[ERROR REPELLER] Cannot read banlist or it's malformed.");
      e.printStackTrace();
      items = new HashMap<String,BanItem>();
    }
  }

  public void save() {
    try {
      YamlWriter writer = new YamlWriter(
        new FileWriter("plugins/RepellerPlugin/config.yml")
      );
      System.out.println(items);
      writer.write(items);
      writer.close();
    } catch (IOException e) {
      System.out.println("Error saving banlist :(");
      e.printStackTrace();
    }
  }

}
