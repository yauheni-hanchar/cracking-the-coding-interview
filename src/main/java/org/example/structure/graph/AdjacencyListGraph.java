package org.example.structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
public class AdjacencyListGraph {

  private ArrayList<Node> nodes = new ArrayList<>();
  private int size;

  public void addVertex(Node node) {
    nodes.add(node);
    size++;
  }

  public void addEdge(Node a, Node b) {
    nodes.get(nodes.indexOf(a)).addAll(b);
    nodes.get(nodes.indexOf(b)).addAll(a);
  }

  public void addVertexes(Node... nodes) {
    this.nodes.addAll(List.of(nodes));
    size += nodes.length;
  }

  /**
   * Finds the shortest or shortest + 1 path between nodes
   *
   * @param root1
   * @param root2
   * @return
   */
  public boolean bidirectionalSearch(Node root1, Node root2) {
    if (root1 == null || root2 == null) {
      return false;
    }
    var queue1 = new LinkedList<Node>();
    queue1.add(root1);
    var queue2 = new LinkedList<Node>();
    queue2.add(root2);

    boolean[] visited1 = new boolean[size];
    visited1[nodes.indexOf(root1)] = true;
    boolean[] visited2 = new boolean[size];
    visited2[nodes.indexOf(root2)] = true;
    int[] parents1 = new int[size];
    Arrays.fill(parents1, -999);
    int[] parents2 = new int[size];
    Arrays.fill(parents2, -999);

    parents1[nodes.indexOf(root1)] = -1;
    parents2[nodes.indexOf(root2)] = -1;

    while (!queue1.isEmpty() && !queue2.isEmpty()) {
      bfsStep(queue1, visited1, parents1);
      var intersectNode = getIntersection(visited1, visited2);

      if (intersectNode == -1) {
        bfsStep(queue2, visited2, parents2);
        intersectNode = getIntersection(visited1, visited2);
      }

      if (intersectNode != -1) {
        printPath(root1, root2, intersectNode, parents1, parents2);
        return true;
      }
    }

    return false;
  }

  private void printPath(
      Node root1, Node root2, int intersectNode, int[] parents1, int[] parents2) {
    LinkedList<Node> path = new LinkedList<>();
    path.add(nodes.get(intersectNode));

    var i = parents1[intersectNode];
    var startParent1 = nodes.get(i);
    while (!startParent1.equals(root1)) {
      path.push(startParent1);
      i = parents1[i];
      startParent1 = nodes.get(i);
    }
    path.push(root1);

    var j = parents2[intersectNode];
    var startParent2 = nodes.get(j);
    while (!startParent2.equals(root2)) {
      path.add(startParent2);
      j = parents2[j];
      startParent2 = nodes.get(j);
    }
    path.add(root2);

    path.stream().map(Node::getName).forEach(name -> System.out.print(name + " "));
    System.out.println();
  }

  private void bfsStep(LinkedList<Node> queue, boolean[] visited, int[] parents) {
    var parent = queue.poll();
    if (parent == null) {
      return;
    }
    var indexOfParent = nodes.indexOf(parent);
    for (var child : parent.getChildren()) {
      var indexOfChild = nodes.indexOf(child);
      if (!visited[indexOfChild]) {
        queue.add(child);
        visited[indexOfChild] = true;
        parents[indexOfChild] = indexOfParent;
      }
    }
  }

  private int getIntersection(boolean[] visited1, boolean[] visited2) {
    for (int i = 0; i < visited1.length; i++) {
      if (visited1[i] && visited1[i] == visited2[i]) {
        return i;
      }
    }
    return -1;
  }

  public void markUnvisited() {
    nodes.forEach(node -> node.setVisited(false));
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode
  @ToString
  @Builder
  public static class Node {

    private String name;
    private boolean visited;

    @Builder.Default @EqualsAndHashCode.Exclude @ToString.Exclude
    private ArrayList<Node> children = new ArrayList<>();

    public void addAll(Node... nodes) {
      children.addAll(List.of(nodes));
    }
  }
}
