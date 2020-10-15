package com.practice.ds.array;

public class RotationOfNumber {

  public static void main(String[] args) {
    rotation(1445);
  }

  private static void rotation(int n) {
    int len = count(n);
    int i = 0;
    while (len > 1) {
      int re = (int) (n / Math.pow(10, len - 1));
      int x = (int) (n % Math.pow(10, len - 1));
      int y = (int) (x * Math.pow(10, i + 1));
      int r = y + re;
      System.out.println(r);
      len--;
      i++;
    }
  }

  private static int count(int n) {
    int count = 0;
    while (n > 0) {
      count++;
      n = n / 10;
    }
    return count;
  }
}
