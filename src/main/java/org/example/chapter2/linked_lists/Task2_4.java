package org.example.chapter2.linked_lists;

import org.example.structure.linkedlist.SinglyLinkedList;

public class Task2_4 {

    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(3);
        list.addLast(5);
        list.addLast(8);
        list.addLast(5);
        list.addLast(10);
        list.addLast(2);
        list.addLast(1);
        list.addLast(7);
        list.addLast(3);
        list.print();

        partition(list.getHead(), 5);
        list.print();
    }

    private static void partition(SinglyLinkedList.Node node, int x) {
        SinglyLinkedList.Node greaterOrEqual = null;
        var currentNode = node;
        while(currentNode != null) {
            if(currentNode.getData() >= x && greaterOrEqual == null) {
                greaterOrEqual = currentNode;
            } else if(greaterOrEqual != null && currentNode.getData() < x) {
                var buf = currentNode.getData();
                currentNode.setData(greaterOrEqual.getData());
                greaterOrEqual.setData(buf);
                greaterOrEqual = greaterOrEqual.getNext();
            }
            currentNode = currentNode.getNext();
        }
    }

}
