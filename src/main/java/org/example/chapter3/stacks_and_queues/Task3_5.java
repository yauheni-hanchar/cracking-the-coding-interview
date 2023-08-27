package org.example.chapter3.stacks_and_queues;

import org.example.structure.stack.CustomStack;

public class Task3_5 {

  public static void main(String[] args) {
    CustomStack<Integer> input = new CustomStack<>();
    //        input.push(8);
    //        input.push(11);
    //        input.push(5);
    //        input.push(4);
    //        input.push(2);
    //        input.push(7);
    input.push(6);
    input.push(5);
    input.push(6);
    input.push(3);
    input.push(4);
    input.push(4);
    input.push(1);
    input.push(2);
    input.push(2);
    input.push(3);
    input.push(3);
    input.print();

    var result = sort(input);
    result.print();
  }

  public static CustomStack<Integer> sort(CustomStack<Integer> input) {
    CustomStack<Integer> result = new CustomStack<>();

    while (!input.isEmpty()) {
      var elementToSort = input.pop();
      sortElement(input, result, elementToSort);
    }

    return result;
  }

  private static void sortElement(
      CustomStack<Integer> input, CustomStack<Integer> result, int elementToSort) {
    if (result.isEmpty() || elementToSort <= result.peek()) {
      result.push(elementToSort);
      return;
    }
    input.push(result.pop());
    sortElement(input, result, elementToSort);
  }

  public static CustomStack<Integer> sortIterative(CustomStack<Integer> input) {
    CustomStack<Integer> result = new CustomStack<>();
    while (!input.isEmpty()) {
      var elementToSort = input.pop();
      while (!result.isEmpty() && result.peek() < elementToSort) {
        input.push(result.pop());
      }
      result.push(elementToSort);
    }
    return result;
  }
}
