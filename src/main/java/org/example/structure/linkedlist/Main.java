package org.example.structure.linkedlist;

public class Main {

    public static void main(String[] args){
        CustomLinkedList list = new CustomLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.print();

        list.delete(1);
        list.delete(3);
        list.print();
    }

}
