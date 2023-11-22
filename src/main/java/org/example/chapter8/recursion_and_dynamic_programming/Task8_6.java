package org.example.chapter8.recursion_and_dynamic_programming;

import java.util.Stack;

public class Task8_6 {

  public static void main(String[] args) {
    var n = 30;
    var first = new Stack<Integer>();
    for(int i = n; i >0; i--) {
      first.push(i);
    }
    var second = new Stack<Integer>();
    var third = new Stack<Integer>();
    System.out.println("first = " + first);
    System.out.println("second = " + second);
    System.out.println("third = " + third);
    moveTowers(n, first, second, third);
    System.out.println("first = " + first);
    System.out.println("second = " + second);
    System.out.println("third = " + third);
  }

  private static void moveTowers(int n, Stack<Integer> source, Stack<Integer> buffer, Stack<Integer> target) {
    if(n == 1) {
      var top = source.pop();
      target.push(top);
      return;
    }
    moveTowers(n - 1, source, target, buffer);

    var top = source.pop();
    target.push(top);

    moveTowers(n - 1, buffer, source, target);
  }
}
