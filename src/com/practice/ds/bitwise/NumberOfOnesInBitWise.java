package com.practice.ds.bitwise;

public class NumberOfOnesInBitWise {

  public static void main(String[] args) {
    int x = 9;
    System.out.println((x & (x - 1)));
  }

}
