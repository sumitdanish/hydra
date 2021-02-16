package com.practice.ds.string;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestUniqueSubString {

  public static void main(String[] args) {
    System.out.println(longestSubstring("abcabcbb"));
  }

  private static int longestSubstring(String s){
    if (s.length() <= 0){
      return 0;
    }
    int max = 0;
    int left = 0;
    int right = 0;
    Set<Character> set = new HashSet<>();
    int len = 0;
    String s1="";
    while (right < s.length()){
      if (!set.contains(s.charAt(right))){
        set.add(s.charAt(right));
        right++;
        if(max < set.size()){
          max = set.size();
          s1 = s.substring(left,right);
        }
        continue;
      }
      set.remove(s.charAt(left));
      left++;
    }
    System.out.println(s1);
    return  max;
  }

}
