package com.practice.ds.backtracking;

public class RatInMazeP1Recursion {

  public static void main(String[] args) {
    int[][] mat = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
    int[][] sol = new int[4][4];
    if (ratInMaze(mat, 0, 0, 4, 4,sol)) {
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
          System.out.printf("%s,", sol[i][j]);
        }
        System.out.println();
      }
    }
  }

  private static boolean isValid(int[][] mat, int r, int c, int row, int col) {
    if (r >= 0 && r < row && c >= 0 && c < col && mat[r][c] == 1) {
      return true;
    }
    return false;
  }

  private static boolean ratInMaze(int[][] mat, int r, int c, int row, int col,int[][] sol) {
    if (r == row - 1 && c == col - 1 && mat[r][c] == 1) {
      sol[r][c] = 1;
      return true;
    }

    if (isValid(mat, r, c, row, col)) {
      if (ratInMaze(mat, r + 1, c, row, col,sol)) {
        sol[r][c] = 1;
        return true;
      }
      if (ratInMaze(mat, r, c + 1, row, col,sol)) {
        sol[r][c] = 1;
        return true;
      } else {
        sol[r][c] = 1;
        return false;
      }
    }
    return false;
  }
}
