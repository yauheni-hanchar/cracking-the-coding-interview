package org.example.chapter4.trees_and_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.example.structure.tree.BinaryTree;
import org.example.structure.tree.BinaryTree.Node;

public class Task4_3 {

  public static void main(String[] args) {
    BinaryTree<Integer> binaryTree = new BinaryTree<>();
    Node<Integer> n1 = Node.of(1);
    Node<Integer> n2 = Node.of(2);
    Node<Integer> n3 = Node.of(3);
    Node<Integer> n4 = Node.of(4);
    Node<Integer> n5 = Node.of(5);
    Node<Integer> n6 = Node.of(6);
    Node<Integer> n7 = Node.of(7);
    Node<Integer> n8 = Node.of(8);

    n1.setChildren(n2, n3);
    n2.setChildren(n4, n5);
    n4.setChildren(n7, n8);
    n3.setLeft(n6);

    binaryTree.setRoot(n1);

    var result = getLevels(binaryTree);
    System.out.println(result);

    var result2 = new ArrayList<LinkedList<Node<Integer>>>();
    getLevelsRecursive(binaryTree.getRoot(), result2, 0);
    System.out.println(result2);
  }

  public static List<LinkedList<Node<Integer>>> getLevels(BinaryTree<Integer> tree) {
    if (tree == null) {
      return Collections.emptyList();
    }
    LinkedList<LinkedList<Node<Integer>>> levels = new LinkedList<>();
    LinkedList<Node<Integer>> level = new LinkedList<>();

    level.push(tree.getRoot());
    levels.push(level);

    boolean isEnd = false;
    while (!isEnd) {
      var lastLevel = levels.peekLast();
      var nextLevel = new LinkedList<Node<Integer>>();
      for (var node : lastLevel) {
        if (node.getLeft() != null) {
          nextLevel.add(node.getLeft());
        }
        if (node.getRight() != null) {
          nextLevel.add(node.getRight());
        }
      }
      if (nextLevel.isEmpty()) {
        isEnd = true;
      } else {
        levels.add(nextLevel);
      }
    }
    return levels;
  }

  public static void getLevelsRecursive(
      Node<Integer> root, ArrayList<LinkedList<Node<Integer>>> result, int levelInt) {
    if (root == null) {
      return;
    }

    LinkedList<Node<Integer>> level = new LinkedList<>();
    if (result.size() == levelInt) {
      result.add(level);
    } else {
      level = result.get(levelInt);
    }

    level.add(root);
    getLevelsRecursive(root.getLeft(), result, levelInt + 1);
    getLevelsRecursive(root.getRight(), result, levelInt + 1);
  }
}
