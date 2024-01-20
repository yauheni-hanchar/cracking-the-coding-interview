package org.example.chapter10.sorting_and_searching;

public class Task10_1 {

  public static void main(String[] args) {}

  public static int[] mergeSortedArrays(int[] a, int[] b) {
    var lastIndex = a.length + b.length - 1;
    var ai = a.length - 1;
    var bi = b.length - 1;
    while (bi >= 0) {
      if (ai > 0 && b[bi] < a[ai]) {
        a[lastIndex] = a[ai];
        ai--;
      } else {
        a[lastIndex] = b[bi];
        bi--;
      }
      lastIndex--;
    }
    return a;
  }
}
