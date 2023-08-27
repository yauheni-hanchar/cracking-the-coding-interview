package org.example.chapter3.stacks_and_queues;

import lombok.Data;
import org.example.structure.stack.CustomStack;

public class Task3_4 {

  public static void main(String[] args) {
    var stackQueue = new StackQueue();
    stackQueue.add(1);
    stackQueue.add(2);
    stackQueue.add(3);
    stackQueue.add(4);
    stackQueue.print();
    System.out.println(stackQueue.peek());
    stackQueue.print();
    stackQueue.add(5);
    stackQueue.print();
    System.out.println(stackQueue.remove());
    stackQueue.print();
  }

  @Data
  public static class StackQueue {

    private CustomStack<Integer> oldStack = new CustomStack<>();
    private CustomStack<Integer> newStack = new CustomStack<>();
    private boolean isFirst = true;

    public void add(int data) {
      newStack.push(data);
    }

    public void shift() {
      if (oldStack.isEmpty()) {
        while (!newStack.isEmpty()) {
          oldStack.push(newStack.pop());
        }
      }
    }

    public Integer peek() {
      shift();
      return oldStack.peek();
    }

    public Integer remove() {
      shift();
      return oldStack.pop();
    }

    public void print() {
      oldStack.print();
      newStack.print();
    }
  }
}
