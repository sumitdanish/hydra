package com.practice.ds.dp;

public class CoinChangeProblem {

  public static void main(String[] args) {
    int n = 4;
    int[] s = {1, 2, 3};

    int coin = coinChange(s, n, s.length);
    System.out.println(coin);
  }

  private static int coinChange(int[] s, int n, int i) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }
    if (i <= 0 && n >= 1) {
      return 0;
    }
    /*
    return 1 + coinChange(s, n - s[i], i);

    if i am doing this way then i am summing up solution for each
    subtraction which is wrong, actually summing up one more element
    which is equivalent to givn number should be consider as one
    */

    return coinChange(s, n - s[i-1], i) + coinChange(s, n, i - 1);
  }

}
