package org.example.chapter5.bit_manipulation;

public class Task5_6 {

  public static void main(String[] args) {
    var a = 0b10110111111111111111111111111110;
    var b = 0b10111111111111111011111111111111;
    var result = getConversions(a, b);
    System.out.println("result = " + result);
  }

  public static int getConversions(int a, int b) {
    var count = 0;
    for (int i = a ^ b; i != 0; i >>>= 1) {
      count += i & 1;
    }
    return count;
  }

  public static int getConversions2(int a, int b) {
    var count = 0;
    for (int i = a ^ b; i != 0; i &= (i - 1)) {
      count++;
    }
    return count;
  }
}
