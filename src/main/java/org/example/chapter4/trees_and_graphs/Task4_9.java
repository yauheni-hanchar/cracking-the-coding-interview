package org.example.chapter4.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import org.example.structure.tree.BinaryTree;
import org.example.structure.tree.BinaryTree.Node;

public class Task4_9 {

  public static void main(String[] args) {
    var tree = new BinaryTree();
    var root = Node.of(10);
    var n1 = Node.of(20);
    var n2 = Node.of(2);
    var n3 = Node.of(30);
    var n4 = Node.of(4);
    var n5 = Node.of(5);

    tree.setRoot(root);

    root.setLeft(n5);
    root.setRight(n1);

    n5.setLeft(n2);
    n5.setRight(n4);

    n1.setRight(n3);

    var result = bstSequences(root);
    System.out.println(result);
  }

  public static ArrayList<LinkedList<Integer>> bstSequences(Node<Integer> root) {
    var results = new ArrayList<LinkedList<Integer>>();
    if (root == null) {
      results.add(new LinkedList<>());
      return results;
    }

    var prefix = new LinkedList<Integer>();
    prefix.add(root.getData());
    var leftResults = bstSequences(root.getLeft());
    var rightResults = bstSequences(root.getRight());

    for (var leftResult : leftResults) {
      for (var rightResult : rightResults) {
        var localResults = new ArrayList<LinkedList<Integer>>();
        weaveLists(leftResult, rightResult, localResults, prefix);
        results.addAll(localResults);
      }
    }
    System.out.println((~0));
    return results;
  }

  private static void weaveLists(
      LinkedList<Integer> first,
      LinkedList<Integer> second,
      ArrayList<LinkedList<Integer>> results,
      LinkedList<Integer> prefix) {
    if (first.isEmpty() || second.isEmpty()) {
      LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
      result.addAll(first);
      result.addAll(second);
      results.add(result);
      return;
    }
    System.out.println("first = " + first);
    System.out.println("second = " + second);
    var firstElement = first.removeFirst();
    prefix.addLast(firstElement);
    weaveLists(first, second, results, prefix);
    first.addFirst(firstElement);
    prefix.removeLast();

    var secondElement = second.removeFirst();
    prefix.addLast(secondElement);
    weaveLists(first, second, results, prefix);
    second.addFirst(secondElement);
    prefix.removeLast();
  }
}
