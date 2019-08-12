package me.fizal.sellout;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

class NotifyDiscord {

  String URI = "";

  NotifyDiscord() {
    String dir = "plugins/SelloutPlugin";
    File directory = new File(dir);
    if (directory.exists()) {
      System.out.println("Config directory already exists ...");

    } else {
      System.out.println("Config directory not exists, creating now");

      boolean success = directory.mkdir();
      if (success) {
        System.out.printf("Successfully created new directory : %s%n", dir);
      } else {
        System.out.printf("Failed to create new directory: %s%n", dir);
      }
    }
    readWebhook();
  }

  private void readWebhook() {
    try {
      YamlReader reader = new YamlReader(new FileReader("plugins/SelloutPlugin/config.yml"));
      Object object;
      object = reader.read();
      System.out.println(object);
      Map map = (Map)object;

      this.URI = map.get("URI").toString();

    } catch (Exception e) {
      System.out.println("[ERROR] Cannot read config.yml or it's malformed.");
    }
  }

  public void saveWebhook (String webhookURI) {
    try {
      YamlWriter writer = new YamlWriter(new FileWriter("plugins/SelloutPlugin/config.yml"));
      Map<String,String> webhook = new HashMap<String, String>();
      webhook.put("URI", webhookURI);
      writer.write(webhook);
      writer.close();
      this.URI = webhookURI;
    } catch (Exception e) {
      System.out.println("[ERROR] Cannot write config.yml <shrug emoji>");
	  }
  }

  public void call(String message) {
    try {
      HttpResponse<String> response = Unirest.post(URI)
        .header("accept", "application/json")
        .field("content", message)
        .asString();

    } catch (Exception e) {
      System.out.println("Couldn't make api req");
    }
  }

}