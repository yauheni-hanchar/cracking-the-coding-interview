package org.example.structure.linkedlist;

public class Main {

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
        System.out.println(list1.getTail().hashCode());
        System.out.println(list2.getTail().hashCode());
        System.out.println(list1.getTail() == list2.getTail());
    }

}
