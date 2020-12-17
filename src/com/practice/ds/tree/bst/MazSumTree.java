package com.practice.ds.tree.bst;

public class MazSumTree {

  private static int sum = 0;

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    BinarySearchTree tree = bst.getTree1();
    bst.printTree(tree);
  //  maxTreeSumExcludeCurrentNode(tree);
    maxSumTreeIncludingCurrentNode(tree);
    System.out.println();
    bst.printTree(tree);

  }

  private static void maxTreeSumExcludeCurrentNode(BinarySearchTree tree) {
    if (tree == null) {
      return;
    }
    maxTreeSumExcludeCurrentNode(tree.getRight());
    sum += tree.getData();
    tree.setData(sum - tree.getData());
    maxTreeSumExcludeCurrentNode(tree.getLeft());
  }

  private static void maxSumTreeIncludingCurrentNode(BinarySearchTree tree) {
    if (tree == null) {
      return;
    }

    maxSumTreeIncludingCurrentNode(tree.getRight());
    sum += tree.getData();
    tree.setData(sum);
    maxSumTreeIncludingCurrentNode(tree.getLeft());
  }

}


