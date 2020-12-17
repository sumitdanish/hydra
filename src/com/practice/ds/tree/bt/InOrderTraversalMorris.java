package com.practice.ds.tree.bt;

public class InOrderTraversalMorris {

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    BinaryTree bt = binaryTree.getTree3();
    inOrderMorris(bt);
  }

  private static void inOrderMorris(BinaryTree tree) {
    BinaryTree pre = null;
    while (tree != null) {
      if (tree.getLeft() == null) {
        System.out.print(tree.getData() + ",");
        tree = tree.getRight();
      } else {
        pre = tree.getLeft();
        while (pre.getRight() != null && pre.getRight() != tree) {
          pre = pre.getRight();
        }
        if (pre.getRight() == null) {
          pre.setRight(tree);
          tree = tree.getLeft();
        } else {
          pre.setRight(null);
          System.out.print(tree.getData() + ",");
          tree = tree.getRight();
        }
      }
    }
  }


}
