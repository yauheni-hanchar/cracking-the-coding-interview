package org.example.chapter10.sorting_and_searching;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.System.arraycopy;

import java.util.Arrays;

public class RadixSort {

  public static void main(String[] args) {
    var array = new int[] {7, 123, 45, 125, 57221, 771, 31246, 11, 1};
    // 1 7 11 45 123 125 771 31246 57221
    radixSortLeastSignificantDigit(array);
    System.out.println(Arrays.toString(array));
  }

  public static void radixSortLeastSignificantDigit(int[] array) {
    var max = getMax(array);
    for (int exp = 1; max / exp > 0; exp *= 10) {
      countSort(array, exp);
      System.out.println(Arrays.toString(array));
    }
  }

  public static int getMax(int[] array) {
    var max = MIN_VALUE;
    for (int j : array) {
      if (j > max) {
        max = j;
      }
    }
    return max;
  }

  public static void countSort(int[] array, int exp) {
    var sorted = new int[array.length];
    var count = new int[10];

    for (int j : array) {
      count[(j / exp) % 10]++;
    }

    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    for (int i = array.length - 1; i >= 0; i--) {
      var remainder = (array[i] / exp) % 10;
      sorted[count[remainder] - 1] = array[i];
      count[remainder]--;
    }

    arraycopy(sorted, 0, array, 0, sorted.length);
  }
}
