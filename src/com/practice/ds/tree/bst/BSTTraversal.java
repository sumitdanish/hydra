package com.practice.ds.tree.bst;

import java.util.Stack;

public class BSTTraversal {

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    inOrder(bst.getTree());
  }

  private static void inOrder(BinarySearchTree tree) {
    Stack<BinarySearchTree> stack = new Stack<>();
    while (tree != null || !stack.isEmpty()) {
      while (tree != null) {
        stack.push(tree);
        tree = tree.getLeft();
      }
      tree = stack.pop();
      System.out.print(tree.getData() + ",");
      tree = tree.getRight();
    }
  }
}
