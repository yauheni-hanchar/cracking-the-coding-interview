package org.example.chapter8.recursion_and_dynamic_programming;

import static java.lang.Math.max;

public class Task8_3 {

  public static void main(String[] args) {
    var array = new int[] {0, 1, 1, 1, 1, 1, 1};
    var result = findMagicNumber(array);
    System.out.println("result = " + result);
  }

  public static int findMagicNumber(int[] array) {
    return findMagicNumber(array, 0, array.length - 1);
  }

  private static int findMagicNumber(int[] array, int inclusiveStart, int inclusiveEnd) {
    System.out.println("start = " + inclusiveStart + " end = " + inclusiveEnd + " array[i] = " + array[inclusiveStart]);

    // if condition below cannot be used if elements are not unique
    if(array[inclusiveStart] > inclusiveStart || array[inclusiveEnd] < inclusiveEnd) {
      return -1;
    }
    if(inclusiveStart == inclusiveEnd) {
      return array[inclusiveStart] == inclusiveStart ? array[inclusiveStart] : -1;
    }
    var middle = (inclusiveStart + inclusiveEnd) / 2;
    return max(findMagicNumber(array, inclusiveStart, middle),
            findMagicNumber(array, middle + 1, inclusiveEnd));
  }
}
