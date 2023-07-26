package org.example.chapter1.arrays_and_strings;

import java.util.Arrays;

public class Task1_2 {

  public static void main(String[] args) {
    var result = isPermutation("abcd", "dbfa");
    System.out.println(result);

    result = isPermutation("abcd", "cbda");
    System.out.println(result);

    result = isPermutation2("abcd", "dbfa");
    System.out.println(result);

    result = isPermutation2("abcd", "cbda");
    System.out.println(result);
  }

  private static boolean isPermutation(String first, String second) {
    if (first.length() != second.length()) {
      return false;
    }
    int[] counts = new int[128];
    for (int i = 0; i < first.length(); i++) {
      counts[first.charAt(i)]++;
    }
    for (int i = 0; i < second.length(); i++) {
      var current = --counts[second.charAt(i)];
      if (current < 0) {
        return false;
      }
    }
    return true;
  }

  private static boolean isPermutation2(String first, String second) {
    return sort(first).equals(sort(second));
  }

  private static String sort(String string) {
    var chars = string.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
}
