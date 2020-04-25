package com.practice.ds.backtracking;

public class KnightsTour {

  public static void main(String[] args) {
    solve(8, 8);
  }

  private static void solve(int r, int c) {
    int[] x = {2, 1, -1, -2, -2, -1, 1, 2};
    int[] y = {1, 2, 2, 1, -1, -2, -2, -1};
    int[][] sol = new int[r][c];
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        sol[i][j] = -1;
      }
    }
    sol[0][0] = 0;
    if (solvUtil(sol, 0, 0, r, c, 1, x, y)) {
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          System.out.printf("%s,", sol[i][j]);
        }
        System.out.println();
      }
    }

  }

  private static boolean solvUtil(int[][] sol, int r1, int c1, int r, int c, int mov, int[] x,
      int[] y) {
    if (mov == r * c) {
      sol[r1][c1] = mov;
      return true;
    }

    for (int i = 0; i < x.length; i++) {
      int next_r = r1 + x[i];
      int next_c = c1 + y[i];
      if (isValid(next_r, next_c, sol, r, c)) {
        sol[next_r][next_c] = mov;
        if (solvUtil(sol, next_r, next_c, r, c, mov + 1, x, y)) {
          return true;
        } else {
          sol[next_r][next_c] = -1;
        }
      }
    }
    return false;
  }


  private static boolean isValid(int x, int y, int[][] sol, int r, int c) {
    if (x >= 0 && x < r && y >= 0 && y < c && sol[x][y] == -1) {
      return true;
    }
    return false;
  }

}
