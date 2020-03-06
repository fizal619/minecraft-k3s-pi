package me.fizal.repeller;

import java.util.ArrayList;

public class BanItem {
  String player;
  String location;
  ArrayList<String> bans;

  BanItem(String playerName, String locationCoords, ArrayList<String> banList){
    location = locationCoords;
    bans = banList;
  }

}
