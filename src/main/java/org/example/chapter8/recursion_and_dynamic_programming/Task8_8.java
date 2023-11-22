package org.example.chapter8.recursion_and_dynamic_programming;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task8_8 {

  public static void main(String[] args) {
    var str = "abbbcc";
    var permutations = getPermutationsWithRepetitions(str);
    System.out.println("permutations.size() = " + permutations.size());
    permutations.forEach(System.out::println);
  }

  private static List<String> getPermutationsWithRepetitions(String str) {
    var lettersCount = countLetters(str);
    var result = new ArrayList<String>();
    getPermutationsWithRepetitions("",str.length(), lettersCount, result);
    return result;
  }

  private static HashMap<Character, Integer> countLetters(String str) {
    var result = new HashMap<Character, Integer>();
    for (int i = 0; i < str.length(); i++) {
      var c = str.charAt(i);
      if (result.containsKey(c)) {
        result.put(c, result.get(c) + 1);
      } else {
        result.put(c, 1);
      }
    }
    return result;
  }

  private static void getPermutationsWithRepetitions(String prefix, int remaining, HashMap<Character, Integer> lettersCount, List<String> result) {
    if(remaining == 0) {
      result.add(prefix);
      return;
    }

    for (var entry : lettersCount.entrySet()) {
      var value = entry.getValue();
      if(value > 0) {
        lettersCount.put(entry.getKey(), value - 1);
        getPermutationsWithRepetitions(prefix + entry.getKey(), remaining - 1, lettersCount, result);
        lettersCount.put(entry.getKey(), value);
      }
    }
  }
}
