package com.practice.ds.array;

public class FindKthMissingNumber {

  public static void main(String[] args) {

  }

  private static int kthMissing(int[] arr, int k) {
    int missing = 0;
    int kth = 0;
    int i = 0;
    int temp = 0;
    for (; i < arr.length; i++) {
      temp = missing;
      kth += arr[i] - missing - 1;
      missing = arr[i];
      if (kth >= k) {
        return kth - k + temp;
      }
    }

    return k - kth + arr[arr.length - 1];
  }

}
