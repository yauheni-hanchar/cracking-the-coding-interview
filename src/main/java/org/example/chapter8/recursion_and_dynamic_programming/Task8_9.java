package org.example.chapter8.recursion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class Task8_9 {

  public static void main(String[] args) {
    var n = 3;
    var result = getParentheses(n);
    System.out.println("result.size() = " + result.size());
    result.forEach(System.out::println);
  }

  private static List<String> getParentheses(int n) {
    var result = new ArrayList<String>();
    getParentheses(n, "", n * 2, 0, result);
    return result;
  }

  private static void getParentheses(
      int n, String prefix, int remaining, int openedMinusClosed, List<String> result) {
    if (remaining == 0) {
      result.add(prefix);
      return;
    }

    if (openedMinusClosed < n && openedMinusClosed < remaining) {
      getParentheses(n, prefix + "(", remaining - 1, openedMinusClosed + 1, result);
    }
    if (openedMinusClosed > 0) {
      getParentheses(n, prefix + ")", remaining - 1, openedMinusClosed - 1, result);
    }
  }
}
