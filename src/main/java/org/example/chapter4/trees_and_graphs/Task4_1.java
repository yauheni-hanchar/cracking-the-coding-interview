package org.example.chapter4.trees_and_graphs;

import java.util.LinkedList;
import org.example.structure.graph.AdjacencyListGraph;
import org.example.structure.graph.AdjacencyListGraph.Node;

public class Task4_1 {

  public static void main(String[] args) {
    var graph = new AdjacencyListGraph();
    var nodeA = Node.builder().name("A").build();
    var nodeB = Node.builder().name("B").build();
    var nodeC = Node.builder().name("C").build();
    var nodeD = Node.builder().name("D").build();
    var nodeE = Node.builder().name("E").build();
    var nodeF = Node.builder().name("F").build();
    var nodeS = Node.builder().name("S").build();
    nodeA.addAll(nodeD, nodeE);
    nodeB.addAll(nodeA);
    nodeC.addAll(nodeD);
    nodeD.addAll(nodeE, nodeF);
    nodeE.addAll(nodeB, nodeF);
    nodeS.addAll(nodeB, nodeC);
    graph.addVertexes(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeS);

    //        depthFirstSearch(nodeS);
    //        graph.markUnvisited();
    //
    //        System.out.println();
    //
    //        breadthFirstSearch(nodeS);
    //        graph.markUnvisited();

    var result = graph.bidirectionalSearch(nodeB, nodeD);
    System.out.println(result);
  }

  public static void depthFirstSearch(Node root) {
    if (root == null) {
      return;
    }
    System.out.println(root.getName());
    root.setVisited(true);
    for (var child : root.getChildren()) {
      if (!child.isVisited()) {
        depthFirstSearch(child);
      }
    }
  }

  public static void breadthFirstSearch(Node root) {
    if (root == null) {
      return;
    }
    var queue = new LinkedList<Node>();
    queue.add(root);
    while (!queue.isEmpty()) {
      var firstNode = queue.remove();
      if (!firstNode.isVisited()) {
        System.out.println(firstNode.getName());
        firstNode.setVisited(true);
        for (var child : firstNode.getChildren()) {
          if (!child.isVisited()) {
            queue.add(child);
          }
        }
      }
    }
  }

  public static boolean breadthFirstSearch(Node root, Node nodeToFind) {
    if (root == null) {
      return false;
    }
    var queue = new LinkedList<Node>();
    queue.add(root);
    while (!queue.isEmpty()) {
      var firstNode = queue.remove();
      if (!firstNode.isVisited()) {
        if (firstNode.getName().equals(nodeToFind.getName())) {
          return true;
        }
        firstNode.setVisited(true);
        for (var child : firstNode.getChildren()) {
          if (!child.isVisited()) {
            queue.add(child);
          }
        }
      }
    }
    return false;
  }
}
