package org.example.structure.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoublyLinkedList {

  private Node head;
  private Node tail;

  public void addLast(int data) {
    if (head == null) {
      head = new Node(data, null, null);
    } else if (tail == null) {
      tail = new Node(data, head, null);
      head.next = tail;
    } else {
      var current = new Node(data, tail, null);
      tail.next = current;
      tail = current;
    }
  }

  public void delete(int data) {
    if (head == null) {
      return;
    }
    var next = head;
    while (next != null) {
      if (next.data == data) {
        unlink(next);
      }
      next = next.next;
    }
  }

  private void unlink(Node node) {
    var next = node.next;
    var previous = node.previous;
    if (previous == null) {
      head = next;
    } else {
      previous.next = next;
      node.previous = null;
    }

    if (next == null) {
      tail = previous;
    } else {
      next.previous = previous;
      node.next = null;
    }
  }

  public void print() {
    if (head == null) {
      System.out.println("[]");
    }
    var next = head;
    while (next != null) {
      System.out.print(next.data + " ");
      next = next.next;
    }
    System.out.println();
  }

  @Data
  @AllArgsConstructor
  public static class Node {
    private int data;
    private Node previous;
    private Node next;
  }
}
