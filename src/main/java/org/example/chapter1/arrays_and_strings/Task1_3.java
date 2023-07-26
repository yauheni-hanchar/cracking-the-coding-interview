package org.example.chapter1.arrays_and_strings;

public class Task1_3 {

  public static void main(String[] args) {
    var result =
        urlify("/oh - my-first-friend let's go 1984 y.                               ", 38);
    System.out.println(result);
  }

  private static String urlify(String input, int realLength) {
    var chars = input.toCharArray();
    var spacesCount = 0;
    for (int i = 0; i < realLength; i++) {
      if (chars[i] == ' ') {
        spacesCount++;
      }
    }

    var index = realLength + 2 * spacesCount - 1;
    for (int i = realLength - 1; i > 0; i--) {
      if (chars[i] == ' ') {
        chars[index] = '0';
        chars[index - 1] = '2';
        chars[index - 2] = '%';
        index -= 3;
      } else {
        chars[index] = chars[i];
        index--;
      }
    }
    return new String(chars);
  }
}
