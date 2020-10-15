package com.practice.ds.array;

public class MinimumRotationRequirdToUnlockKey {

  public static void main(String[] args) {
    System.out.println(minimumRotation(1919, 0000));
  }

  private static Integer minimumRotation(Integer key1, Integer key2) {
    int result = 0;
    if (key1 == key2) {
      return result;
    }
    while (key1 > 0 || key2 > 0) {
      int x1 = key1 % 10;
      int x2 = key2 % 10;
      result += min(Math.abs(x1 - x2), 10 - Math.abs(x1 - x2));
      key1 = key1 / 10;
      key2 = key2 / 10;
    }
    return result;
  }

  private static int min(int a, int b) {
    return a > b ? b : a;
  }

}
