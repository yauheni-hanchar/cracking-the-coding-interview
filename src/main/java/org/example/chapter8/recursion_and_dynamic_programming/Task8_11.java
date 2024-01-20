package org.example.chapter8.recursion_and_dynamic_programming;

public class Task8_11 {

  public static void main(String[] args) {
    var result = calculateWays2(100000);
    System.out.println("result = " + result);
  }

  private static long calculateWays2(int n) {
    int[] denoms = {25, 10, 5, 1};
    int[][] map = new int[n + 1][denoms.length];
    return calculateWays2(n, denoms, 0, map);
  }

  private static long calculateWays2(int n, int[] denoms, int index, int[][] map) {
    var cached = map[n][index];
    if (cached > 0) {
      return cached;
    }
    if (index >= denoms.length - 1) {
      return 1;
    }
    var denomsAmount = denoms[index];
    var ways = 0;
    for (int i = 0; i * denomsAmount <= n; i++) {
      var amountRemaining = n - i * denomsAmount;
      ways += calculateWays2(amountRemaining, denoms, index + 1, map);
    }
    map[n][index] = ways;
    return ways;
  }
}
