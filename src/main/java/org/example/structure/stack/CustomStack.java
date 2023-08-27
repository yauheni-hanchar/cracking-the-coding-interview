package org.example.structure.stack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
public class CustomStack<T> {

  private Node<T> top;
  private int size;

  public void push(T data) {
    if (top == null) {
      top = new Node<>(data);
    } else {
      var newNode = new Node<T>(data);
      newNode.setNext(top);
      top = newNode;
    }
    size++;
  }

  public T peek() {
    return top == null ? null : top.getData();
  }

  public T pop() {
    if (top != null) {
      var result = top.getData();
      top = top.getNext();
      size--;
      return result;
    }
    return null;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public void clear() {
    top = null;
  }

  public void print() {
    if (top == null) {
      System.out.println("[]");
      return;
    }
    var next = top;
    System.out.print("[");
    while (next != null) {
      System.out.print(next.data + " ");
      next = next.next;
    }
    System.out.print("]");
    System.out.println();
  }

  @Setter
  @Getter
  @ToString
  @AllArgsConstructor
  @RequiredArgsConstructor
  public static class Node<T> {
    private T data;
    @ToString.Exclude private Node<T> next;

    public Node(T data) {
      this.data = data;
    }
  }
}
