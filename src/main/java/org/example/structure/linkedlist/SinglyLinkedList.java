package org.example.structure.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
public class SinglyLinkedList {

  private Node head;
  private Node tail;

  public SinglyLinkedList(Node head) {
    this.head = head;
  }

  public void addFirst(Node node) {
    if (head == null) {
      head = node;
    } else if (tail == null) {
      tail = head;
      head = node;
      node.setNext(tail);
    } else {
      node.setNext(head);
      head = node;
    }
  }

  public void addFirst(int data) {
    if (head == null) {
      head = new Node(data);
    } else if (tail == null) {
      tail = head;
      head = new Node(data, tail);
    } else {
      head = new Node(data, head);
    }
  }

  public void addLast(int data) {
    if (head == null) {
      head = new Node(data);
    } else if (tail == null) {
      tail = new Node(data);
      head.next = tail;
    } else {
      var current = new Node(data);
      tail.next = current;
      tail = current;
    }
  }

  public void addLast(Node newNode) {
    if (newNode == null) {
      return;
    }
    if (newNode.size() == 1) {
      if (head == null) {
        head = newNode;
      } else if (tail == null) {
        tail = newNode;
        head.next = tail;
      } else {
        tail.next = newNode;
        tail = newNode;
      }
    } else {
      if (head == null) {
        head = newNode;
      } else {
        tail.next = newNode;
      }
      tail = newNode.getTail();
    }
  }

  public Node get(int index) {
    var i = 0;
    var current = head;
    while (i != index) {
      current = current.next;
      i++;
    }
    return current;
  }

  public int size() {
    var current = head;
    var size = 0;
    while (current != null) {
      size++;
      current = current.next;
    }
    return size;
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

  @Getter
  @Setter
  @ToString
  @RequiredArgsConstructor
  @AllArgsConstructor
  public static class Node {

    private int data;
    @ToString.Exclude private Node next;

    public Node(int data) {
      this.data = data;
    }

    public boolean hasNext() {
      return next != null;
    }

    public int size() {
      var size = 0;
      var current = this;
      while (current != null) {
        size++;
        current = current.next;
      }
      return size;
    }

    public Node getTail() {
      var current = this;
      while (current.hasNext()) {
        current = current.next;
      }
      return current;
    }
  }
}
