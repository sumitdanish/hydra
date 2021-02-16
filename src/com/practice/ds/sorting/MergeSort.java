package com.practice.ds.sorting;

public class MergeSort {

  public static void main(String[] args) {
    int[] a = {9, 7, 8, 3, 2, 1};
    mergeSort(a, 0, a.length - 1);
    for (int i : a) {
      System.out.print(i + ",");
    }
  }

  private static void mergeSort(int[] a, int start, int end) {
    if (start >= end) {
      return;
    }
    int mid = (start + end) / 2;
    mergeSort(a, start, mid);
    mergeSort(a, mid + 1, end);
    mergeSort(a, start, mid, end);
  }

  private static void mergeSort(int[] a, int start, int mid, int end) {
    int p = start;
    int q = mid + 1;
    int k = 0;
    int[] a1 = new int[end - start + 1];
    for (int i = start; i <= end; i++) {
      if (p > mid) {
        a1[k++] = a[q++];
      } else if (q > end) {
        a1[k++] = a[p++];
      } else if (a[p] > a[q]) {
        a1[k++] = a[q++];
      } else {
        a1[k++] = a[p++];
      }
    }

    for (int i = 0; i < k; i++) {
      a[start++] = a1[i];
    }
  }

}
