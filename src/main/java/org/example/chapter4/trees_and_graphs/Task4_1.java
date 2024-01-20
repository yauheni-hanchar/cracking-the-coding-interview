package org.example.chapter4.trees_and_graphs;

import java.util.LinkedList;
import org.example.structure.graph.AdjacencyListGraph;
import org.example.structure.graph.AdjacencyListGraph.Node;

public class Task4_1 {

  public static void main(String[] args) {
    //    taskTest();

    bidirectionalSearchTest();
  }

  public static void bidirectionalSearchTest() {
    var graph = new AdjacencyListGraph();
    var nodeA = Node.builder().name("A").build();
    var nodeB = Node.builder().name("B").build();
    var nodeC = Node.builder().name("C").build();
    var nodeD = Node.builder().name("D").build();
    var nodeE = Node.builder().name("E").build();
    var nodeF = Node.builder().name("F").build();
    var nodeG = Node.builder().name("G").build();
    var nodeH = Node.builder().name("H").build();
    var nodeI = Node.builder().name("I").build();
    var nodeJ = Node.builder().name("J").build();
    var nodeK = Node.builder().name("K").build();
    var nodeL = Node.builder().name("L").build();
    var nodeM = Node.builder().name("M").build();
    graph.addVertexes(
        nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeH, nodeI, nodeJ, nodeK, nodeL, nodeM);

    graph.addEdge(nodeA, nodeM);
    graph.addEdge(nodeA, nodeB);
    graph.addEdge(nodeA, nodeD);
    graph.addEdge(nodeB, nodeD);
    graph.addEdge(nodeA, nodeF);
    graph.addEdge(nodeM, nodeL);
    graph.addEdge(nodeL, nodeK);
    graph.addEdge(nodeK, nodeC);
    graph.addEdge(nodeF, nodeG);
    graph.addEdge(nodeG, nodeH);
    graph.addEdge(nodeH, nodeI);
    graph.addEdge(nodeI, nodeJ);
    graph.addEdge(nodeJ, nodeC);
    //    graph.addEdge(nodeB, nodeC);
    graph.addEdge(nodeB, nodeE);
    graph.addEdge(nodeC, nodeE);

    var result = graph.bidirectionalSearch(nodeA, nodeC);
    System.out.println(result);
  }

  public static void taskTest() {
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

    depthFirstSearch(nodeS);
    graph.markUnvisited();

    System.out.println();

    breadthFirstSearch(nodeS);
    graph.markUnvisited();
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
