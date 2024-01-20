package org.example.chapter10.sorting_and_searching;

public class BinarySearch {

  public static void main(String[] args) {
    var array = new int[] {1, 2, 3, 6, 8, 9, 11, 15, 16, 17};
    var result = recursiveBinarySearch(array, 0, array.length, 12);
    System.out.println("result = " + result);
  }

  public static int binarySearch(int[] array, int x) {
    var left = 0;
    var right = array.length - 1;
    var middle = 0;

    while (left <= right) {
      middle = (left + right) / 2;
      if (array[middle] < x) {
        left = middle + 1;
      } else if (array[middle] > x) {
        right = middle - 1;
      } else {
        return middle;
      }
    }
    return -1;
  }

  public static int recursiveBinarySearch(int[] array, int left, int right, int x) {
    if (left > right) {
      return -1;
    }

    var middle = (left + right) / 2;
    if (array[middle] < x) {
      return recursiveBinarySearch(array, middle + 1, right, x);
    } else if (array[middle] > x) {
      return recursiveBinarySearch(array, left, middle - 1, x);
    } else {
      return middle;
    }
  }
}
