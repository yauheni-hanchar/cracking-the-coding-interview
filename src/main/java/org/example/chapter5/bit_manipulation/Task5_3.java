package org.example.chapter5.bit_manipulation;

import static java.lang.Math.max;

public class Task5_3 {

  public static void main(String[] args) {
    var number = 0b11110111111111111111111111111111;
    var result = returnMaxWithFlipped(number);
    System.out.println("result = " + result);
  }

  public static int returnMaxWithFlipped(int inputNumber) {
    if (inputNumber == -1) {
      return 32;
    }
    var maxSubsequence = 1;
    int current = 0;
    int previous = 0;
    for (; inputNumber != 0; inputNumber >>>= 1) {
      var currentBit = inputNumber & 1;
      current += currentBit;
      if (currentBit == 0) {
        previous = current;
        current = 0;
      }
      maxSubsequence = max(current + previous + 1, maxSubsequence);
    }
    return maxSubsequence;
  }
}
