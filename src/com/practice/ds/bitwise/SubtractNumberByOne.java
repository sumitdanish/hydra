package com.practice.ds.bitwise;

public class SubtractNumberByOne {

  public static void main(String[] args) {
    //System.out.println(subtract(4));
    //System.out.println(Math.ceil((7/2)));
    System.out.println(5 >> 2);
  }

  private static int subtract(int num) {
    int m = 1;
    while (!((num & m) > 0)) {
      num ^= m;
      m <<= 1;
    }
    num ^= m;
    return num;
  }

}
