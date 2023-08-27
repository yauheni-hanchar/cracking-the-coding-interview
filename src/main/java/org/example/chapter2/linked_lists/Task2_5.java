package org.example.chapter2.linked_lists;

import org.example.structure.linkedlist.SinglyLinkedList;

public class Task2_5 {

  public static void main(String[] args) {
    SinglyLinkedList reversedList1 = new SinglyLinkedList();
    reversedList1.addLast(7);
    reversedList1.addLast(1);
    reversedList1.addLast(6);
    reversedList1.print();

    SinglyLinkedList reversedList2 = new SinglyLinkedList();
    reversedList2.addLast(5);
    reversedList2.addLast(9);
    reversedList2.addLast(8);
    reversedList2.addLast(9);
    reversedList2.addLast(2);
    reversedList2.print();

    var result = sumReversedLists(reversedList1.getHead(), reversedList2.getHead());
    result.print();

    SinglyLinkedList list1 = new SinglyLinkedList();
    list1.addLast(6);
    list1.addLast(1);
    list1.addLast(7);
    list1.print();

    SinglyLinkedList list2 = new SinglyLinkedList();
    list2.addLast(2);
    list2.addLast(9);
    list2.addLast(5);
    list2.print();

    result = sumLists(list1.getHead(), list2.getHead());
    result.print();
  }

  private static SinglyLinkedList sumReversedLists(
      SinglyLinkedList.Node node1, SinglyLinkedList.Node node2) {
    var result = new SinglyLinkedList();
    int nextNodeAddition = 0;
    var current1 = node1;
    var current2 = node2;
    while (current1 != null || current2 != null) {
      var currentDataSum = 0;
      if (current1 != null) {
        currentDataSum += current1.getData();
      }
      if (current2 != null) {
        currentDataSum += current2.getData();
      }
      currentDataSum += nextNodeAddition;
      var currentRadix = currentDataSum % 10;
      result.addLast(currentRadix);
      nextNodeAddition = currentDataSum / 10;

      if (current1 != null) {
        current1 = current1.getNext();
      }
      if (current2 != null) {
        current2 = current2.getNext();
      }
    }

    return result;
  }

  public static SinglyLinkedList sumLists(
      SinglyLinkedList.Node node1, SinglyLinkedList.Node node2) {
    var result = new SinglyLinkedList();
    var current1 = node1;
    var current2 = node2;
    SinglyLinkedList.Node prev = null;

    while (current1 != null || current2 != null) {
      var currentDataSum = 0;
      if (current1 != null) {
        currentDataSum += current1.getData();
      }
      if (current2 != null) {
        currentDataSum += current2.getData();
      }
      var currentRadix = currentDataSum % 10;
      var newNode = new SinglyLinkedList.Node(currentRadix);
      var prevNodeAddition = currentDataSum / 10;
      if (prev == null && currentDataSum > 9) {
        result.addFirst(prevNodeAddition);
      } else if (prev != null && currentDataSum > 9) {
        prev.setData(prev.getData() + prevNodeAddition);
      }
      result.addLast(newNode);
      prev = newNode;

      if (current1 != null) {
        current1 = current1.getNext();
      }
      if (current2 != null) {
        current2 = current2.getNext();
      }
    }
    return result;
  }
}
