package org.example.chapter1.arrays_and_strings;

import static java.lang.Character.getNumericValue;

public class Task1_4 {

  public static void main(String[] args) {
    var input = "taccctccoa";
    var result = isPalindrom(input);
    System.out.println(result);

    result = isPalindrom2(input);
    System.out.println(result);
  }

  private static boolean isPalindrom(String input) {
    int[] counts = new int[128];
    int odds = 0;
    for (var i = 0; i < input.length(); i++) {
      var current = ++counts[input.charAt(i)];
      if (current % 2 == 1) {
        odds++;
      } else if (current != 0 && current % 2 != 1) {
        odds--;
      }
    }
    return odds <= 1;
  }

  private static boolean isPalindrom2(String input) {
    int bitVector = createBitVector(input);
    return bitVector == 0 || isOneBitSet(bitVector);
  }

  private static boolean isOneBitSet(int bitVector) {
    return (bitVector & (bitVector - 1)) == 0;
  }

  private static int createBitVector(String input) {
    char[] chars = input.toCharArray();
    int bitCounts = 0;
    for (var c : chars) {
      var cNumber = getCharNumber(c);
      bitCounts = toggle(bitCounts, cNumber);
    }
    return bitCounts;
  }

  private static int toggle(int bitVector, int index) {
    return bitVector ^ (1 << index);
  }

  private static int getCharNumber(Character c) {
    int a = getNumericValue('a');
    return getNumericValue(c) - a;
  }
}
