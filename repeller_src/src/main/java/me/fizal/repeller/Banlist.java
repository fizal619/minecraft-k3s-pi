package me.fizal.repeller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;

public class Banlist {

  Map<String,BanItem> items;

  Banlist(){
    try {
      YamlReader reader = new YamlReader(
        new FileReader("plugins/RepellerPlugin/config.yml")
      );
      Object object = reader.read();
      System.out.println(object);
      // items = (List)object;

    } catch (Exception e) {
      System.out.println("[ERROR REPELLER] Cannot read banlist or it's malformed.");
      items = new HashMap<String,BanItem>();
    }
  }

  public void save() {
    try {
      YamlWriter writer = new YamlWriter(
        new FileWriter("plugins/RepellerPlugin/config.yml")
      );
      writer.write(items);
      writer.close();
    } catch (IOException e) {
      System.out.println("Error saving banlist :(");
      System.out.println(e.getMessage());
    }
  }

}
