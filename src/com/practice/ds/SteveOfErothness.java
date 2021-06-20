package com.practice.ds;

import java.util.Arrays;

public class SteveOfErothness {

  public static void main(String[] args) {
    int num = 100;
  boolean[] b = prime(num);
    for (int i=0;i<num;i++){

      if (!b[i]){
        System.out.print(i+",");
      }
    }
  }


  private static boolean[] prime(int num){
    boolean[] prime = new boolean[num];
    prime[0] = true;
    prime[1] = true;
    for (int i=2;i<=Math.sqrt(num);i++){
      if (prime[i]){
        continue;
      }
      prime[i] = false;
      for (int j = i*i;j < num;j = j+i){
        prime[j] = true;
      }
    }
    return prime;
  }


}
