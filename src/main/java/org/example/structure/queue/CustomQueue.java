package org.example.structure.queue;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class CustomQueue<T> {

  private Node<T> first;
  private Node<T> last;

  public void add(T data) {
    var newNode = new Node<T>(data);
    if (last != null) {
      last.next = newNode;
    }
    last = newNode;
    if (first == null) {
      first = last;
    }
  }

  public T peek() {
    return first.getData();
  }

  public T remove() {
    var data = first.getData();
    first = first.getNext();
    if (first == null) {
      last = null;
    }
    return data;
  }

  public void print() {
    if (first == null) {
      System.out.println("[]");
    }
    var next = first;
    while (next != null) {
      System.out.print(next.data + " ");
      next = next.next;
    }
    System.out.println();
  }

  @Setter
  @Getter
  @ToString
  public static class Node<T> {
    private T data;
    @ToString.Exclude private Node<T> next;

    public Node(T data) {
      this.data = data;
    }
  }
}
