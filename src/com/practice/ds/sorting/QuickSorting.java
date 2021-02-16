package com.practice.ds.sorting;

import java.util.Arrays;
import java.util.HashMap;

public class QuickSorting {

  public static void main(String[] args) {
    int[] a = {1,2,3,1,1,3};
    quickSort(a, 0, a.length - 1);
    for (int a1 : a) {
      System.out.print(a1 + ",");
    }

  }

  private static void quickSort(int[] a,int l,int r){
    if(l >=r){
      return;
    }

    int p = pivot(a,l,r);
    quickSort(a,l,p-1);
    quickSort(a,p+1,r);
  }

  private static int pivot(int[] a,int left,int right){
    int p =a[right];
    int l = left;
    int l1 = left;
    for(;l1<right;l1++){
      if(p > a[l1]){
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
