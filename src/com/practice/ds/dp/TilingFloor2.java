package com.practice.ds.dp;

public class TilingFloor2 {

  public static void main(String[] args) {
    int n = 10;
    int m = 5;
    int ways = tilling2(n, m);
    System.out.println(ways);
  }

  private static int tiling(int n, int m) {
    if (n <= 0 || m <= 0) {
      return 0;
    }

    if (m > n) {
      return 1;
    }
    if (n - m == 0) {
      return 2;
    }
    return tiling(n - 1, m) + tiling(n - m, m);
  }

  private static int tilling2(int n, int m) {
    int[] count = new int[n+1];
    if (n <= 0 || m <= 0) {
      return 0;
    }
    count[0] = 0;
    for (int i = 1; i <= n; i++) {
      if (i < m) {
        count[i] = 1;
      } else if (i - m == 0) {
        count[i] = 2;
      } else {
        count[i] = count[i - 1] + count[i - m];
      }
    }
    return count[n];
  }

}
