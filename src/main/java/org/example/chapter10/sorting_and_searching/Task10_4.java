package org.example.chapter10.sorting_and_searching;

import java.util.ArrayList;

public class Task10_4 {

  public static void main(String[] args) {
    var list = new ArrayListY();
    for (int i = 0; i < 100000000; i++) {
      list.add(i);
    }
    var index = search(list, 88888801);
    System.out.println("index = " + index);
  }

  public static int search(ArrayListY list, int x) {
    if (list.get(0) == -1) {
      return -1;
    }
    if (list.get(0) == x) {
      return 0;
    }
    var index = 1;
    while (list.get(index) != -1 && x > list.get(index)) {
      index *= 2;
    }
    return binarySearch(list, x, index / 2, index);
  }

  private static int binarySearch(ArrayListY list, int x, int left, int right) {
    while (left <= right) {
      var middle = (left + right) / 2;
      var midEl = list.get(middle);
      if (midEl > x || midEl == -1) {
        right = middle - 1;
      } else if (midEl < x) {
        left = middle + 1;
      } else {
        return middle;
      }
    }
    return -1;
  }

  public static class ArrayListY extends ArrayList<Integer> {
    @Override
    public Integer get(int index) {
      if (index > size() - 1) {
        return -1;
      }
      return super.get(index);
    }
  }
}
