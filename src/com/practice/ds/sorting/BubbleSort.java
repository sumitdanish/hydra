package com.practice.ds.sorting;

public class BubbleSort {

  public static void main(String[] args) {
    int[] a = {5, 1, 4, 2, 8};
    bubbleSort(a);
  }

  private static void bubbleSort(int[] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = i; j + 1 < a.length; j++) {
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
        }
      }
    }

    for (int i :a) {
      System.out.printf("%s,",i);
    }
  }

}
