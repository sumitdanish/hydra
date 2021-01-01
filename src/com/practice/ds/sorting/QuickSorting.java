package com.practice.ds.sorting;

import java.util.Arrays;
import java.util.HashMap;

public class QuickSorting {

  public static void main(String[] args) {
    int[] a = {1,2,3,1,1,3};
    quickSort(a, 0, a.length - 1);
    for (int a1 : a) {
      System.out.print(a1 + ",");
    }

  }

  private static void quickSort(int[] a, int l, int r) {
    if (l < r) {
      int p = pivot(a, l, r);
      quickSort(a, l, p - 1);
      quickSort(a, p + 1, r);
    }
  }

  private static int pivot(int[] a, int l, int r) {
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
