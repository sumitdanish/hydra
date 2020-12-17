package com.practice.ds.tree.bt;

public class ContiniousTree {

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    BinaryTree bt = binaryTree.getTree();
    boolean b = isContiniousTree(bt);
    System.out.println(b);
  }

  private static boolean isContiniousTree(BinaryTree binaryTree) {
    if (binaryTree == null) {
      return true;
    }
    if (binaryTree.getRight() == null && binaryTree.getLeft() == null) {
      return true;
    }
    if (binaryTree.getRight() == null && Math.abs(binaryTree.getLeft().getData() - binaryTree.getData()) == 1) {
      return isContiniousTree(binaryTree.getLeft());
    }
    if (binaryTree.getLeft() == null && Math.abs(binaryTree.getRight().getData() - binaryTree.getData()) == 1) {
      return isContiniousTree(binaryTree.getRight());
    }

    return binaryTree.getLeft() != null && binaryTree.getRight() != null
        && Math.abs(binaryTree.getData() - binaryTree.getLeft().getData()) == 1
        && Math.abs(binaryTree.getData() - binaryTree.getRight().getData()) == 1 && isContiniousTree(
        binaryTree.getRight()) && isContiniousTree(
        binaryTree.getLeft());
  }
}
