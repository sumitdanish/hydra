package com.practice.ds.tree.bst;

public class BinarySearchTree {

  private BinarySearchTree left;
  private BinarySearchTree right;
  private int data;

  public BinarySearchTree() {

  }

  public BinarySearchTree(int data) {
    this.data = data;
  }

  public BinarySearchTree getLeft() {
    return left;
  }

  public void setLeft(BinarySearchTree left) {
    this.left = left;
  }

  public BinarySearchTree getRight() {
    return right;
  }

  public void setRight(BinarySearchTree right) {
    this.right = right;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public BinarySearchTree getTree() {
    BinarySearchTree bst = new BinarySearchTree(11);
    bst.setLeft(new BinarySearchTree(2));
    bst.setRight(new BinarySearchTree(29));
    bst.getRight().setLeft(new BinarySearchTree(15));
    bst.getRight().setRight(new BinarySearchTree(40));
    bst.getRight().getRight().setLeft(new BinarySearchTree(35));
    bst.getLeft().setLeft(new BinarySearchTree(1));
    bst.getLeft().setRight(new BinarySearchTree(7));
    return bst;
  }

  public BinarySearchTree getTree1() {
    BinarySearchTree bst = new BinarySearchTree(5);
    bst.setLeft(new BinarySearchTree(2));
    bst.setRight(new BinarySearchTree(13));
    return bst;
  }

  public void printTree(BinarySearchTree bst) {
    if (bst == null) {
      return;
    }
    printTree(bst.getLeft());
    System.out.print(bst.getData() + ",");
    printTree(bst.getRight());
  }
}
