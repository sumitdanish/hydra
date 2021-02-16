package com.practice.ds.array;

public class FirstAndLastIndex {

  public static void main(String[] args) {
    int[] a = {5, 7, 7, 8, 9, 10};
    int target = 5;
    int i1 = getIndex(a, 0, a.length, target);
    if (i1 == -1) {
      System.out.println("No target");
    } else if (i1 - 1 >= 0 && i1 + 1 <= a.length - 1 && a[i1 - 1] != a[i1] && a[i1 + 1] != a[i1]) {
      System.out.println(i1 + " : " + i1);
    } else {
      if (i1 + 1 <= a.length - 1 && a[i1 + 1] > target) {
        System.out.println(getIndex(a, 0, i1 - 1, 8) + " " + i1);
      } else {
        System.out.println(i1 + " <> " + getIndex(a, i1 + 1, a.length, 8));
      }
    }
  }

  private static int getIndex(int[] a, int l, int r, int target) {
    if ((l > r) || (l >= a.length || r >= a.length)) {
      return -1;
    }
    if ((a[l] == target || a[r] == target)) {
      return l;
    }
    int mid = (r + l) / 2;
    if (a[mid] == target) {
      if (mid - 1 >= 0 && a[mid - 1] < target) {
        return mid;
      }
      if (mid + 1 <= r && a[mid + 1] > target) {
        return mid;
      }
    }
    if (target < a[mid]) {
      return getIndex(a, l, mid - 1, target);
    }
    return getIndex(a, mid + 1, r, target);
  }


}
