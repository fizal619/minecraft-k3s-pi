package me.fizal.repeller;

import java.util.ArrayList;


public class BanItem {
  public ArrayList<Integer> coords = new ArrayList<Integer>();
  public ArrayList<String> bans = new ArrayList<String>();

  @Override
  public String toString() {
    return String.format("coords: %s, bans: %s", this.coords.toString(), bans.toString());
  }
}
