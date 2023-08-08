package org.example.chapter2.linked_lists;

import org.example.structure.linkedlist.SinglyLinkedList;

public class Task2_7 {

    public static void main(String[] args){
        var list1 = new SinglyLinkedList();
        list1.addLast(0);
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.print();

        var list2 = new SinglyLinkedList();
        list2.addLast(9);
        list2.addLast(8);
        list2.addLast(list1.get(3));
        list2.print();

        var result = findIntersection(list1, list2);
        if (result == null) {
            System.out.println("null");
        } else {
            result.print();
        }
    }

    private static SinglyLinkedList findIntersection(SinglyLinkedList list1, SinglyLinkedList list2) {
        if(list1.getTail() != list2.getTail()) {
            return null;
        }
        var list1Size = list1.size();
        var list2Size = list2.size();

        var shorter = list1Size < list2Size ? list1 : list2;
        var longer = list2Size >= list1Size ? list2 : list1;

        var longerCurrent = longer.get(Math.abs(list2Size - list1Size));
        var shorterCurrent = shorter.getHead();

        while(longerCurrent != shorterCurrent) {
            longerCurrent = longerCurrent.getNext();
            shorterCurrent = shorterCurrent.getNext();
        }

        return new SinglyLinkedList(longerCurrent);
    }

}
