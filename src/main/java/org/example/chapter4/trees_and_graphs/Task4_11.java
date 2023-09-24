package org.example.chapter4.trees_and_graphs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.chapter4.trees_and_graphs.Task4_11.BinaryTree.Node;

import java.util.HashMap;
import java.util.Random;

public class Task4_11 {

  public static void main(String[] args) {
    var tree = new BinaryTree();
    var root = Node.of(5);
    tree.setRoot(root);

    root.insertInOrder(3);
    root.insertInOrder(7);

    root.insertInOrder(1);
    root.insertInOrder(2);
    root.insertInOrder(4);
    root.insertInOrder(6);
    root.insertInOrder(8);
    root.insertInOrder(9);
    root.insertInOrder(10);

    var hashMap = new HashMap<Node, Integer>();
    for (int i = 0; i < 1000000000; i++) {
      var randomNode = tree.getRandomNode();
      if (!hashMap.containsKey(randomNode)) {
        hashMap.put(randomNode, 1);
      } else {
        hashMap.put(randomNode, hashMap.get(randomNode) + 1);
      }
    }
    hashMap.forEach((key, value) -> System.out.println("key = " + key + "; " + "value = " + value));
  }

  @Data
  public static class BinaryTree {

    private Node root;

    public int size() {
      return root == null ? 0 : root.getSize();
    }

    public void insertInOrder(int data) {
      if (root == null) {
        root = new Node(data);
      } else {
        root.insertInOrder(data);
      }
    }

    public Node find(int data) {
      if (root == null) {
        return null;
      }
      return root.find(data);
    }

    public Node getRandomNode() {
      if (root == null) {
        return null;
      }
      var i = new Random().nextInt(size());
      return root.getIthNode(i);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Node {

      private int data;
      @ToString.Exclude @EqualsAndHashCode.Exclude private Node left;
      @ToString.Exclude @EqualsAndHashCode.Exclude private Node right;
      private int size = 0;

      public Node(int data) {
        this.data = data;
        size++;
      }

      public static Node of(int data) {
        return new Node(data);
      }

      public void insertInOrder(int data) {
        if (data <= this.data) {
          if (left == null) {
            left = new Node(data);
          } else {
            left.insertInOrder(data);
          }
        } else {
          if (right == null) {
            right = new Node(data);
          } else {
            right.insertInOrder(data);
          }
        }
        size++;
      }

      public Node find(int data) {
        if (data == this.data) {
          return this;
        } else if (data <= this.data) {
          return left == null ? null : left.find(data);
        } else {
          return right == null ? null : right.find(data);
        }
      }

      public Node getIthNode(int i) {
        int leftSize = left == null ? 0 : left.size;
        if (i < leftSize) {
          return left.getIthNode(i);
        } else if (i == leftSize) {
          return this;
        } else {
          return right.getIthNode(i - (leftSize + 1));
        }
      }
    }
  }
}
