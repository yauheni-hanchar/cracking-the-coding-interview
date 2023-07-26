package org.example.chapter1.arrays_and_strings;

import java.io.IOException;

public class Task1_7 {

  public static void main(String[] args) {
    int[][] input = generateMatrix(5);
    printMatrix(input);
    var result = rotateMatrix(input);
    printMatrix(result);

    result = rotateMatrix2(input);
    printMatrix(result);

    input = generateMatrix(6);
    printMatrix(input);
    result = rotateMatrix(input);
    printMatrix(result);

    result = rotateMatrix2(input);
    printMatrix(result);
  }

  private static int[][] rotateMatrix(int[][] matrix) {
    int[][] rotatedMatrix = new int[matrix.length][matrix.length];
    for (var i = 0; i < matrix.length; i++) {
      for (var j = matrix.length - 1; j >= 0; j--) {
        rotatedMatrix[i][matrix.length - j - 1] = matrix[j][i];
      }
    }
    return rotatedMatrix;
  }

  private static int[][] rotateMatrix2(int[][] matrix) {
    int buf = 0;
    for (var j = 0; j < matrix.length / 2; j++) {
      for (var i = j; i < matrix.length - j - 1; i++) {
        buf = matrix[j][i];
        matrix[j][i] = matrix[matrix.length - i - 1][j];
        matrix[matrix.length - i - 1][j] = matrix[matrix.length - j - 1][matrix.length - i - 1];
        matrix[matrix.length - j - 1][matrix.length - i - 1] = matrix[i][matrix.length - j - 1];
        matrix[i][matrix.length - j - 1] = buf;
      }
    }
    return matrix;
  }

  public static void printMatrix(int[][] matrix) {
    for (int[] ints : matrix) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(String.format("%2d ", ints[j]));
      }
      System.out.println();
    }
    System.out.println();
  }

  public static int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        matrix[i][j] = j + i * n;
      }
    }
    return matrix;
  }
}
