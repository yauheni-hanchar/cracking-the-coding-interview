package org.example.chapter5.bit_manipulation;

import static java.lang.Integer.toBinaryString;

public class Task5_4 {

  public static void main(String[] args) {
    var input = 0b1000011;
    var largest = getNextLargest(input);
    System.out.println("largest = " + toBinaryString(largest));

    var smallest = getNextSmallest(input);
    System.out.println("smallest = " + toBinaryString(smallest));
  }

  public static int getNextLargestNumber(int input) {
    var countOfOnes = 0;
    var result = input;
    var inputCopy = input;
    for (int i = 0; i < 32; i++) {
      if (i == 31) {
        return -1;
      }
      var isOne = inputCopy & 1;
      countOfOnes += isOne;
      if (isOne == 0 && countOfOnes > 0) {
        var mask = -(1 << i);
        result &= mask;
        var setBitMask = 1 << i;
        result |= setBitMask;
        break;
      }
      inputCopy >>>= 1;
    }
    var endMask = (1 << (countOfOnes - 1)) - 1;
    return result | endMask;
  }

  public static int getNextLargest(int n) {
    var c = n;
    var c0 = 0;
    while ((c & 1) == 0 && c != 0) {
      c0++;
      c >>>= 1;
    }
    var c1 = 0;
    while ((c & 1) == 1) {
      c1++;
      c >>>= 1;
    }
    if (c0 + c1 == 31 || c0 + c1 == 0) {
      return -1;
    }
    return n + (1 << c0) + (1 << (c1 - 1)) - 1;
  }

  public static int getNextSmallest(int n) {
    var c = n;
    var c1 = 0;
    while ((c & 1) == 1 && c != 0) {
      c1++;
      c >>>= 1;
    }
    var c0 = 0;
    while ((c & 1) == 0) {
      c0++;
      c >>>= 1;
    }

    if (c0 + c1 == 31) {
      return -1;
    }

    return n - (1 << c1) - ((1 << (c0 - 1)) - 1);
  }
}
