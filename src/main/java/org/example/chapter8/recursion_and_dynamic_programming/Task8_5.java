package org.example.chapter8.recursion_and_dynamic_programming;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Task8_5 {

  public static void main(String[] args) {
    var a = 11;
    var b = 7;
    var result = recursiveMultiply2(a, b, 0);
    System.out.println("result = " + result);
    var result2 = iterativeMultiply2(a, b);
    System.out.println("result2 = " + result2);
  }

  private static int recursiveMultiply(int a, int b) {
    if (b == 1) {
      return a;
    }
    return a + recursiveMultiply(a, b - 1);
  }

  private static int recursiveMultiply2(int a, int b, int result) {
    if (b == 0) {
      return result;
    }
    if ((b & 1) == 1) {
      return recursiveMultiply2(a << 1, b >> 1, result + a);
    }
    return recursiveMultiply2(a << 1, b >> 1, result);
  }

  private static int iterativeMultiply2(int a, int b) {
    var min = min(a, b);
    var max = max(a, b);
    var result = 0;
    while (min != 0) {
      if ((min & 1) == 1) {
        result += max;
      }
      min >>= 1;
      max <<= 1;
    }
    return result;
  }
}
