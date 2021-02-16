package com.practice.ds.array;

import java.util.Deque;
import java.util.LinkedList;

public class MainInKWindow {

  public static void main(String[] args) {
    int[] a = {7,2,4};
    int k = 2;
    int[] ch = new int[26];
    for (int c : ch){
      System.out.println(c);
    }

    /*for (int x : maxInKWindow(a, k)) {
      System.out.print(x + ",");
    }*/
  }

  private static int[] maxInKWindow(int[] a, int k) {
    int max = Integer.MIN_VALUE;
    int[] a1 = new int[a.length - k + 1];
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < k; i++) {
      while (!deque.isEmpty() && a[i] >= a[deque.peekLast()]) {
        deque.removeLast();
      }
      deque.add(i);
    }
    int l = 0;
    for (int i = k; i < a.length; i++) {
      a1[l++] = a[deque.peek()];
      while (!deque.isEmpty() && deque.peek() <= i - k) {
        deque.remove();
      }
      while (!deque.isEmpty() && a[i] >= a[deque.peekLast()]) {
        deque.removeLast();
      }
      deque.add(i);
    }
    if (!deque.isEmpty()) {
      a1[l] = a[deque.peek()];
    }
    return a1;
  }


}
