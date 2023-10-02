package org.example.chapter5.bit_manipulation;

public class Task5_2 {

  public static void main(String[] args) {

    var a = 0.1111111;
    var result = toBinary(a);
    System.out.println(result);
  }

  public static String toBinary(double a) {
    if (a >= 1 || a <= 0) {
      return "ERROR";
    }

    var result = new StringBuilder();
    result.append("0.");

    while (a > 0) {
      if (result.length() > 3400) {
        return result.toString();
      }
      a = a * 2;
      var nextBinary = a >= 1 ? 1 : 0;
      result.append(nextBinary);
      if (a >= 1) {
        a -= 1;
      }
    }

    return result.toString();
  }
}
