package com.practice.ds.array;

public class SumOfOddLenArray {

  public static void main(String[] args) {
    int[] nums = {1, 4, 2, 5, 3};
    System.out.println(sum(nums));
  }

  private static int sum(int[] nums) {
    int val = 0;
    for (int i = 0; i < nums.length; i++) {
      double freq = Math.floor(((i + 1) * (nums.length - i) +1) / 2);
      val += nums[i] * (freq);
    }
    return val;
  }

  private static int sumOddLengthSubArrays(int[] arr) {

    int res = 0;
    for (int i = 1; i <= arr.length; i += 2) {    // For window sizes of Odd length
      int l = 0, curr = 0;
      for (int r = 0; r < arr.length; r++) {    // For traversal across a given window Size
        if (r - l == i)       // Window size equal to current maxSize
        {
          curr -= arr[l++];     // Shift Left pointer and subtract element that became out of window
        }
        curr += arr[r];      // Add new element to the right of the Window
        if (r - l == i - 1)          // If current Window size is equal to current max Size, add the current sum to res
        {
          res += curr;
        }
      }
    }
    return res;
  }

}
