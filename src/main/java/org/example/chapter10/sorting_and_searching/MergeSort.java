package org.example.chapter10.sorting_and_searching;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    var array = new int[] {7, 123, 45, 125, 57221, 771, 31246, 11, 1};
    // 1 7 11 45 123 125 771 31246 57221
    mergeSort(array);
    System.out.println(Arrays.toString(array));
  }

  private static void mergeSort(int[] array) {
    var buffer = new int[array.length];
    mergeSort(array, buffer, 0, array.length - 1);
  }

  private static void mergeSort(int[] array, int[] buffer, int left, int right) {
    if (left < right) {
      var middle = (left + right) / 2;
      mergeSort(array, buffer, left, middle);
      mergeSort(array, buffer, middle + 1, right);
      merge(array, buffer, left, middle, right);
    }
  }

  private static void merge(int[] array, int[] buffer, int left, int middle, int right) {
    for (int i = left; i <= right; i++) {
      buffer[i] = array[i];
    }

    var bufferLeft = left;
    var bufferRight = middle + 1;
    var current = left;
    while (bufferLeft <= middle && bufferRight <= right) {
      if (buffer[bufferLeft] <= buffer[bufferRight]) {
        array[current] = buffer[bufferLeft];
        bufferLeft++;
      } else {
        array[current] = buffer[bufferRight];
        bufferRight++;
      }
      current++;
    }

    var remaining = middle - bufferLeft;
    for (int i = 0; i <= remaining; i++) {
      array[current + i] = buffer[bufferLeft + i];
    }
  }
}
