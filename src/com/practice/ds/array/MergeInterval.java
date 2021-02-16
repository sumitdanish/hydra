package com.practice.ds.array;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {

  public static void main(String[] args) {
    int[][] inte = {{1,5}};
    int[] n = {6,8};
   /* for (int[] x: interval(inte,n)){
      System.out.println(x[0]+" : "+x[1]);
    }*/

  }

  private static int[][] interval(int[][] intervals, int[] newInterval) {
    List<int[]> mergedList = new ArrayList<>();
    int cnt = 0;
    boolean flag = false;
    int x=0;
    for (int i = 0; i < intervals.length; i++) {
      if (intervals[i][1] < newInterval[0]) {
        mergedList.add(intervals[i]);

      } else if (intervals[i][0] > newInterval[1]) {
        mergedList.add(intervals[i]);

      } else {
        if (!flag) {
          cnt = i;
          flag = !flag;
        }
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      }
    }

    System.out.println(cnt);
    mergedList.add(cnt, newInterval);
    return mergedList.toArray(new int[mergedList.size()][]);
  }
}
