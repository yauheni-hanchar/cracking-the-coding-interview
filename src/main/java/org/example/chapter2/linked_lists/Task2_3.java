package org.example.chapter2.linked_lists;

import org.example.structure.linkedlist.SinglyLinkedList;

public class Task2_3 {

    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.print();

        var result = deleteNodeInTheMiddle(list.get(5));
        list.print();
    }

    private static boolean deleteNodeInTheMiddle(SinglyLinkedList.Node node) {
        if(node == null || node.getNext() == null) {
            return false;
        }
        node.setData(node.getNext().getData());
        node.setNext(node.getNext().getNext());
        return true;
    }

}
