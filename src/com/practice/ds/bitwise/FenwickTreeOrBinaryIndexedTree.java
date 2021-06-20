package com.practice.ds.bitwise;

public class FenwickTreeOrBinaryIndexedTree {

  /**
   * To get the parentIndex of currentIndex
   *  extractLastBitOfCurrentIndex = currentIndex & (-currentIndex)
   *  parentIndex = currentIndex - (extractLastBitOfCurrentIndex)
   *  e.g currentIndex = 13 => 0000 1101
   *  step 1. revert all binary of current index
   *  step 2. add 1 to get 1's complement to get -currentIndex
   *
   *  revert all bit , step 1. 13 => 1111 0010
   *  add 1          , step 2.    => 0000 0001
   *                                -----------
   *                    result    => 1111 0011
   *
   *  step 3. currentIndex & -currentIndex
   *  ***********************************************
   *                  currentIndex => 0000 1101
   *                 -currentIndex => 1111 0011
   *                 &             => 0000 0001 <= extractingLastBit
   *  ***********************************************
   *  step 4. currentIndex - (extractLastBitOfCurrentIndex) => 0000 1101
   *                                                => 0000 0001
   *                                                   ------------
   *                                                   0000 1100
   *  To get next node
   *  extractLastBitOfCurrentIndex = currentIndex & (-currentIndex)
   *  nextIndex = currentIndex + (extractLastBitOfCurrentIndex)
   *  currentIndex = 5 => 0000 0101
   *  revert all bit   => 1111 1010
   *  add 1            => 0000 0001
   *                      ----------
   *                      1111 1011
   *  step 3. currentIndex & -currentIndex
   *           currentIndex => 0000 0101
   *          -currentIndex => 1111 1011
   *          &             => 0000 0001 => extractLastBitOfCurrentIndex
   ****************   ****************   ****************   ****************
   * currentIndex + (extractLastBitOfCurrentIndex)
   *                     currentIndex =>  0000 0101
   *                     + or ^
   *    extractLastBitOfCurrentIndex  =>  0000 0001
   *                                      0000 0110
   *
   *
   * @param args
   */
  public static void main(String[] args) {
    String x = "AB|CD";
    System.out.println("C1".matches(x));
  }

}
