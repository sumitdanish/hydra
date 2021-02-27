package com.practice.ds.array;


import java.util.HashSet;
import java.util.Set;

/**
 * Input: firstArr[] = {3, 5, 1, 8}, secondArr[] = {3, 3,5, 3, 8} Output: 3
 */
public class LCSBetweenTwoArray {

  static Set<Integer> set = new HashSet<>();
  public static void main(String[] args) {
    int[] a1 = {3, 3, 3, 8};
    int[] a2 = {3, 3, 3, 3, 8};
    System.out.println(lcs(a1,a2,a1.length,a2.length));
    set.stream().forEach(i -> System.out.println(i));
  }

  private static int lcs(int[] a1, int[] a2, int l1, int l2) {
    if (l1 <= 0 || l2 <= 0) {
      return 0;
    }
    if (a1[l1%a1.length] == a2[l2% a2.length] && !set.contains(a1[l1%a1.length])) {
      set.add(a1[l1%a1.length]);
      return 1 + lcs(a1, a2, l1 - 1, l2 - 1);
    }
    if (a1[l1 - 1] == a2[l2 - 1] && !set.contains(a1[l1 - 1])) {
      set.add(a1[l1-1]);
      return 1 + lcs(a1, a2, l1 - 1, l2 - 1);
    }

    return Math.max(lcs(a1, a2, l1, l2 - 1), lcs(a1, a2, l1 - 1, l2));

  }

  private static void lcs1(int[] a1,int[] a2){

  }

}
