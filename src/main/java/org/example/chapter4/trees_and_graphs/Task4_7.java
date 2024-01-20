package org.example.chapter4.trees_and_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class Task4_7 {

  public static void main(String[] args) {
    String[] projects = {"A", "B", "C", "E", "F", "D", "G"};
    String[][] dependencies = {
      {"F", "C"}, {"F", "B"}, {"C", "A"}, {"B", "A"}, {"B", "E"}, {"A", "E"}, {"F", "A"}, {"D", "G"}
    };
    var result = findBuildOrder(projects, dependencies);
    System.out.println(Arrays.toString(result));
  }

  public static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
    var graph = createGraph(projects, dependencies);
    return orderProjects(graph);
  }

  public static Graph createGraph(String[] projects, String[][] dependencies) {
    var graph = new Graph();
    for (var project : projects) {
      graph.getOrCreateNode(project);
    }
    for (var dependency : dependencies) {
      graph.addEdge(dependency[0], dependency[1]);
    }
    return graph;
  }

  public static Project[] orderProjects(Graph graph) {
    var finalOrder = new Project[graph.getNodes().size()];
    var nodes = graph.getNodes();

    var endOfOrder = addNonDependent(nodes, finalOrder, 0);

    int toBeProcessed = 0;
    while (toBeProcessed < finalOrder.length - 1) {
      System.out.println("----------");
      System.out.println("finalOrder = " + Arrays.toString(finalOrder));
      System.out.println("toBeProcessed = " + toBeProcessed);
      System.out.println("offset = " + endOfOrder);
      var current = finalOrder[toBeProcessed];
      System.out.println("current = " + current);
      if (current == null) {
        return null;
      }
      System.out.println("current.children = " + current.getChildren());

      for (var child : current.getChildren()) {
        child.decreaseDependencies();
      }

      endOfOrder = addNonDependent(current.getChildren(), finalOrder, endOfOrder);
      toBeProcessed++;
    }

    return finalOrder;
  }

  private static int addNonDependent(ArrayList<Project> nodes, Project[] order, int offset) {
    for (var node : nodes) {
      if (node.getDependencies() == 0) {
        order[offset] = node;
        offset++;
      }
    }
    return offset;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Graph {
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String projectName) {
      if (!map.containsKey(projectName)) {
        var newProject = new Project(projectName);
        nodes.add(newProject);
        map.put(projectName, newProject);
      }
      return map.get(projectName);
    }

    public void addEdge(String startName, String secondName) {
      var startNode = getOrCreateNode(startName);
      var endNode = getOrCreateNode(secondName);
      startNode.addNeighbour(endNode);
    }
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @ToString
  public static class Project {

    private String name;
    @ToString.Exclude private ArrayList<Project> children = new ArrayList<>();
    @ToString.Exclude private HashMap<String, Project> map = new HashMap<>();
    @ToString.Exclude private int dependencies = 0;

    public Project(String name) {
      this.name = name;
    }

    public void addNeighbour(Project neighbour) {
      if (!map.containsKey(neighbour.getName())) {
        children.add(neighbour);
        map.put(neighbour.getName(), neighbour);
        neighbour.increaseDependencies();
      }
    }

    public void increaseDependencies() {
      dependencies++;
    }

    public void decreaseDependencies() {
      dependencies--;
    }
  }
}
