package org.example.chapter4.trees_and_graphs;

import static java.lang.Integer.MIN_VALUE;

import org.example.structure.tree.BinaryTree;
import org.example.structure.tree.BinaryTree.Node;

public class Task4_5 {

  public static void main(String[] args) {
    var tree = new BinaryTree<Integer>();
    var root = Node.of(5);
    tree.setRoot(root);
    var node1 = Node.of(1);
    var node2 = Node.of(2);
    var node3 = Node.of(3);
    var node4 = Node.of(4);
    var node6 = Node.of(6);
    var node7 = Node.of(7);
    var node8 = Node.of(8);
    var node9 = Node.of(9);
    var node10 = Node.of(10);

    root.setLeft(node3);
    root.setRight(node7);

    node3.setLeft(node2);
    node3.setRight(node4);

    node2.setLeft(node1);

    node7.setLeft(node6);
    node7.setRight(node8);
    node8.setRight(node9);
    node6.setRight(node10);

    var result = isBST3(root);
    System.out.println(result);
  }

  public static boolean isBST(Node<Integer> current) {
    if (current == null) {
      return true;
    }
    var allLess = checkIf(current.getLeft(), current.getData(), false);
    if (!allLess) {
      return false;
    }
    var allGreater = checkIf(current.getRight(), current.getData(), true);
    if (!allGreater) {
      return false;
    }
    return isBST(current.getLeft()) && isBST(current.getRight());
  }

  private static boolean checkIf(Node<Integer> root, int parentValue, boolean isBigger) {
    if (root == null) {
      return true;
    }
    if (isBigger) {
      if (root.getData() <= parentValue) {
        return false;
      }
    } else {
      if (root.getData() > parentValue) {
        return false;
      }
    }

    var isLeftsGreater = checkIf(root.getLeft(), parentValue, isBigger);
    if (!isLeftsGreater) {
      return false;
    }

    return checkIf(root.getRight(), parentValue, isBigger);
  }

  private static int previous = MIN_VALUE;

  /** Does not work if we have equal elements in a tree */
  public static boolean isBST2(Node<Integer> current) {
    if (current == null) {
      return true;
    }
    var isLeftOk = isBST2(current.getLeft());
    if (!isLeftOk) {
      return false;
    }
    System.out.println("Previous: " + previous + ", Current: " + current.getData());
    if (previous != MIN_VALUE && previous > current.getData()) {
      return false;
    }
    previous = current.getData();
    return isBST2(current.getRight());
  }

  public static boolean isBST3(Node<Integer> current) {
    return isBST3(current, null, null);
  }

  public static boolean isBST3(Node<Integer> current, Integer min, Integer max) {
    if (current == null) {
      return true;
    }
    if (min != null && current.getData() <= min || max != null && current.getData() > max) {
      return false;
    }
    if (!isBST3(current.getLeft(), min, current.getData())
        || !isBST3(current.getRight(), current.getData(), max)) {
      return false;
    }
    return true;
  }
}
