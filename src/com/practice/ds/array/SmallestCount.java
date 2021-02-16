package com.practice.ds.array;

import com.sun.tools.javac.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SmallestCount {

  public static void main(String[] args) {
    int[] a = {8, 1, 2, 2, 3};
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    q.add(2);
    q.add(3);
    for(int i=0;i<q.size();i++){
q.peek();
    }

    // 1,2,2,3,8list.add(1);
    /*int[] a1 = smallerNumbersThanCurrent(a);
    for (int i : a1) {
      System.out.print(i + ",");
    }*/

  }

  public static int[] smallerNumbersThanCurrent(int[] nums) {
    int[] count = new int[nums.length];
    int[] o = nums.clone();
    quickSort(nums, 0, nums.length - 1);
    int p = 0;
    for (int i = 0; i < o.length; i++) {
      int c = binary(nums, 0, nums.length - 1-i, o[i]);
      if (c != -1) {
        count[i] = c;
      }
    }
    return count;
  }


  private static int binary(int[] a, int left, int right, int key) {
    if (left > right) {
      return -1;
    }

    int mid = (left + right) / 2;
    if (a[mid] == key) {
      return mid;
    }
    if (a[mid] > key) {
      return binary(a, left, mid - 1, key);
    }
    return binary(a, mid + 1, right, key);
  }

  private static void quickSort(int[] a, int l, int r) {
    if (l >= r) {
      return;
    }

    int p = pivot(a, l, r);
    quickSort(a, l, p - 1);
    quickSort(a, p + 1, r);
  }

  private static int pivot(int[] a, int left, int right) {
    int p = a[right];
    int l = left;
    int l1 = left;
    for (; l1 < right; l1++) {
      if (p > a[l1]) {
        int temp = a[l1];
        a[l1] = a[l];
        a[l] = temp;
        l++;
      }
    }

    int temp = a[right];
    a[right] = a[l];
    a[l] = temp;
    return l;
  }

}
