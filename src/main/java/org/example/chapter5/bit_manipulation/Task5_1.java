package org.example.chapter5.bit_manipulation;

public class Task5_1 {

  public static void main(String[] args) {
    var n = 0b10000000000;
    var m = 0b10011;
    var i = 2;
    var j = 6;

    var result = insertNumber(n, m, i, j);
    System.out.println(Integer.toBinaryString(result));
  }

  public static int insertNumber(int n, int m, int i, int j) {
    var clearedN = clearFrom(n, i, j);
    var movedM = m << i;
    return clearedN | movedM;
  }

  private static int clearFrom(int n, int i, int j) {
     var right1 = 1 << (i - 1);
     var left1 = -1 << (j + 1);
     return (left1 | right1) & n;
  }
}
