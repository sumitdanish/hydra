package com.practice.ds.tree.bt;

public class BinaryTree {

  private int data;
  private BinaryTree left;
  private BinaryTree right;

  public BinaryTree() {
  }

  public BinaryTree(int data) {
    this.data = data;
  }

  public BinaryTree getTree() {
    BinaryTree binaryTree = new BinaryTree(3);
    binaryTree.setLeft(new BinaryTree(2));
    binaryTree.setRight(new BinaryTree(4));
    binaryTree.getLeft().setLeft(new BinaryTree(1));
    binaryTree.getLeft().setRight(new BinaryTree(3));
    binaryTree.getRight().setRight(new BinaryTree(5));
    return binaryTree;
  }

  public BinaryTree getTree1() {
    BinaryTree bt = new BinaryTree(11);
    bt.setLeft(new BinaryTree(8));
    bt.setRight(new BinaryTree(10));
    bt.getRight().setLeft(new BinaryTree(9));
    bt.getRight().setRight(new BinaryTree(10));
    bt.getLeft().setLeft(new BinaryTree(5));
    bt.getLeft().getLeft().setLeft(new BinaryTree(4));
    bt.getLeft().getLeft().setRight(new BinaryTree(6));
    return bt;
  }

  public BinaryTree getTree2() {
    BinaryTree bt = new BinaryTree(10);
    bt.setLeft(new BinaryTree(7));
    bt.setRight(new BinaryTree(15));
    bt.getLeft().setRight(new BinaryTree(9));
    bt.getRight().setLeft(new BinaryTree(11));
    return bt;
  }

  public BinaryTree getTree3() {
    BinaryTree bt = new BinaryTree(1);
    bt.setLeft(new BinaryTree(2));
    bt.setRight(new BinaryTree(3));
    bt.getLeft().setLeft(new BinaryTree(4));
    bt.getLeft().setRight(new BinaryTree(5));
    bt.getRight().setRight(new BinaryTree(7));
    bt.getRight().setLeft(new BinaryTree(6));
    //bt.getLeft().getRight().setRight(new BinaryTree(10));
    return bt;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public BinaryTree getLeft() {
    return left;
  }

  public void setLeft(BinaryTree left) {
    this.left = left;
  }

  public BinaryTree getRight() {
    return right;
  }

  public void setRight(BinaryTree right) {
    this.right = right;
  }
}
