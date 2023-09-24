package org.example.chapter4.trees_and_graphs;

import org.example.structure.tree.BinaryTree;
import org.example.structure.tree.BinaryTree.Node;

public class Task4_10 {

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

    var copy10 = BinaryTree.copy(node10);

    var result = isSubtree2(root, copy10);
    System.out.println("result = " + result);
  }

  public static boolean isSubtree(Node<Integer> root, Node<Integer> root2) {
    var stringTree1 = new StringBuilder();
    var stringTree2 = new StringBuilder();

    getInOrderString(root, stringTree1);
    getInOrderString(root2, stringTree2);

    System.out.println("stringTree1 = " + stringTree1);
    System.out.println("stringTree2 = " + stringTree2);

    return stringTree1.toString().contains(stringTree2.toString());
  }

  private static void getInOrderString(Node<Integer> root, StringBuilder stringTree) {
    if (root == null) {
      stringTree.append("X ");
      return;
    }
    stringTree.append(root.getData()).append(" ");
    getInOrderString(root.getLeft(), stringTree);
    getInOrderString(root.getRight(), stringTree);
  }

  public static boolean isSubtree2(Node<Integer> root, Node<Integer> root2) {
    if(root == null) {
      return false;
    }
    if (root.getData().equals(root2.getData()) && (isMatch(root, root2))) {
        return true;
    }
    return isSubtree2(root.getLeft(), root2) || isSubtree2(root.getRight(), root2);
  }

  private static boolean isMatch(Node<Integer> root, Node<Integer> root2) {
    if(root2 == null) {
      return true;
    }
    if(root == null || !root2.getData().equals(root.getData())) {
      return false;
    }
    return isMatch(root.getLeft(), root2.getLeft()) && isMatch(root.getRight(), root2.getRight());
  }
}
