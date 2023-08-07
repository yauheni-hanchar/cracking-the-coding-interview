package org.example.structure.linkedlist;

public class Main {

    public static void main(String[] args){
        var list = new SinglyLinkedList();
        for(int i = 0; i < 5; i++) {
            var node = new SinglyLinkedList.Node(i, null);
            list.addFirst(node);
        }
        list.print();
    }

}
