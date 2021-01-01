package com.practice.ds.array.rotation;

public class SearchInSortedAndRotatedArray {

  public static void main(String[] args) {
    int[] a = {3,4,5,1,2};
    System.out.println(findPivot(a, 0, a.length - 1));
  }

  private static int numberInSortedAndRotatedArray(int[] a, int l, int r, int key) {
    if (a[l] == key) {
      return l;
    }
    if (a[r] == key) {
      return r;
    }

    if (l >= r) {
      return -1;
    }

    int mid = l + (r - l) / 2;

    if (a[mid] == key) {
      return mid;
    }

    if (mid + 1 <= r && a[mid + 1] == key) {
      return mid + 1;
    }

    if (mid - 1 >= l && a[mid - 1] == key) {
      return mid - 1;
    }

    if (a[mid] > a[l]) {
      if (key > a[l] && key < a[mid]) {
        return numberInSortedAndRotatedArray(a, l, mid - 1, key);
      }
      return numberInSortedAndRotatedArray(a, mid + 1, r, key);
    }
    if (key > a[mid] && key < a[r]) {
      return numberInSortedAndRotatedArray(a, mid + 1, r, key);
    }
    return numberInSortedAndRotatedArray(a, l, mid - 1, key);
  }

  static int findPivot(int[] a,int l,int r){
    if(l > r){
      return -1;
    }
    if(l == r){
      return l;
    }
    int mid = l+(r-l)/2;

    if(mid+1 < r && a[mid] > a[mid+1]){
      return mid;
    }

    if(mid-1 > l && a[mid] < a[mid-1]){
      return mid-1;
    }

    if(a[mid] > a[l]){
      return findPivot(a,mid+1,r);
    }
    return findPivot(a,l,mid-1);
  }
}
