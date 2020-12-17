package com.practice.ds.tree.bt;

public class PredecessorSuccessorSum {
static BinaryTree pre=null;
static int preSum=-1;
  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    BinaryTree bt = binaryTree.getTree3();
    replaceNode(bt);
    pre.setData(preSum);
    print(bt);
  }

  private static void replaceNode(BinaryTree bt) {
    if (bt != null) {
      replaceNode(bt.getLeft());
      if (pre == null) {
        pre = bt;
      } else if (preSum == -1) {
        preSum = pre.getData();
        pre.setData(bt.getData());
        pre = bt;
      } else {
        int temp = pre.getData();
        pre.setData(preSum + bt.getData());
        preSum = temp;
        pre = bt;
      }
      replaceNode(bt.getRight());
    }
  }

  private static void print(BinaryTree bt) {
    if (bt == null) {
      return;
    }
    System.out.print(bt.getData() + ",");
    print(bt.getLeft());
    print(bt.getRight());

  }
}
