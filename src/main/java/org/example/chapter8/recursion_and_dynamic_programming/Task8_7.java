package org.example.chapter8.recursion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class Task8_7 {

  public static void main(String[] args) {
    var str = "a";
    var permutations = getPermutations2(str);
    permutations.forEach(System.out::println);
    System.out.println("permutations.size() = " + permutations.size());
  }

  private static List<String> getPermutations(String str) {
    if (str == null || str.isBlank()) {
      return List.of();
    }
    return getPermutations(str, str.length());
  }

  private static List<String> getPermutations(String str, int n) {
    if (n == 1) {
      var singlePermutation = new ArrayList<String>();
      singlePermutation.add(str.substring(0, 1));
      return singlePermutation;
    }
    var permutations = getPermutations(str, n - 1);
    var newPermutations = new ArrayList<String>();
    for (var permutation : permutations) {
      for (int i = permutation.length(); i >= 0; i--) {
        var newPermutation =
            permutation.substring(0, i) + str.charAt(n - 1) + permutation.substring(i);
        newPermutations.add(newPermutation);
      }
    }
    return newPermutations;
  }

  private static List<String> getPermutations2(String remainder) {
    var result = new ArrayList<String>();
    if (remainder.length() == 0) {
      result.add("");
      return result;
    }
    for (int i = 0; i < remainder.length(); i++) {
      var left = remainder.substring(0, i);
      var right = remainder.substring(i + 1);
      var permutations = getPermutations2(left + right);
      for (var permutation : permutations) {
        result.add(remainder.charAt(i) + permutation);
      }
    }
    return result;
  }
}
