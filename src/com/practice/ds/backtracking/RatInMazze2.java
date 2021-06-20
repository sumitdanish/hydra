package com.practice.ds.backtracking;

public class RatInMazze2 {

  public static void main(String[] args) {
    int[][] mat = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
    int[][] sol = new int[mat.length][mat[0].length];
    if (move(mat, mat.length, mat[0].length, 0, 0, new boolean[mat.length][mat[0].length],sol)) {
      for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[i].length; j++) {
          System.out.print(sol[i][j]);
        }
        System.out.println();
      }
    }
  }

  private static boolean move(int[][] mat, int row, int col, int r, int c, boolean[][] vi,int[][] sol) {
    if (!isValid(mat, row, col, r, c, vi)) {
      return false;
    }
    if (r == row - 1 && c == col - 1 && mat[r][c] == 1) {
      sol[r][c] =1;
      return true;
    }
    vi[r][c] = true;
    sol[r][c] =1;
    if (move(mat, row, col, r, c + 1, vi,sol)) {
      return true;
    }

    if (move(mat, row, col, r + 1, c, vi,sol)) {
      return true;
    }
    vi[r][c] = true;
    sol[r][c] = 0;
    return false;
  }

  private static boolean isValid(int[][] mat, int row, int col, int r, int c, boolean[][] vi) {
    if (r < 0 || r >= row || c < 0 || c >= col || mat[r][c] != 1 || vi[r][c]) {
      return false;
    }
    return true;
  }

}
