package org.example.chapter8.recursion_and_dynamic_programming;

public class Task8_1 {

  public static void main(String[] args) {
    var stepsCount = 200000000;
    var result = countWays2(stepsCount);
    System.out.println(result);
  }

  public static long countWays(int stepsCount) {
    return countWays(stepsCount, new long[stepsCount + 1]);
  }

  public static long countWays(int stepsCount, long[] buffer) {
    if (stepsCount < 3) {
      return stepsCount;
    }
    if (stepsCount == 3) {
      return 4L;
    }
    if (buffer[stepsCount] == 0) {
      buffer[stepsCount] =
          countWays(stepsCount - 1, buffer)
              + countWays(stepsCount - 2, buffer)
              + countWays(stepsCount - 3, buffer);
    }
    return buffer[stepsCount];
  }

  public static long countWays2(int stepsCount) {
    if (stepsCount == 0) {
      return 0;
    }
    var a = 1L;
    var b = 2L;
    var c = 4L;
    var copyI = 4;
    for (int i = 4; i < stepsCount + 1; i++) {
      var tempC = c;
      c = a + b + c;
      a = b;
      b = tempC;
      copyI = i;
    }
    System.out.println("copyI = " + copyI);
    return c;
  }
}
