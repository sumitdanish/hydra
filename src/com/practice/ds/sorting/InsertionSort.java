package com.practice.ds.sorting;

public class InsertionSort {

  public static void main(String[] args) {
    int[] a = {4, 3, 2, 10, 12, 1, 5, 6};
    insertion(a);
  }

  private static void insertion(int[] a) {
    int k = 0;
    for (int i = 1; i < a.length; i++) {
      int j = i - 1;
      int key = a[i];
      while (j >= 0 && a[j] > key) {
        a[j + 1] = a[j];
        j--;
      }
      a[++j] = key;
    }

    for (int i : a) {
      System.out.printf("%s, ", i);
    }
  }


}
