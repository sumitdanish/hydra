package com.practice.ds.array;

public class OneStringFromAnotherStringByXRotation {

  public static void main(String[] args) {
    String str1 = "you";
    String str2 = "ara";
    System.out.println(isPossibleRotation(str1, str2, 6));
  }

  private static boolean isPossibleRotation(String str1, String str2, int x) {
    if (str1.length() != str2.length()) {
      return false;
    }
    for (int i = 0; i < str1.length(); i++) {
      int diff = (str2.charAt(i) - str1.charAt(i)) + 26;
      int result = diff % 26;
      if (result > x) {
        return false;
      }
    }
    return true;
  }


}
