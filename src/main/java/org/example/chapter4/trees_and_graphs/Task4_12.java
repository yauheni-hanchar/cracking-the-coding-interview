package org.example.chapter4.trees_and_graphs;

import org.example.structure.tree.BinaryTree;
import org.example.structure.tree.BinaryTree.Node;

import java.util.HashMap;
import java.util.LinkedList;

public class Task4_12 {

  public static void main(String[] args) {
    var tree = new BinaryTree<Integer>();
    var root = Node.of(-1);
    var node1 = Node.of(3);
    var node2 = Node.of(1);
    var node3 = Node.of(-9);
    var node4 = Node.of(3);
    var node5 = Node.of(2);
    var node6 = Node.of(4);
    var node7 = Node.of(-5);
    var node8 = Node.of(7);
    var node9 = Node.of(0);
    var node10 = Node.of(-2);
    var node11 = Node.of(-3);
    var node12 = Node.of(11);
    var node13 = Node.of(17);

    /*root.setLeft(node1);
    root.setRight(node8);

    node1.setLeft(node2);
    node1.setRight(node5);

    node2.setLeft(node3);
    node2.setRight(node4);

    node5.setLeft(node6);
    node5.setRight(node7);

    node8.setLeft(node9);
    node8.setRight(node11);

    node9.setRight(node10);

    node11.setLeft(node12);
    node11.setRight(node13);*/

    root.setLeft(node1);
    node1.setLeft(node2);
    node2.setRight(node4);
    node4.setRight(node13);

    //    var result = countAllPaths(root, 4);
    var result = countPathsWithSum(root, 4);
    System.out.println(result);
  }

  public static int countAllPaths(Node<Integer> root, int number) {
    if (root == null) {
      return 0;
    }
    var newAllPathsNumber = countPathsFromRoot(root, number, 0);
    newAllPathsNumber += countAllPaths(root.getLeft(), number);
    newAllPathsNumber += countAllPaths(root.getRight(), number);
    return newAllPathsNumber;
  }

  private static int countPathsFromRoot(Node<Integer> root, int number, int sum) {
    if (root == null) {
      return 0;
    }
    var newPathsNumber = 0;
    var newSum = sum + root.getData();
    if (newSum == number) {
      newPathsNumber++;
    }
    newPathsNumber += countPathsFromRoot(root.getLeft(), number, newSum);
    newPathsNumber += countPathsFromRoot(root.getRight(), number, newSum);
    return newPathsNumber;
  }

  public static int countPathsWithSum(Node<Integer> root, int targetSum) {
    return countPathsWithSum(root, targetSum, 0, new HashMap<>());
  }

  private static int countPathsWithSum(
      Node<Integer> root, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
    if (root == null) {
      return 0;
    }
    System.out.println("-----");
    System.out.println("runningSumBefore = " + runningSum);
    runningSum += root.getData();
    System.out.println("runningSumAfter = " + runningSum);
    var sum = runningSum - targetSum;
    System.out.println("sum = " + sum);
    int totalPaths = pathCount.getOrDefault(sum, 0);
    System.out.println("totalPaths = " + totalPaths);
    if (runningSum == targetSum) {
      totalPaths++;
    }

    incrementHashTable(pathCount, runningSum, 1);
    System.out.println("pathCountBefore = " + pathCount);
    totalPaths += countPathsWithSum(root.getLeft(), targetSum, runningSum, pathCount);
    totalPaths += countPathsWithSum(root.getRight(), targetSum, runningSum, pathCount);
    incrementHashTable(pathCount, runningSum, -1);
    return totalPaths;
  }

  private static void incrementHashTable(HashMap<Integer, Integer> pathCount, int key, int delta) {
    var newCount = pathCount.getOrDefault(key, 0) + delta;
    if (newCount == 0) {
      pathCount.remove(key);
    } else {
      pathCount.put(key, newCount);
    }
  }
}
