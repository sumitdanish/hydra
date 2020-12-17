package com.practice.ds.array;

public class FindMthAfterKthRotation {

  public static void main(String[] args) {
    int[] a = {3, 4, 5, 23};
    int k = 28;
    int m = 3;
    System.out.println(result(a, k, m));
    //System.out.println(2 / 3);
  }

  private static int result(int[] a, int k, int m) {
    if (k + m < a.length) {
      return a[k + m - 1];
    }
    return a[(k % a.length) + m - 1];
  }

}
