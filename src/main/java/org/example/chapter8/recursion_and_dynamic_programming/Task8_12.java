package org.example.chapter8.recursion_and_dynamic_programming;

public class Task8_12 {

  public static void main(String[] args) {
    var n = 4;
    printArrangements(n);
  }

  public static void printArrangements(int n) {
    var columns = new int[n];
    var mainDiagonal = new int[2 * n - 1];
    var antiDiagonal = new int[2 * n - 1];
    setQueen(n, 0, columns, mainDiagonal, antiDiagonal);
  }

  private static void setQueen(
      int n, int column, int[] rows, int[] mainDiagonal, int[] antiDiagonal) {
    if (column == n) {
      printChessboard(n, rows);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (rows[i] == 0 && mainDiagonal[column - i + n - 1] == 0 && antiDiagonal[column + i] == 0) {
        var queenNumber = column + 1;
        rows[i] = queenNumber;
        mainDiagonal[column - i + n - 1] = queenNumber;
        antiDiagonal[column + i] = queenNumber;
        setQueen(n, column + 1, rows, mainDiagonal, antiDiagonal);
        rows[i] = 0;
        mainDiagonal[column - i + n - 1] = 0;
        antiDiagonal[column + i] = 0;
      }
    }
  }

  private static void printChessboard(int n, int[] rows) {
    for (int currentRow = 0; currentRow < n; currentRow++) {
      var queenCol = rows[currentRow];
      var rowString = new StringBuilder(n * 2);
      for (int currentCol = 0; currentCol < n; currentCol++) {
        if (currentCol == queenCol - 1) {
          rowString.append("■ ");
        } else {
          rowString.append("□ ");
        }
      }
      System.out.println(rowString);
    }
    System.out.println();
  }
}
