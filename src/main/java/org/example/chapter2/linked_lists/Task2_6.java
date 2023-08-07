package org.example.chapter2.linked_lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.structure.linkedlist.SinglyLinkedList;

public class Task2_6 {

    public static void main(String[] args){
        var list = new SinglyLinkedList();
        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(1);
        list.addLast(0);
        list.print();

        var result = isPalindrome(list.getHead());
        System.out.println(result);

        var list1 = new SinglyLinkedList();
        list1.addLast(0);
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(2);
        list1.addLast(0);
        list1.print();

        result = isPalindrome2(list1.getHead());
        System.out.println(result);
    }

    private static boolean isPalindrome(SinglyLinkedList.Node node) {
        var currentNode = node;
        var reversedList = new SinglyLinkedList();
        var size = 0;
        while(currentNode != null) {
            reversedList.addFirst(currentNode.getData());
            size++;
            currentNode = currentNode.getNext();
        }
        var halfSize = size / 2;
        currentNode = node;
        var currentReversedNode = reversedList.getHead();
        for(int i = 0; i < halfSize; i++) {
            if(currentReversedNode.getData() != currentNode.getData()) {
                return false;
            }
            currentNode = currentNode.getNext();
            currentReversedNode = currentReversedNode.getNext();
        }
        return true;
    }

    public static boolean isPalindrome2(SinglyLinkedList.Node node) {
        var size = getSize(node);
        var result = isPalindromeRecursive(node, size);
        return result.isResult();
    }
    
    private static Result isPalindromeRecursive(SinglyLinkedList.Node head, int size) {
        if(head == null && size <= 0) {
            return new Result(head, true);
        } else if (size == 1) {
            return new Result(head.getNext(), true);
        }

        var res = isPalindromeRecursive(head.getNext(), size - 2);

        if(!res.isResult() || res.getNode() == null) {
            return res;
        }

        res.setResult(head.getData() == res.getNode().getData());
        res.setNode(res.getNode().getNext());

        return res;
    }

    @Data
    @AllArgsConstructor
    public static class Result {
        private SinglyLinkedList.Node node;
        private boolean result;
    }

    private static int getSize(SinglyLinkedList.Node node) {
        var i = 0;
        var currentNode = node;
        while(currentNode != null) {
            i++;
            currentNode = currentNode.getNext();
        }
        return i;
    }

}
