package org.example.chapter4.trees_and_graphs;

import org.example.structure.tree.BinaryTree;
import org.example.structure.tree.BinaryTree.Node;

public class Task4_8 {

  public static void main(String[] args) {
    var tree = new BinaryTree<Integer>();
    var root = Node.of(0);
    var node1 = Node.of(1);
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
    var node16 = Node.of(16);
    var node17 = Node.of(17);

    root.setLeft(node2);
    root.setRight(node3);

    node2.setLeft(node4);
    node2.setRight(node5);

    node4.setLeft(node8);
    node4.setRight(node9);

    node5.setLeft(node10);
    node5.setRight(node11);

    node10.setLeft(node16);
    node16.setLeft(node17);

    node3.setLeft(node6);
    node3.setRight(node7);

    node6.setLeft(node12);
    node6.setRight(node13);

    node7.setLeft(node14);
    node7.setRight(node15);

    var node = findCommonAncestor(node2, node17);
    System.out.println(node);
  }

  public static Node<Integer> findCommonAncestor(Node<Integer> node1, Node<Integer> node2) {
    if (node1 == node2) {
      return node1;
    }
    int node1Depth = getDepth(node1);
    int node2Depth = getDepth(node2);
    var delta = Math.abs(node1Depth - node2Depth);

    var first = node1Depth > node2Depth ? node1 : node2; // deeper node
    var second = node1Depth < node2Depth ? node1 : node2;
    first = goUp(first, delta);

    while (first != second && first != null && second != null) {
      first = first.getParent();
      second = second.getParent();
    }

    return first == null || second == null ? null : first;
  }

  private static int getDepth(Node<Integer> node) {
    int depth = 1;
    var current = node;
    while (current != null) {
      current = current.getParent();
      depth++;
    }
    return depth;
  }

  private static Node<Integer> goUp(Node<Integer> node, int levels) {
    var current = node;
    for (int i = 0; i < levels; i++) {
      current = current.getParent();
    }
    return current;
  }
}
