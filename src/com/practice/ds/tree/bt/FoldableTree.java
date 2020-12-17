package com.practice.ds.tree.bt;

public class FoldableTree {

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    boolean b = isFoldable(bt.getTree2().getLeft(), bt.getTree2().getRight());
    System.out.println(b);
  }

  private static boolean isFoldable(BinaryTree left, BinaryTree right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    return isFoldable(left.getLeft(), right.getRight()) && isFoldable(left.getRight(), right.getLeft());
  }


}
