package com.practice.ds.mattrix;

public class PrintMatrixDiagonally {

  /**
   *  1  2  3  4
   *  5  6  7  8
   *  9 10 11 12
   *  13 14 15 16
   *
   *  1
   *  5 2
   *  9 6 3
   *  13 10 7 4
   *  14 11 8
   *  15 12
   *  16
   *
   *  13
   *  9 14
   *  5 10 15
   *  1 6 11 16
   *  2 7 12
   *  3 8
   *  4
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] mat = {{1,2,3,4,9},
                  {5,6,7,8,90},
                  {9,10,11,12,89},
                  {13,14,15,16,78}};

   // printMatrixFromUpward(mat,mat.length,mat[0].length);
    printMatrixFromDownward(mat,mat.length,mat[0].length);
  }

  private static void printMatrixFromDownward(int[][] mat,int row,int col){
    for(int r = row-1,c=0;r >=0 && c < col;r--,c++){
      int r1 = r;
      int c1 = 0;
      while(r1 <= row-1 && c1 < col){
        System.out.print(mat[r1][c1]+" ");
        r1++;c1++;
      }
      System.out.println();
    }

    for(int c = 1;c<col;c++){
      int r = 0;
      int c1= c;
      while (c1 < col){
        System.out.print(mat[r][c1]+" ");
        r++;
        c1++;
      }
      System.out.println();
    }
  }

  private static void printMatrixFromUpward(int[][] mat, int row, int col) {
    for (int r = 0, c = 0; r < row && c < col; r++, c++) {
        int r1 = r;
        int c1 = 0;
        while(r1 >= 0 && c1 < col){
          System.out.print(mat[r1][c1]+" ");
          r1--;c1++;
        }
      System.out.println();
    }
    for(int c=1;c < col;c++){
      int c1=c;
      int r = row-1;
      while(c1 < col){
        System.out.print(mat[r][c1]+" ");
        r--;c1++;
      }
      System.out.println();
    }

  }

}
