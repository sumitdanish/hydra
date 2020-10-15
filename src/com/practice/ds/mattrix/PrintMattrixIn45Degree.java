package com.practice.ds.mattrix;

public class PrintMattrixIn45Degree {

  public static void main(String[] args) {
    int[][] matt = {{2, 5, 7, 2},
        {9, 1, 4, 3},
        {5, 8, 2, 3},
        {6, 4, 6, 3}};
    int n = 4;
    rotate(matt, n);

    //System.out.println(Math.floor(7/2));

  }

  private static void rotate(int[][] matt, int n) {
    int cnt = 0;
    while (cnt < 2 * n - 1) {
      for (int i = 0; i < Math.abs(n - cnt - 1); i++) {
        System.out.printf(" ");
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i + j == cnt) {
            System.out.print(matt[i][j]+" ");
          }
        }
      }
      System.out.println();
      cnt++;
    }
  }

}
