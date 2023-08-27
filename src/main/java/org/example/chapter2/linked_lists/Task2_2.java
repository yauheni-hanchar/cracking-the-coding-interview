package org.example.chapter2.linked_lists;

import org.example.structure.linkedlist.SinglyLinkedList;

public class Task2_2 {

  public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    list.addLast(5);
    list.addLast(6);
    list.addLast(7);
    list.addLast(8);
    list.print();

    var result = getKthToLast(list, 5);
    result.print();
    result = getKthToLast(list, 2);
    result.print();
    result = getKthToLast(list, 1);
    result.print();
    result = getKthToLast(list, 8);
    result.print();
  }

  private static SinglyLinkedList getKthToLast(SinglyLinkedList list, int k) {
    var p1 = list.getHead();
    var p2 = list.getHead();
    for (int i = 1; i < k; i++) {
      if (p1 == null) {
        throw new IllegalArgumentException();
      }
      p1 = p1.getNext();
    }

    while (p1.hasNext()) {
      p1 = p1.getNext();
      p2 = p2.getNext();
    }

    return new SinglyLinkedList(p2);
  }
}
