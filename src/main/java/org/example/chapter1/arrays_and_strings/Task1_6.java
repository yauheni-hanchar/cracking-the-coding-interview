package org.example.chapter1.arrays_and_strings;

public class Task1_6 {

  public static void main(String[] args) {
    var input = "aabcccccaaa";
    var result = compressString(input);
    System.out.println(result);
  }

  private static String compressString(String input) {
    var builder = new StringBuilder(input.length());
    var count = 1;
    var chars = input.toCharArray();
    char current = chars[0];
    for (var i = 0; i < chars.length; i++) {
      if (chars[i] == current && i != 0) {
        count++;
      }
      if (chars[i] != current || i == chars.length - 1) {
        builder.append(current);
        builder.append(count);
        current = chars[i];
        count = 1;
      }
    }

    return builder.length() < input.length() ? builder.toString() : input;
  }
}
