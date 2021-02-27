package com.practice.ds.genralAlgo;

import java.util.Map;
import java.util.Random;

/**
 * RollinHash Steps: 1. Calculate the hash of pattern 2. Take substring of length equivalent to pattern length, from
 * given input string, say s 3. calculate the hash of s 4. if hash of s is matched with hash of pattern 5. then check
 * each character with s to each character with pattern 6. if match return true else go move one pointer ahead and do
 * 2-6
 */
public class RollingHash {

  public static void main(String[] args) {
    String s = "baa";
    String p = "baa";
    // System.out.println(isSubStringExist(s, p));
   // System.out.println(rollingHash("BAABAAB", "AAB"));
    System.out.println(2%2);

  }

  private static boolean isSubStringExist(String str, String pattern) {
    if (str.length() <= 0 && pattern.length() <= 0) {
      return true;
    }
    if (str.length() <= 0 || pattern.length() <= 0) {
      return false;
    }
    int pH = 0;
    for (int i = 0; i < pattern.length(); i++) {
      pH += pattern.charAt(i) - 'a' + 1;
    }
    int sPH = 0;
    int i1 = 0;
    for (i1 = 0; i1 < pattern.length(); i1++) {
      sPH += str.charAt(i1) - 'a' + 1;
    }
    if (sPH == pH && pattern.equals(str.substring(0, pattern.length()))) {
      return true;
    }
    for (int i = pattern.length(); i < str.length(); i++) {

      sPH += str.charAt(i) - 'a' + 1 - (str.charAt(i - pattern.length()) - 'a' + 1);
      if (i - pattern.length() + 1 < str.length() && sPH == pH && str
          .substring(i - pattern.length() + 1, i + 1).equals(pattern)) {
        return true;
      }
    }
    return false;
  }

  private static boolean rollingHash(String str, String pattern) {
    int p = 5381;
    int ph = 0;
    for (int i = pattern.length() - 1; i >= 0; i--) {
      ph += (((pattern.charAt(i) - 'A' + 1) * Math.pow(26, pattern.length()-1-i)) % Math.pow(p, pattern.length()-i));
    }
    int sH = 0;
    for (int i = pattern.length() - 1; i >= 0; i--) {
      sH += (((str.charAt(i) - 'A' + 1) * Math.pow(26, pattern.length()-1-i)) % Math.pow(p, pattern.length()-i));
    }

    if (sH == ph && pattern.equals(str.substring(0, pattern.length()))) {
      return true;
    }
    int win = pattern.length();
    for (int i = pattern.length(); i < str.length(); i++) {
      if (win < 0) {
        win = pattern.length();
      }
      sH += (((str.charAt(i) - 'A' + 1) * Math.pow(26, pattern.length() - win -1)) % Math.pow(p,  pattern.length() - win)) - (
          ((str.charAt(i - pattern.length()) - 'A' + 1) * Math.pow(26, win-1)) % Math.pow(p, win));
      win--;
      if (i + 1 < str.length() && i - pattern.length() + 1 < str.length() && sH == ph && str
          .substring(i - pattern.length() + 1, i + 1).equals(pattern)) {
        return true;
      }
    }

    System.out.println(sH);
    return false;
  }
}
