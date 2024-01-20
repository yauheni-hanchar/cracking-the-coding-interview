package org.example.chapter4.trees_and_graphs;

import static java.lang.Integer.MIN_VALUE;

import org.example.structure.tree.BinaryTree;
import org.example.structure.tree.BinaryTree.Node;

public class Task4_4 {

  public static void main(String[] args) {
    var tree = new BinaryTree<Integer>();
    var root = Node.of(1);
    tree.setRoot(root);
    var node2 = Node.of(2);
    var node3 = Node.of(3);
    var node4 = Node.of(4);
    var node5 = Node.of(5);
    var node6 = Node.of(6);
    var node7 = Node.of(7);
    var node8 = Node.of(8);

    root.setLeft(node2);
    root.setRight(node3);

    node2.setLeft(node4);
    node2.setRight(node5);

    node4.setLeft(node7);
    node4.setRight(node8);

    //    node3.setLeft(node6);

    var isBalanced = isBalanced2(root);
    System.out.println(isBalanced);
  }

  public static int getMaxLevel(Node<Integer> root) {
    if (root == null) {
      return -1;
    }
    return Math.max(getMaxLevel(root.getLeft()), getMaxLevel(root.getRight())) + 1;
  }

  public static boolean isBalanced(Node<Integer> root) {
    if (root == null) {
      return true;
    }

    var isBranchesBalanced =
        Math.abs(getMaxLevel(root.getLeft()) - getMaxLevel(root.getRight())) <= 1;

    if (!isBranchesBalanced) {
      return false;
    }

    var isLeftBalanced = isBalanced(root.getLeft());
    var isRightBalanced = isBalanced(root.getRight());

    return isLeftBalanced && isRightBalanced;
  }

  public static int isBalanced2(Node<Integer> root) {
    if (root == null) {
      return -1;
    }
    var leftMaxLevel = getMaxLevel(root.getLeft());
    if (leftMaxLevel == MIN_VALUE) {
      return MIN_VALUE;
    }
    var rightMaxLevel = getMaxLevel(root.getRight());
    if (rightMaxLevel == MIN_VALUE) {
      return MIN_VALUE;
    }

    var diff = Math.abs(leftMaxLevel - rightMaxLevel);
    if (diff > 1) {
      return MIN_VALUE;
    }

    return Math.max(leftMaxLevel, rightMaxLevel) + 1;
  }
}
