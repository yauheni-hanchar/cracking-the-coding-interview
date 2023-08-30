package org.example.chapter4.trees_and_graphs;

import java.util.List;
import java.util.stream.IntStream;
import org.example.structure.tree.BinaryTree;
import org.example.structure.tree.BinaryTree.Node;

public class Task4_2 {

  public static void main(String[] args) {
    List<Integer> input = IntStream.range(1, 134217728).boxed().toList();

    var root = buildTree(input, 0, input.size() - 1);
    var tree = new BinaryTree<>(root);
    tree.printBreadthFirst();
  }

  public static Node<Integer> buildTree(List<Integer> input, int from, int to) {
    if (to < from) {
      return null;
    }

    var indexOfMiddle = (to + from) / 2;
    var newNode = Node.of(input.get(indexOfMiddle));
    var newToIndex = indexOfMiddle - 1;
    newNode.setLeft(buildTree(input, from, newToIndex));
    var newFromIndex = indexOfMiddle + 1;
    newNode.setRight(buildTree(input, newFromIndex, to));
    return newNode;
  }
}
