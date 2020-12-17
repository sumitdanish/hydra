package com.practice.ds.tree.bt;

public class CountBSTInBT {

  static int count = 0;

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    countBST(bt.getTree1());
    System.out.println(count);
  }

  private static void countBST(BinaryTree bt) {
    if (bt == null) {
      return;
    }
    countBST(bt.getLeft());
    if (bt.getLeft() == null && bt.getRight() == null) {
      count++;
    } else if (bt.getLeft() == null || bt.getRight() == null) {
      if (bt.getLeft() == null && bt.getRight().getData() > bt.getData()) {
        count++;
      } else if (bt.getRight() == null && bt.getData() > bt.getLeft().getData()) {
        count++;
      }
    } else if (bt.getData() > bt.getLeft().getData() && bt.getData() < bt.getRight().getData()) {
      count++;
    }
    countBST(bt.getRight());
  }



}
