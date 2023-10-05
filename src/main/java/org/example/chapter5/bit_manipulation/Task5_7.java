package org.example.chapter5.bit_manipulation;

public class Task5_7 {

  public static void main(String[] args) {
    var inputNumber = 0b01100011;
    var result = pairwiseSwap(inputNumber);
    System.out.println("result = " + Integer.toBinaryString(result));
  }

  public static int pairwiseSwap(int inputNumber) {
    return ((inputNumber & 0x55555555) << 1) | ((inputNumber & 0xAAAAAAAA) >>> 1);
  }
}
