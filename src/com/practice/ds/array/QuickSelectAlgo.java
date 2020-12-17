package com.practice.ds.array;

public class QuickSelectAlgo {

  public static void main(String[] args) {
    int[] a = {7, 10, 4, 3, 20, 15};
    int kth = 1;
    System.out.println(quickSelect(0, a.length - 1, kth, a));
  }

  private static int pivot(int left, int right, int[] a) {
    int i = left;
    int j = 0;
    for (j = left; j <= right; j++) {
      if (a[j] < a[right]) {
        swap(i, j, a);
        i++;
      }
    }
    swap(i, right, a);
    return i;
  }

  private static int quickSelect(int left, int right, int kth, int[] a) {
    int pivot = pivot(left, right, a);
    if (left == right) {
      return a[left];
    }
    if (pivot + 1 == kth) {
      return a[pivot];
    }
    if (kth < pivot + 1) {
      return quickSelect(left, pivot - 1, kth, a);
    } else if (kth > pivot + 1) {
      return quickSelect(pivot + 1, right, kth, a);
    }
    return Integer.MAX_VALUE;
  }

  private static void swap(int i, int j, int[] a) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
