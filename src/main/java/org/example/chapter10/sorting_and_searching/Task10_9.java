package org.example.chapter10.sorting_and_searching;

import lombok.Builder;

public class Task10_9 {

  public static void main(String[] args) {
    var matrix =
        new int[][] {
          {15, 20, 40, 85},
          {20, 35, 80, 95},
          {30, 55, 95, 105},
          {40, 80, 100, 120}
        };
    var result =
        findElement2(matrix, new XY(0, 0), new XY(matrix.length - 1, matrix[0].length - 1), 105);
    System.out.println("result: " + result);
  }

  private static String findElement(int[][] matrix, int element) {
    var col = matrix[0].length - 1;
    var row = 0;
    while (col >= 0 && row < matrix.length) {
      if (matrix[row][col] == element) {
        return "row=" + row + "; col=" + col;
      } else if (element < matrix[row][col]) {
        col--;
      } else {
        row++;
      }
    }
    return "-1";
  }

  private static XY findElement2(int[][] matrix, XY diagStart, XY diagEnd, int x) {
    System.out.println("new call + " + diagStart + " + " + diagEnd);
    if (matrix[diagStart.row()][diagStart.col()] > x || matrix[diagEnd.row()][diagEnd.col()] < x) {
      return null;
    }
    var currentRow = diagStart.row();
    var currentCol = diagStart.col();
    while (diagEnd.isAfter(currentRow, currentCol)) {
      System.out.println("row = " + currentRow + " col = " + currentCol);
      var currentEl = matrix[currentRow][currentCol];
      if (currentEl == x) {
        return new XY(currentRow, currentCol);
      } else if (currentEl < x) {
        currentRow++; // must be the binary search on the diagonal
        currentCol++;
      } else {
        var firstQuoterResult =
            findElement2(
                matrix,
                new XY(diagStart.row(), currentCol),
                new XY(currentRow - 1, diagEnd.col()),
                x);
        if (firstQuoterResult != null) {
          return firstQuoterResult;
        }
        return findElement2(
            matrix, new XY(currentRow, diagStart.col()), new XY(diagEnd.row(), currentCol - 1), x);
      }
    }
    return null;
  }

  @Builder
  public record XY(int row, int col) {
    public boolean isAfter(XY other) {
      return row > other.row || col > other.col;
    }

    public boolean isAfter(int otherRow, int otherCol) {
      System.out.println(
          "isAfter: row = "
              + row
              + " otherRow = "
              + otherRow
              + " col = "
              + col
              + " otherCol = "
              + otherCol);
      return row >= otherRow && col >= otherCol;
    }
  }
}
