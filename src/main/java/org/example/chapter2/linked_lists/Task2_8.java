package org.example.chapter2.linked_lists;

import org.example.structure.linkedlist.SinglyLinkedList;

public class Task2_8 {

  public static void main(String[] args) {
    var list = new SinglyLinkedList();
    list.addLast(0);
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    list.addLast(5);
    list.addLast(6);
    list.addLast(7);
    list.addLast(8);
    list.addLast(9);
    list.addLast(10);

    list.getTail().setNext(list.get(3));

    findIntersection(list);
  }

  private static SinglyLinkedList.Node findIntersection(SinglyLinkedList list) {
    var fast = list.getHead();
    var slow = list.getHead();

    while (fast != null && slow != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
      if (slow == fast) {
        break;
      }
    }

    slow = list.getHead();
    while (fast != null && slow != null) {
      slow = slow.getNext();
      fast = fast.getNext();
      if (slow == fast) {
        break;
      }
    }

    return slow;
  }
}
