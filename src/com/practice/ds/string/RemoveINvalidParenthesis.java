package com.practice.ds.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RemoveINvalidParenthesis {

  public static void main(String[] args) {
    String s = "(a(b(c)d)";
    minRemoveToMakeValid(s);
    //System.out.println(minRemoveToMakeValid(s));
  }

  public static String minRemoveToMakeValid(String s) {
    Stack<Pair> stack = new Stack<Pair>();
    List<Integer> l = new ArrayList<>();
    if (s.length() <= 0) {
      return "";
    }

    for (int i = 0; i < s.length(); i++) {
      if (stack.isEmpty() && s.charAt(i) == ')') {
        Pair p = new Pair();
        p.ch = ')';
        p.index = i;
        stack.push(p);

      } else {
        if (s.charAt(i) == '(') {
          Pair p = new Pair();
          p.ch = '(';
          p.index = i;
          stack.push(p);
        } else if (s.charAt(i) == ')') {
          if (!stack.isEmpty() && stack.peek().ch == '(') {
            stack.pop();
          }else{
            Pair p = new Pair();
            p.ch = ')';
            p.index = i;
            stack.push(p);
          }
        }
      }
    }
    String s1="";
    Set<Integer> set = new HashSet<>();
    while (!stack.isEmpty()) {
      int index = stack.pop().index;
      System.out.println(index);
      set.add(index);
    }

    for (int i=0;i<s.length();i++){
      if(!set.contains(i)){
        s1+=String.valueOf(s.charAt(i));
      }
    }

    return s1;
  }
}

class Pair {

  public char ch;
  public int index;
}
