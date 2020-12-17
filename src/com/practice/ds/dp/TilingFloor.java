package com.practice.ds.dp;

public class TilingFloor {

  public static void main(String[] args) {
    int n = 10;
    int tiling = tiling1(n);
    System.out.println(tiling);
  }

  private static int tilingFloor(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n == 1 || n == 2 || n == 3) {
      return n;
    }
    return tilingFloor(n - 1) + tilingFloor(n - 2);
  }

  private static int tiling1(int n) {
    int[] ways = new int[n];
    ways[0] = 1;
    ways[1] = 2;
    ways[2] = 3;
    if (n <= 3) {
      return ways[n - 1];
    }
    for (int i = 3; i < n; i++) {
      ways[i] = ways[i - 1] + ways[i - 2];
    }
    return n > 0 ? ways[n-1] : 0;
  }

}
