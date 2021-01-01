package com.practice.ds.string;

public class KMP {

  public static void main(String[] args) {
    String pattern = "aabaabaaa";
    for (int i : lps(pattern)) {
      System.out.print(i + ",");
    }
  }

  private static int[] lps(String pattern) {
    int[] lps = new int[pattern.length()];
    int j = 1;
    int len = 0;
    for (int i = 0; i < pattern.length(); i++) {
      if (j >= pattern.length()) {
        break;
      } else if (pattern.charAt(i) == pattern.charAt(j)) {
        len++;
        lps[j] = len;
        j++;
      } else {
        if (i > 0) {
          len = lps[i - 1];
          i = lps[i - 1];
          i--;
        } else {
          i--;
          j++;
        }
      }
    }
    return lps;
  }

}
