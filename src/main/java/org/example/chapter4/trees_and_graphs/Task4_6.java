package org.example.chapter4.trees_and_graphs;

import static java.lang.Integer.MIN_VALUE;

import org.example.structure.tree.BinaryTree;
import org.example.structure.tree.BinaryTree.Node;

public class Task4_6 {

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
    var node9 = Node.of(9);
    var node10 = Node.of(10);
    var node11 = Node.of(11);
    var node12 = Node.of(12);
    var node13 = Node.of(13);
    var node14 = Node.of(14);
    var node15 = Node.of(15);

    root.setLeft(node2);
    root.setRight(node3);

    node2.setLeft(node4);
    node2.setRight(node5);

    node4.setLeft(node8);
    node4.setRight(node9);

    node5.setLeft(node10);
    node5.setRight(node11);

    node3.setLeft(node6);
    node3.setRight(node7);

    node6.setLeft(node12);
    node6.setRight(node13);

    node7.setLeft(node14);
    node7.setRight(node15);

    BinaryTree.printInOrder(root);

    System.out.println();
    printNextInOrderNode(node8);
    printNextInOrderNode(node4);
    printNextInOrderNode(node9);
    printNextInOrderNode(node2);
    printNextInOrderNode(node10);
    printNextInOrderNode(node5);
    printNextInOrderNode(node11);
    printNextInOrderNode(root);
    printNextInOrderNode(node12);
    printNextInOrderNode(node6);
    printNextInOrderNode(node13);
    printNextInOrderNode(node3);
    printNextInOrderNode(node14);
    printNextInOrderNode(node7);
    printNextInOrderNode(node15);
  }

  public static void printNextInOrderNode(Node<Integer> node) {
    System.out.print("Current = " + node);
    Node<Integer> result = null;
    if (node.getRight() != null) {
      result = diveIn(node.getRight());
    } else {
      result = bubbleUp(node, node.getParent());
    }
    System.out.print(", Next = " + result);
    System.out.println();
  }

  private static Node<Integer> diveIn(Node<Integer> node) {
    var current = node;
    while (current.getLeft() != null) {
      current = current.getLeft();
    }
    return current;
  }

  private static Node<Integer> bubbleUp(Node<Integer> child, Node<Integer> parent) {
    if (parent == null) {
      return null;
    }
    var leftFromParent = parent.getLeft();
    if (leftFromParent != null && leftFromParent.getData().equals(child.getData())) {
      return parent;
    }
    return bubbleUp(parent, parent.getParent());
  }
}
