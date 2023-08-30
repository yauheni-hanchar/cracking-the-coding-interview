package org.example.structure.tree;

import java.util.LinkedList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BinaryTree<T> {

  private Node<T> root;

  public void printBreadthFirst() {
    if (root == null) {
      System.out.println("Empty tree");
    }
    LinkedList<LinkedList<Node<T>>> levels = new LinkedList<>();
    LinkedList<Node<T>> level = new LinkedList<>();

    level.push(root);
    levels.push(level);

    System.out.println(root.data);

    boolean isEnd = false;
    while (!isEnd) {
      var lastLevel = levels.peekLast();
      var nextLevel = new LinkedList<Node<T>>();
      for (var currentNode : lastLevel) {
        if (currentNode.getLeft() != null) {
          nextLevel.add(currentNode.getLeft());
          System.out.print(currentNode.getLeft().getData() + " ");
        }
        if (currentNode.getRight() != null) {
          nextLevel.add(currentNode.getRight());
          System.out.print(currentNode.getRight().getData() + " ");
        }
      }
      if (nextLevel.isEmpty()) {
        isEnd = true;
      } else {
        levels.add(nextLevel);
      }
      System.out.println();
    }
  }

  @Data
  @RequiredArgsConstructor(staticName = "of")
  public static class Node<T> {

    @NonNull private T data;

    @EqualsAndHashCode.Exclude @ToString.Exclude private Node<T> left;

    @EqualsAndHashCode.Exclude @ToString.Exclude private Node<T> right;

    public void setChildren(Node<T> left, Node<T> right) {
      this.left = left;
      this.right = right;
    }
  }
}
