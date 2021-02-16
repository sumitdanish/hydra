package com.practice.ds.sorting;

public class CountSort {

  public static void main(String[] args) {
    /*int[] a = {1, 4, 1, 2, 7, 5, 2};
    for (int a1 : count(a)) {
      System.out.print(a1 + ",");
    }*/
    int[] a = {-5, -10, 0, -3, 8, 5, -1, 10};
    for (int a1 : countNegative(a)) {
      System.out.print(a1 + ",");
    }
  }

  private static int[] count(int[] a) {
    int[] out = new int[a.length];
    /**
     * Assuming the array contains the element in range from 0-9
     * in case of string it has to 52 max;
     */
    int[] count = new int[10];

    for (int i = 0; i < a.length; i++) {
      count[a[i]]++;
    }
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }
    for (int i = 0; i < a.length; i++) {
      out[count[a[i]] - 1] = a[i];
      --count[a[i]];
    }
    return out;
  }

  private static int[] countNegative(int[] a) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < a.length; i++) {
      if (max < a[i]) {
        max = a[i];
      }
      if (min > a[i]) {
        min = a[i];
      }
    }
    int range = max - min + 1;
    int[] count = new int[range];
    int[] out = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      count[a[i] - min]++;
    }
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }
    for (int i = 0; i < a.length; i++) {
      out[count[a[i] - min] - 1] = a[i];
      --count[a[i] - min];
    }
    return out;
  }

}
