package org.example.chapter10.sorting_and_searching;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;

import java.util.Arrays;

public class Task10_11 {

  public static void main(String[] args) {
    var array = new int[] {9, 1, 0, 4, 8, 7};
    sortValleyPick(array);
    System.out.println(Arrays.toString(array));
  }

  public static void sortValleyPick(int[] array) {
    for (int i = 1; i < array.length; i += 2) {
      var biggestIndex = getMaxIndex(array, i - 1, i, i + 1);
      if (biggestIndex != i) {
        swap(array, i, biggestIndex);
      }
    }
  }

  private static int getMaxIndex(int[] array, int a, int b, int c) {
    var l = array.length;
    var aVal = a >= 0 && a < l ? array[a] : MIN_VALUE;
    var bVal = b >= 0 && b < l ? array[b] : MIN_VALUE;
    var cVal = c >= 0 && c < l ? array[c] : MIN_VALUE;
    var biggestVal = max(aVal, max(bVal, cVal));
    if (aVal == biggestVal) {
      return a;
    }
    if (bVal == biggestVal) {
      return b;
    }
    return c;
  }

  private static void swap(int[] array, int i, int j) {
    var buf = array[i];
    array[i] = array[j];
    array[j] = buf;
  }
}
