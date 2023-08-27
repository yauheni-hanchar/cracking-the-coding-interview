package org.example.chapter3.stacks_and_queues;

import java.util.ArrayList;
import lombok.Data;
import org.example.structure.stack.CustomStack;

public class Task3_3 {

  public static void main(String[] args) {}

  @Data
  public class SetOfStack {

    private ArrayList<CustomStack<Integer>> stacks = new ArrayList<>();
    private int threshold = 10;
    private int lastStack = 0;

    public SetOfStack(int threshold) {
      this.threshold = threshold;
    }

    public void push(Integer element) {
      if (lastStack == 0 && stacks.get(0) == null) {
        CustomStack<Integer> nextStack = new CustomStack<>();
        nextStack.push(element);
        stacks.add(nextStack);
      } else if (stacks.get(lastStack).getSize() == threshold) {
        CustomStack<Integer> nextStack = new CustomStack<>();
        nextStack.push(element);
        stacks.add(nextStack);
        lastStack++;
      } else {
        stacks.get(lastStack).push(element);
      }
    }

    public Integer pop() {
      if (lastStack == 0 || stacks.get(0) == null || stacks.get(0).peek() == null) {
        return null;
      }
      if (stacks.get(lastStack).getSize() == 1) {
        var result = stacks.get(lastStack).pop();
        stacks.remove(lastStack);
        lastStack--;
        return result;
      }
      return stacks.get(lastStack).pop();
    }
  }
}
