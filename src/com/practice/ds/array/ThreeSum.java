package com.practice.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ThreeSum {

  public static void main(String[] args) {
    int[] a = {1, -1, -1, 0};
    List<List<Integer>> c = calculate(a);
    System.out.println(c);
  }

  private static List<List<Integer>> calculate(int[] list) {
    if (list.length == 0 || list.length < 3) {
      return Collections.EMPTY_LIST;
    }
    quickSort(list, 0, list.length - 1);
    List<List<Integer>> l = threeSum(list);
    for (List<Integer> l1 : l) {
      for (Integer i : l1) {
        System.out.print(i + ",");
      }
      System.out.println();
    }
    return l;
  }

  static List<List<Integer>> threeSum(int[] a) {
    List<List<Integer>> threeSumList = new ArrayList<>();
    Set<String> set = new HashSet<>();
    int i = 0;
    while (i < a.length) {
      List<Integer> l = new ArrayList<>();
      boolean[] visited = new boolean[a.length];
      int j = i + 1;
      int r = a.length - 1;
      String s="";
      while (i < j && j < r && r < a.length) {
        int threeSum = a[i] + a[j] + a[r];
        if (threeSum > 0) {
          r--;
        } else if (threeSum < 0) {
          j++;
        } else {
          if (!visited[i] && !visited[j] && !visited[r]) {
            if(!set.contains(String.valueOf(a[i])+String.valueOf(a[j])+String.valueOf(a[r]))) {
              l.add(a[i]);
              l.add(a[j]);
              l.add(a[r]);
              set.add(String.valueOf(a[i])+String.valueOf(a[j])+String.valueOf(a[r]));
              visited[i] = true;
              visited[j] = true;
              visited[r] = true;
            }
          }
          j++;
          r--;
        }
      }
      i++;
      if (!l.isEmpty()) {
        threeSumList.add(l);
      }
    }

    return threeSumList;
  }

  private static void quickSort(int[] a, int l, int r) {
    if (l >= r) {
      return;
    }
    int p = findPivot(a, l, r);
    quickSort(a, l, p - 1);
    quickSort(a, p + 1, r);
  }

  private static int findPivot(int[] a, int l, int r) {
    int p = a[r];
    int i = l;
    int j = l;
    for (; j < r; j++) {
      if (p > a[j]) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        i++;
      }
    }
    int t = a[i];
    a[i] = a[r];
    a[r] = t;
    return i;
  }
}
