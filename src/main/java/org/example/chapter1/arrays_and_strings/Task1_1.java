package org.example.chapter1.arrays_and_strings;

public class Task1_1 {

  public static void main(String[] args) {
    var result = isUniqueCharacters("abcdefa");
    System.out.println(result);
  }

  private static boolean isUniqueCharacters(String input) {
    if (input.length() > 128) {
      return false;
    }
    boolean[] buf = new boolean[128];
    for (int i = 0; i < input.length(); i++) {
      var c = input.charAt(i);
      if (buf[c]) {
        return false;
      }
      buf[c] = true;
    }
    return true;
  }
}
