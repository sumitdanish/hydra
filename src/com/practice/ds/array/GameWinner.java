package com.practice.ds.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Input: arr = [2,1,3,5,4,6,7], k = 2
 * Output: 5
 * Explanation: Let's see the rounds of the game:
 * Round |       arr       | winner | win_count
 *   1   | [2,1,3,5,4,6,7] | 2      | 1
 *   2   | [2,3,5,4,6,7,1] | 3      | 1
 *   3   | [3,5,4,6,7,1,2] | 5      | 1
 *   4   | [5,4,6,7,1,2,3] | 5      | 2
 * So we can see that 4 rounds will be played and 5 is the winner because it wins 2 consecutive games.
 */
public class GameWinner {

  public static void main(String[] args) {
    Deque<Integer> queue = new LinkedList<>();
    int k=2;
    int[] a = {2,1,3,5,4,6,7};
    if (a.length <= 1 && k <=1){
      return;
    }
    if(a.length == 2){
      if (a[0] >= a[1]){
        return;
      }else {
        return;
      }
    }
    int i=2;

    int count=0;
    queue.addFirst(a[0]);
    queue.addLast(a[1]);
    int len=0;
    int len1=a.length-1;
    while (true){
      if (i >= a.length){
        i=2;
      }
      int a1 = queue.removeFirst();
      int a2 = queue.removeLast();
      if(a1 >= a2){
        queue.addFirst(a1);
        queue.addLast(a[i]);
        count++;
        len--;
        len1--;
        if (count == k){
          System.out.println(a1);
          break;
        }
      }else if(a1 < a2){
        queue.addFirst(a2);
        queue.addLast(a[i]);
        len++;
        len1++;
        count=1;
      }
      if (len == a.length-1){
        System.out.println(a[a.length-1]);
        break;
      }else if(len1 == 0){
        System.out.println(a[0]);
        break;
      }
      i++;
    }
  }

}
