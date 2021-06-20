package com.practice.ds.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SubSetProblem {

  public static void main(String[] args) {
   int[] a = {1,2,3};
    List<List<Integer>> subset = new ArrayList<>();
    List<Integer> set = new ArrayList<>();
    printSubSet(a,0,subset,set);
    subset.stream().forEach(x ->{
      x.stream().forEach(y ->{
        System.out.print(y+",");
      });
      System.out.println();
    });


  }

  private static void printSubSet(int[] a, int i, List<List<Integer>> subset, List<Integer> set) {
    subset.add(new ArrayList<>(set));
    for (int k = i;k<a.length;k++){
      set.add(a[k]);
      printSubSet(a,k+1,subset,set);
      set.remove(set.size()-1);
    }
  }

}
