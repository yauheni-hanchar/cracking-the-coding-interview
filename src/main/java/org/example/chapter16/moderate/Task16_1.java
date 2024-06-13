package org.example.chapter16.moderate;

public class Task16_1 {

  public static void main(String[] args) {
    // sum approach
    var a = 318;
    var b = 43;

    a -= b;
    b += a;
    a = b - a;

    System.out.println("a = " + a);
    System.out.println("b = " + b);

    // bit approach
    a = 318;
    b = 43;

    a = a ^ b;
    b = a ^ b;
    a = a ^ b;

    System.out.println("a = " + a);
    System.out.println("b = " + b);
  }
}
