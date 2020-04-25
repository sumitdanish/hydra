package com.practice.ds.sorting;

public class SelectionSort {

  public static void main(String[] args) {
    int[] a = {64, 25, 12, 22, 11};
    selection(a);
  }

  private static void selection(int[] a) {
    int min = 0;
    for (int i = 0; i < a.length; i++) {
      min = i;
      for (int j = i + 1; j < a.length; j++) {
        if (a[min] > a[j]) {
          min = j;
        }
      }
      int temp = a[min];
      a[min] = a[i];
      a[i] = temp;
    }

    for (int i = 0; i < a.length; i++) {
      System.out.printf("%s,", a[i]);
    }
  }

}
