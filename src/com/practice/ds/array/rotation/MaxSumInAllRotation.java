package com.practice.ds.array.rotation;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumInAllRotation {

  public static void main(String[] args) {
    int[] a = {1, 20, 2, 10};
    Boolean[] b = new Boolean[3];
    System.out.println(new ArrayList<>(4).size());
    System.out.println(maxSum(a));
  }

  private static int maxSum(int[] a) {
    int currentSum = 0;
    for (int index = 0; index < a.length; index++) {
      currentSum += a[index];
    }

    int currentSum1 = 0;
    for (int index = 0; index < a.length; index++) {
      currentSum1 += index * a[index];
    }

    int maxSum = Integer.MIN_VALUE;

    for (int index = 1; index < a.length; index++) {
      int nextValue = currentSum1 - (currentSum - a[index - 1]) + (a[index - 1] *(a.length - 1));
      currentSum1 = nextValue;
      maxSum = Math.max(maxSum, nextValue);
    }

    return maxSum;
  }

  private static void maxSum1(int[] a) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < a.length; i++) {
      a = rotate(a);
      int sum = 0;
      for (int i1 = 0; i1 < a.length; i1++) {
        sum += i1 * a[i1];
      }
      max = Math.max(max, sum);
    }
    System.out.println(max);
  }


  private static int[] rotate(int[] a) {

    int temp = a[0];
    for (int i = 0; i + 1 < a.length; i++) {
      a[i] = a[i + 1];
    }
    a[a.length - 1] = temp;
    return a;
  }

}
