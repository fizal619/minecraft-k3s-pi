package me.fizal.repeller;

import java.util.ArrayList;
import java.util.HashSet;


public class BanItem {
  public ArrayList<Integer> coords = new ArrayList<Integer>();
  public HashSet<String> bans = new HashSet<String>();

  @Override
  public String toString() {
    return String.format("coords: %s, bans: %s", coords.toString(), bans.toString());
  }
}
