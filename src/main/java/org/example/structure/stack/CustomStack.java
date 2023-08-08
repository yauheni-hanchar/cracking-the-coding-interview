package org.example.structure.stack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
public class CustomStack<T> {

    private Node<T> top;

    public void push(T data) {
        var newNode = new Node<T>(data);
        newNode.setNext(top);
        top = newNode;
    }

    public T peek() {
        return top.getData();
    }

    public T pop() {
        if(top == null) {
            throw new IllegalArgumentException();
        }
        var result = top.getData();
        top = top.getNext();
        return result;
    }

    public void print() {
        if(top == null) {
            System.out.println("[]");
        }
        var next = top;
        while(next != null) {
            System.out.print(next.data + " ");
            next = next.next;
        }
        System.out.println();
    }

    @Setter
    @Getter
    @ToString
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class Node<T> {
        private T data;
        @ToString.Exclude
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

}
