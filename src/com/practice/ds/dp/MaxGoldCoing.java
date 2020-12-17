package com.practice.ds.dp;

public class MaxGoldCoing {

  public static void main(String[] args) {
    int[][] mat = {{1, 3, 1, 5},
        {2, 2, 4, 1},
        {5, 0, 2, 3},
        {0, 6, 1, 2}};

    int max = -1;
    int row = 4;
    int col = 4;
    for (int i = 0; i < row; i++) {
      max = max(max, maxGoldCoin(mat, i, 0, row, col));
    }
    System.out.println(max);
  }

  private static int maxGoldCoin(int[][] mat, int i, int j, int row, int col) {
    if ((i == row - 1 && j == col - 1) || (i >= 0 && i < row && j == col - 1)) {
      return mat[i][j];
    }
    if (i < 0 || i >= row || j >= col) {
      return 0;
    }

    int right = maxGoldCoin(mat, i, j + 1, row, col);
    int rightUp = maxGoldCoin(mat, i - 1, j + 1, row, col);
    int rightDOwn = maxGoldCoin(mat, i + 1, j + 1, row, col);
    return max(max(right, rightDOwn), rightUp) + mat[i][j];
  }

  private static int max(int a, int b) {
    return a > b ? a : b;
  }

}
