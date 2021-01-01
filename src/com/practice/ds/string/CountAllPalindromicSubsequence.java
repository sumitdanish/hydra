package com.practice.ds.string;

public class CountAllPalindromicSubsequence {

  public static void main(String[] args) {
    String str = "aab";
    //System.out.println(count(str, 0, str.length() - 1));
    count1(str);
  }

  private static int count(String str, int l, int r) {

    if (l > r) {
      return 0;
    }
    if (l == r) {
      return 1;
    }
    if (str.charAt(l) == str.charAt(r)) {
      return 1 + count(str, l + 1, r) + count(str, l, r - 1);
    }
    return count(str, l + 1, r) + count(str, l, r - 1) - count(str, l + 1, r - 1);
  }

  private static void count1(String str) {
    int[][] count = new int[str.length() + 1][str.length() + 1];
    for (int i = 0; i < str.length(); i++) {
      count[i][i] = 1;
    }
    for (int i = 2; i <= str.length(); i++) {
      for (int j = 0; j < str.length(); j++) {
        int k = j + i - 1;
        if (k < str.length()) {
          if (str.charAt(j) == str.charAt(k)) {
            count[j][k] = 1 + count[j][k - 1] + count[j + 1][k];
          } else {
            count[j][k] = count[j][k - 1] + count[j + 1][k] - count[j + 1][k - 1];
          }
        }
      }
    }
    System.out.println(count[0][str.length()-1]);
  }
}