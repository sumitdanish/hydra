package com.practice.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateValidParenthesis {

  public static void main(String[] args) {
    String s = "()())()";
    List<String> list = new ArrayList<>();
    char[] ch = {'(', ')'};
    generateValid(s,list,0,0,ch);
    for (String s1:list){
      System.out.println(s1);
    }
  }

  private static void generateValid(String s, List<String> result, int st, int end, char[] ch) {
    int open = 0;
    int i = st;
    for (int counter = 0; i < s.length(); i++) {
      if (s.charAt(i) == ch[0]) {
        counter++;
      } else if (s.charAt(i) == ch[1]) {
        counter--;
      }
      if (counter >= 0) {
        continue;
      }
      for (int j = end; j <= i; j++) {
        if (s.charAt(j) == ch[1] && (j == end || (s.charAt(j-1) != ch[1]))){
          generateValid(s.substring(0,j)+s.substring(j+1,s.length()),result,i,j,ch);
        }
      }
      return;
    }

    String reversed = new StringBuilder(s).reverse().toString();
    if (ch[0] == '('){
      generateValid(reversed,result,0,0,new char[]{')','('});
    }else{
      result.add(reversed);
    }
  }

}
