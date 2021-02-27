package com.practice.ds.mattrix;

public class SubscribeMatrix {

  /**
   * [ [0,1,1,1], [1,1,1,1], [0,1,1,1] ]
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] mat = {
        {0, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1}
    };
    System.out.println(mat.length + " : " + mat[0].length);
    countSubSquireMatrix(mat, mat.length, mat[0].length);
  }

  private static void countSubSquireMatrix(int[][] mat, int row, int col) {
    int count = 0;
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        int sum = 0;
        for (int k = 0; k < (i + 1) * (j + 1); k++) {
          int r = k / (i + 1);
          int c = k % (j + 1);
          if(r<row && j < col) {
            sum += mat[r][c];
          }
        }
        if (sum == ((i + 1) * (j + 1))) {
          count += sum;
        }
      }
    }
    System.out.println(count);
  }
}
