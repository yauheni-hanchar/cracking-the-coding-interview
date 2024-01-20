package org.example.chapter10.sorting_and_searching;

public class Task10_3 {

  public static void main(String[] args) {
    var array = new int[] {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
    var result = findNumber(array, 6);
    System.out.println("result = " + result);
    System.out.println("calls = " + calls);
  }

  private static int findNumber(int[] array, int number) {
    return findNumberRecursively(array, number, 0, array.length - 1);
  }

  private static int calls = 0;

  private static int findNumberRecursively(int[] array, int number, int left, int right) {
    calls++;
    if (left > right) {
      return -1;
    }

    var middle = (left + right) / 2;

    if (array[left] == number) {
      return left;
    } else if (array[right] == number) {
      return right;
    } else if (array[middle] == number) {
      return middle;
    }

    if (array[left] < array[right]) {
      if (array[middle] > number && array[left] < number) {
        return findNumberRecursively(array, number, left, middle - 1);
      } else if (array[middle] < number && array[right] > number) {
        return findNumberRecursively(array, number, middle + 1, right);
      } else {
        return -1;
      }
    } else {
      var leftResult = findNumberRecursively(array, number, left, middle - 1);
      if (leftResult != -1) {
        return leftResult;
      }
      return findNumberRecursively(array, number, middle + 1, right);
    }
  }
}
