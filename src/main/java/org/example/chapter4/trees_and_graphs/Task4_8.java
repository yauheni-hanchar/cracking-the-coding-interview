package org.example.chapter4.trees_and_graphs;

import java.util.LinkedList;
import lombok.Data;
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

    var node = findCommonAncestor5(root, node17, node5);
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

  public static Node<Integer> findCommonAncestor2(
      Node<Integer> root, Node<Integer> node1, Node<Integer> node2) {
    if (!cover(root, node1) || !cover(root, node2)) {
      return null;
    }
    if (cover(node1, node2)) {
      return node1;
    }
    if (cover(node2, node1)) {
      return node2;
    }

    var sibling = getSibling(node1);
    var parent = node1.getParent();
    while (!cover(sibling, node2)) {
      sibling = getSibling(parent);
      parent = parent.getParent();
    }
    return parent;
  }

  private static boolean cover(Node<Integer> root, Node<Integer> a) {
    if (root == null) {
      return false;
    }
    if (root == a) {
      return true;
    }
    return cover(root.getLeft(), a) || cover(root.getRight(), a);
  }

  private static Node<Integer> getSibling(Node<Integer> root) {
    if (root == null || root.getParent() == null) {
      return null;
    }
    var parent = root.getParent();
    return parent.getLeft() == root ? parent.getRight() : parent.getLeft();
  }

  public static Node<Integer> findCommonAncestor3(
      Node<Integer> root, Node<Integer> node1, Node<Integer> node2) {
    if (node1 == node2) {
      return node1;
    }
    var pathForNode1 = new LinkedList<Node<Integer>>();
    getPathTo(root, node1, pathForNode1);
    System.out.println("pathForNode1 = " + pathForNode1);
    var pathForNode2 = new LinkedList<Node<Integer>>();
    getPathTo(root, node2, pathForNode2);
    System.out.println("pathForNode2 = " + pathForNode2);

    var first = pathForNode1.size() > pathForNode2.size() ? pathForNode1 : pathForNode2;
    var second = pathForNode1.size() < pathForNode2.size() ? pathForNode1 : pathForNode2;

    for (int i = second.size() - 1; i >= 0; i--) {
      if (first.get(i) == second.get(i)) {
        return second.get(i);
      }
    }
    return null;
  }

  private static boolean getPathTo(
      Node<Integer> root, Node<Integer> node, LinkedList<Node<Integer>> path) {
    if (root == null) {
      return false;
    }
    if (root == node) {
      return true;
    }
    path.add(root);
    var leftContains = getPathTo(root.getLeft(), node, path);
    if (leftContains) {
      return true;
    }
    var rightContains = getPathTo(root.getRight(), node, path);
    if (rightContains) {
      return true;
    }
    path.removeLast();
    return false;
  }

  public static Node<Integer> findCommonAncestor4(
      Node<Integer> root, Node<Integer> node1, Node<Integer> node2) {
    if (root == null) {
      return null;
    }
    var result = containsBoth(root, node1, node2, new Result());
    if (result.containsBoth()) {
      var leftResult = containsBoth(root.getLeft(), node1, node2, new Result());
      var rightResult = containsBoth(root.getRight(), node1, node2, new Result());
      if (leftResult.containsOnlyOne() || rightResult.containsOnlyOne()) {
        return root;
      }
      if (leftResult.containsBoth()) {
        return findCommonAncestor4(root.getLeft(), node1, node2);
      }
      if (rightResult.containsBoth()) {
        return findCommonAncestor4(root.getRight(), node1, node2);
      }
    }
    return null;
  }

  public static Result containsBoth(
      Node<Integer> root, Node<Integer> node1, Node<Integer> node2, Result result) {
    if (root == null) {
      return result;
    }
    if (node1 == root) {
      result.setContainsFirst(true);
    }
    if (node2 == root) {
      result.setContainsSecond(true);
    }
    if (result.containsBoth()) {
      return result;
    }
    containsBoth(root.getLeft(), node1, node2, result);
    containsBoth(root.getRight(), node1, node2, result);
    return result;
  }

  public static Result findCommonAncestor5(
      Node<Integer> root, Node<Integer> node1, Node<Integer> node2) {
    var result = new Result();
    if (root == null) {
      return result;
    }
    if (node1 == root) {
      result.setContainsFirst(true);
    }
    if (node2 == root) {
      result.setContainsSecond(true);
    }
    var leftResult = findCommonAncestor5(root.getLeft(), node1, node2);
    if (leftResult.firstCommonAncestor != null) {
      result.setFirstCommonAncestor(leftResult.firstCommonAncestor);
      return result;
    }
    var rightResult = findCommonAncestor5(root.getRight(), node1, node2);
    if (rightResult.firstCommonAncestor != null) {
      result.setFirstCommonAncestor(rightResult.firstCommonAncestor);
      return result;
    }
    if (result.containsFirst || leftResult.containsFirst || rightResult.containsFirst) {
      result.setContainsFirst(true);
    }
    if (result.containsSecond || leftResult.containsSecond || rightResult.containsSecond) {
      result.setContainsSecond(true);
    }
    if (result.containsBoth() && (leftResult.containsOnlyOne() || rightResult.containsOnlyOne())) {
      result.setFirstCommonAncestor(root);
      return result;
    }
    return result;
  }

  @Data
  public static class Result {

    private boolean containsFirst;
    private boolean containsSecond;
    private Node<Integer> firstCommonAncestor;

    public boolean containsBoth() {
      return containsFirst && containsSecond;
    }

    public boolean containsOnlyOne() {
      return containsFirst ^ containsSecond;
    }
  }
}
