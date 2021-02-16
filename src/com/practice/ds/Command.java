package com.practice.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Command {

  public static void main(String[] args) {
    String[] s = {"order amount|ordered amount", "item summary|order summary"};
    String command = "can you tel me the ordered amount";
    String[] c = command.split("\\s+");
    Set<String> set = new HashSet<>();
    for (String c1 : c) {
      set.add(c1);
    }
    Map<String, List<String>> map = new HashMap<>();
    String s2 = extracted(s, set);
    System.out.println(s2);

  }

  private static String extracted(String[] commands, Set<String> set) {
    for (String command : commands) {
      String[] splitCommandWithPipe = command.split("\\|");
      for (String commandWithSpace : splitCommandWithPipe) {
        String[] singleSpacesWordsFormCommand = commandWithSpace.split("\\s+");
        int count=0;
        for (String word : singleSpacesWordsFormCommand) {
            if(set.contains(word)){
              count++;
            }
            if (count == singleSpacesWordsFormCommand.length){
             return commandWithSpace;
            }
        }
      }
    }
    return "UNKNOWN";
  }


}
