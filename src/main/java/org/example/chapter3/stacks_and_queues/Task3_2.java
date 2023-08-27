package org.example.chapter3.stacks_and_queues;

import lombok.Data;
import org.example.structure.stack.CustomStack;

public class Task3_2 {

  public static void main(String[] args) {
    var stackWithMin = new StackWithMin();
    stackWithMin.push(10);
    stackWithMin.push(12);
    stackWithMin.push(16);
    stackWithMin.push(9);
    stackWithMin.push(21);
    stackWithMin.push(30);
    stackWithMin.push(1);
    stackWithMin.push(6);
    stackWithMin.push(7);

    while (!stackWithMin.isEmpty()) {
      stackWithMin.getData().print();
      stackWithMin.getMins().print();
      stackWithMin.pop();
    }
  }

  @Data
  public static class StackWithMin {

    private CustomStack<Integer> data = new CustomStack<>();
    private CustomStack<Integer> mins = new CustomStack<>();

    public void push(Integer element) {
      data.push(element);
      if (mins.isEmpty() || mins.peek() > element) {
        mins.push(element);
      }
    }

    public Integer peek() {
      return data.peek();
    }

    public Integer pop() {
      var current = data.pop();
      if (current.equals(mins.peek())) {
        mins.pop();
      }
      return current;
    }

    public Integer min() {
      return mins.peek();
    }

    public boolean isEmpty() {
      return data.isEmpty();
    }
  }
}
