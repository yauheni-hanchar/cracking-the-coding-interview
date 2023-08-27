package org.example.structure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class AdjacencyListGraph {

  private ArrayList<Node> nodes = new ArrayList<>();
  private int size;

  public void addVertex(Node node) {
    nodes.add(node);
    size++;
  }

  public void addVertexes(Node... nodes) {
    this.nodes.addAll(List.of(nodes));
    size += nodes.length;
  }

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
    while (!queue1.isEmpty() && !queue2.isEmpty()) {}

    return false;
  }

  public void markUnvisited() {
    nodes.forEach(node -> node.setVisited(false));
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode
  @Builder
  public static class Node {

    private String name;
    private boolean visited;

    @Builder.Default @EqualsAndHashCode.Exclude
    private ArrayList<Node> children = new ArrayList<>();

    public void addAll(Node... nodes) {
      children.addAll(List.of(nodes));
    }
  }
}
