package org.example.chapter1.arrays_and_strings;

public class Task1_5 {

  public static void main(String[] args) {
    var input = "pale";
    var edited = "ple";
    var result = isOneAway2(input, edited);
    System.out.println(result);

    input = "pale";
    edited = "palse";
    result = isOneAway2(input, edited);
    System.out.println(result);

    input = "pale";
    edited = "bale";
    result = isOneAway2(input, edited);
    System.out.println(result);

    input = "pale";
    edited = "bake";
    result = isOneAway2(input, edited);
    System.out.println(result);
  }

  private static boolean isOneAway(String input, String edited) {
    if (Math.abs(input.length() - edited.length()) > 1) {
      return false;
    }
    int delta = 0;
    int permutations = 0;
    for (var i = 0; i < input.length(); i++) {
      if (input.charAt(i) != edited.charAt(i + delta) && Math.abs(permutations) >= 1) {
        return false;
      }
      if (input.charAt(i) != edited.charAt(i + delta)) {
        if (input.length() == edited.length()) {
          if (input.charAt(i + 1) != edited.charAt(i + 1)) {
            return false;
          }
        } else if (input.length() < edited.length()) {
          if (input.charAt(i) != edited.charAt(i + 1)) {
            return false;
          }
          delta++;
        } else {
          if (input.charAt(i + 1) != edited.charAt(i)) {
            return false;
          }
          delta--;
        }
        permutations++;
      }
    }
    return true;
  }

  private static boolean isOneAway2(String input, String edited) {
    if (Math.abs(input.length() - edited.length()) > 1) {
      return false;
    }
    var first = input.length() < edited.length() ? input : edited;
    var second = input.length() < edited.length() ? edited : input;
    int delta = 0;
    boolean isPermutationFound = false;
    for (var i = 0; i < first.length(); i++) {
      if (first.charAt(i) != second.charAt(i + delta) && isPermutationFound) {
        return false;
      }
      if (first.charAt(i) != second.charAt(i + delta)) {
        if (input.length() != edited.length()) {
          delta++;
        }
        isPermutationFound = true;
      }
    }
    return true;
  }
}
