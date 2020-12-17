package com.practice.ds.tree.bt;

/**
 * Successor/predecessor will always used to store some information on null of right/left information i.e 1. successor
 * will always store in null right pointer. 2. predecessor will be always stored in null left pointer
 */
public class InOrderSuccessor {

  static boolean flag;

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    BinaryTree tree = bt.getTree3();
    inOrderSuccessor(tree, new BinaryTree(5));
  }

  private static void inOrderSuccessor(BinaryTree tree, BinaryTree binaryTree) {
    if (tree != null) {
      inOrderSuccessor(tree.getLeft(), binaryTree);
      if (flag) {
        System.out.println("Inorder Successor : " + tree.getData());
        flag = !flag;
      }
      if (tree.getData() == binaryTree.getData()) {
        flag = !flag;
      }
      inOrderSuccessor(tree.getRight(), binaryTree);
    }
  }


}
