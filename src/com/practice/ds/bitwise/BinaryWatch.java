package com.practice.ds.bitwise;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Binary Watch
 * LC: 401
 */
public class BinaryWatch {

  public static void main(String[] args) {

    //System.out.println(String.format("%d:%02d",3,30));

    //possibleWatches(5).stream().forEach(System.out::println);

    System.out.println(getMap().hashCode());
    System.out.println(getMap().hashCode());

  }

  private static Map<String,String> getMap(){
    return new HashMap<String,String>(){{put("key1","val1");}};
  }


  private static List<String> possibleWatches(int num){
    List<String> list = new ArrayList<>();
    for (int h=0;h<=12;h++){
      int countOnesInH = countOnes(h);
      if (countOnesInH > num){
        continue;
      }
      for (int m =0;m<=59;m++){
        int countOnesInM = countOnes(m);
        if (countOnesInH+countOnesInM == num){
          list.add(String.format("%d:%02d",h,m));
        }
      }
    }
    return list;
  }




  public static int countOnes(int n){
    int sum = 0;
    for(int i=0;i<6;i++){
      int bit = n&1;
      /**
       * Why we are doing right shift
       * Will extract last bit and will AND with
       * One and count the result
       */
      n = n>>1;
      sum +=bit;
    }
    return sum;
  }

}
