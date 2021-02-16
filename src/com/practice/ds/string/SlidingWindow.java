package com.practice.ds.string;

public class SlidingWindow {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstringTwoDistinct("cdaba"));
  }

  public static int lengthOfLongestSubstringTwoDistinct(String s) {
    int max = Integer.MIN_VALUE;
    int start = 0;
    int k = 2;
    if (s.length() == 0) {
      return 0;
    }
    int[] map = new int[26];
    for (int i = 0; i < s.length(); i++) {
      map[s.charAt(i) - 'a']++;
      if (notMoreThank(map, k)) {
        max = Math.max(max, (i - start + 1));
      } else {
        map[s.charAt(start) - 'a']--;
        start++;
      }
    }
    return max;
  }

  private static boolean notMoreThank(int[] map, int k) {
    int cnt = 0;
    for (int i = 0; i < 26; i++) {
      if (map[i] != 0) {
        cnt++;
      }
      if (cnt > k) {
        return false;
      }
    }
    return true;
  }
}
