package com.practice.ds.mattrix;



/**
 *         1    2   3   4
 *         5    6   7   8
 *         9   10  11  12
 *         13  14  15  16
 *
 * 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 */

public class PrintMatrixInSpiral {

  public static void main(String[] args) {
    int[][] mat = {{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    inSpiral(mat);
  }

  private static void inSpiral(int[][] mat){
    int row = mat.length;
    int col = mat[0].length;
    int r=0;
    for(int i=0;i<col && r < row;i++){
        for(int c=i;c<col;c++){
          System.out.print(mat[r][c]+",");
        }
        r++;
        for(int r1=r;r1<row;r1++){
          System.out.print(mat[r1][col-1]+",");
        }
        col--;
        for(int c1=col-1;c1>=i;c1--){
          System.out.print(mat[row-1][c1]+",");
        }
        row--;
        for (int r1=row-1;r1>=r;r1--){
          System.out.print(mat[r1][i]+",");
        }
    }
  }


}
