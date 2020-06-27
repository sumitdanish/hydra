package com.practice.ds.backtracking;

import java.util.Stack;

public class RatInMazeUsingStack {

  public static void main(String[] args) {
    int[][] mat = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
    int[][] sol = new int[4][4];
    if (ratInMaze(mat, 4, 4, sol)) {
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
          System.out.printf("%s,", sol[i][j]);
        }
        System.out.println();
      }
    }
  }

  private static boolean isValid(int[][] mat, int r, int c, int row, int col, boolean[][] visited) {
    if (r >= 0 && r < row && c >= 0 && c < col && mat[r][c] == 1 && visited[r][c] == false) {
      return true;
    }
    return false;
  }

  private static boolean ratInMaze(int[][] mat, int row, int col, int[][] sol) {
    Stack<Point> stack = new Stack<>();
    Point p1 = new Point(0, 0);
    stack.push(p1);
    boolean[][] visited = new boolean[row][col];
    visited[0][0] = true;
    sol[0][0] = 1;
    while (!stack.isEmpty()) {
      Point p2 = stack.pop();
      if (p2.getC() == col - 1 && p2.getR() == row - 1) {
        sol[p2.getR()][p2.getC()] = 1;
        visited[p2.getR()][p2.getC()] = true;
        return true;
      }
      if (isValid(mat, p2.getR() + 1, p2.getC(), row, col, visited)) {
        sol[p2.getR() + 1][p2.getC()] = 1;
        visited[p2.getR() + 1][p2.getC()] = true;
        stack.push(new Point(p2.getR() + 1, p2.getC()));
      }
      if (isValid(mat, p2.getR(), p2.getC() + 1, row, col, visited)) {
        sol[p2.getR()][p2.getC() + 1] = 1;
        visited[p2.getR()][p2.getC() + 1] = true;
        stack.push(new Point(p2.getR(), p2.getC() + 1));
      }
    }
    return false;
  }

}

class Point {

  private int r;
  private int c;

  public Point(int r, int c) {
    this.r = r;
    this.c = c;
  }

  public int getR() {
    return r;
  }

  public int getC() {
    return c;
  }
}
