package org.example.chapter10.sorting_and_searching;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    var array = new int[] {7, 123, 45, 125, 536, 771, 31246, 11, 1};
    // 1 7 11 45 123 125 771 31246 57221
    quickSort(array);
    System.out.println(Arrays.toString(array));
  }

  private static void quickSort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  private static void quickSort(int[] array, int left, int right) {
    var index = partition(array, left, right);
    if (left < index - 1) {
      quickSort(array, left, index - 1);
    }
    if (index < right) {
      quickSort(array, index, right);
    }
  }

  private static int partition(int[] array, int left, int right) {
    int pivot = array[(left + right) / 2];
    while (left <= right) {
      while (array[left] < pivot) {
        left++;
      }
      while (array[right] > pivot) {
        right--;
      }

      if (left <= right) {
        swap(array, left, right);
        left++;
        right--;
      }
    }
    return left;
  }

  private static void swap(int[] array, int i, int j) {
    var buf = array[i];
    array[i] = array[j];
    array[j] = buf;
  }
}
