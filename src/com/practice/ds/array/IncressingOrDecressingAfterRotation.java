package com.practice.ds.array;

/*
https://www.geeksforgeeks.org/check-if-it-is-possible-to-make-array-increasing-or-decreasing-by-rotating-the-array/
 */
public class IncressingOrDecressingAfterRotation {

  public static void main(String[] args) {
    int[] a = {6,5,4,3,2,7};
    int pivot = findPivot(a, 0, a.length - 1);

    System.out.println(pivot);
    if (pivot == -1) {
      System.out.println("Nops");
    } else {
      int i = 0;
      int j = pivot + 1;
      boolean incFlag = false;
      boolean descFlag = false;
      Integer max1 = Integer.MIN_VALUE;
      Integer max2 = Integer.MIN_VALUE;

      while (i < pivot || j < a.length) {
        if (max1 < a[i]) {
          max1 = a[i];
        }
        if (max2 < a[j]) {
          max2 = a[j];
        }
        if (max2 > max1 && max1 < a[pivot] && max2 < a[pivot]) {
          incFlag = true;
        } else{
          descFlag = true;
        }
        i++;
        j++;
      }
      if (incFlag && descFlag) {
        System.out.println("Not possible");
      } else {
        if (incFlag) {
          System.out.println("Increasing");
        } else {
          System.out.println("Decreasing");
        }
      }
    }
  }

  private static boolean checkIfAnyOtherPivot(int[] a, int pivot) {
    int p = findPivot(a, pivot, a.length-1);
    System.out.println("P " + p);
    return false;
  }

  private static int findPivot(int[] a, int l, int r) {
    if (l > r) {
      return -1;
    }
    if (l == r) {
      return l;
    }
    int mid = (l + r) / 2;

    if (mid < r && a[mid] > a[mid + 1]) {
      return mid;
    }
    if (mid > l && a[mid - 1] > a[mid]) {
      return mid - 1;
    }
    if (a[mid] > a[l]) {
      return findPivot(a, mid + 1, r);
    }
    return findPivot(a, l, mid - 1);
  }

}
