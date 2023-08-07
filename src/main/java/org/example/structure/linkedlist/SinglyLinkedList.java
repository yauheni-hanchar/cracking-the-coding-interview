package org.example.structure.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class SinglyLinkedList {

    private Node head;
    private Node tail;

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    public void addFirst(Node node) {
        if(head == null) {
            head = node;
        } else if(tail == null){
            tail = head;
            head = node;
            node.setNext(tail);
        } else {
            node.setNext(head);
            head = node;
        }
    }

    public void addFirst(int data) {
        if(head == null) {
            head = new Node(data);
        } else if (tail == null) {
            tail = head;
            head = new Node(data, tail);
        } else {
            head = new Node(data,head);
        }
    }

    public void addLast(int data) {
        if(head == null) {
            head = new Node(data);
        } else if (tail == null) {
            tail = new Node(data);
            head.next = tail;
        } else {
            var current = new Node(data);
            tail.next = current;
            tail = current;
        }
    }

    public void addLast(Node newNode) {
        if(head == null) {
            head = newNode;
        } else if (tail == null) {
            tail = newNode;
            head.next = tail;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Node get(int index) {
        var i = 0;
        var current = head;
        while(i != index) {
            current = current.next;
            i++;
        }
        return current;
    }

    public void print() {
        if(head == null) {
            System.out.println("[]");
        }
        var next = head;
        while(next != null) {
            System.out.print(next.data + " ");
            next = next.next;
        }
        System.out.println();
    }

    @Data
    @AllArgsConstructor
    public static class Node {

        private int data;
        @ToString.Exclude
        @EqualsAndHashCode.Exclude
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public boolean hasNext() {
            return next != null;
        }

    }

}
