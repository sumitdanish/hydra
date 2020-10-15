package com.practice.ds.array.rotation;

public class QuickFindOfRotation {

  public static void main(String[] args) {
    int[] a = {1, 3, 5, 7, 9};
    quickRotate(a, 0);
  }

  private static void quickRotate(int[] a, int k) {
    int start = k % a.length;
    for (int iStart = start; iStart < a.length + start; iStart++) {
      System.out.print(a[iStart % a.length]+" ");
    }
  }
}
