package com.practice.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSwap {

  public static void main(String[] args) {


    Integer num = 9973;
    char[] ch = String.valueOf(num).toCharArray();
    char[] ch1= Arrays.copyOf(ch,ch.length);
    for (int i=0;i<ch.length;i++){
      for (int j=i+1;j<ch.length;j++){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        for (int k=0;k<ch.length;k++){
          if (ch[k] != ch1[k]){
            if(ch[k] -'0' > ch1[k] - '0' && num < Integer.valueOf(String.valueOf(ch))){
              ch1 = Arrays.copyOf(ch,ch.length);
              num = Integer.valueOf(String.valueOf(ch));
              break;
            }
          }
        }
        ch[j] = ch[i];
        ch[i] = temp;
      //  System.out.println(ch);
      }
    }
    Map<Integer,List<Integer>> map = new HashMap<>();
for(Map.Entry<Integer,List<Integer>> m : map.entrySet()){

}
    System.out.println(num);

  }

}
