package com.practice.ds.array;

import java.util.HashMap;
import java.util.Map;

/*https://www.geeksforgeeks.org/maximize-count-of-corresponding-same-elements-in-given-arrays-by-rotation/*/
public class MaximumCountOfSameArrayAfterRotation {

  public static void main(String[] args) {
    int[] a1 = {6, 7, 3, 9, 5};
    int[] a2 = {7, 3, 9, 5, 6};
    //maxCountOfSameElement(a1, a2);
    //System.out.println(57897%4);
  }

  private static void maxCountOfSameElement(int[] a1, int[] a2) {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> map1 = new HashMap<>();
    for (int i = 0; i < a2.length; i++) {
      map.put(a2[i], i + 1);
    }
    for (int i = 0; i < a1.length; i++) {
      int dif = Math.abs(map.get(a1[i]) - i + 1);
      int count = 1;
      if (map.get(a1[i]) < i + 1) {
        dif = dif - a1.length;
      }
      if (map1.containsKey(dif)) {
        count++;
      }
      map1.put(dif, count);
    }

    map1.entrySet().stream().forEach(ent -> {
      System.out.println(ent.getKey() + " : " + ent.getValue());
    });
  }
}
