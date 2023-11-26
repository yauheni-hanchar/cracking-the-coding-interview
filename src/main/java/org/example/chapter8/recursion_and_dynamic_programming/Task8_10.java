package org.example.chapter8.recursion_and_dynamic_programming;

public class Task8_10 {

  public static void main(String[] args) {
    String[][] screen = {
      {" ", " ", " ", " ", " ", " ", " "},
      {" ", " ", ".", " ", ".", " ", " "},
      {" ", " ", ".", " ", " ", " ", " "},
      {" ", ".", ".", " ", ".", ".", " "},
      {".", " ", ".", ".", ".", " ", "."},
      {" ", ".", " ", " ", " ", ".", " "}
    };
    printScreen(screen);
    paintFill(screen, 3, 3, "o", screen[3][3]);
    printScreen(screen);
  }

  private static void paintFill(
      String[][] screen, int r, int c, String targetColor, String colorToFill) {
    if (r < 0
        || c < 0
        || r >= screen.length
        || c >= screen[0].length
        || !screen[r][c].equals(colorToFill)) {
      return;
    }

    screen[r][c] = targetColor;
    paintFill(screen, r + 1, c, targetColor, colorToFill);
    paintFill(screen, r - 1, c, targetColor, colorToFill);
    paintFill(screen, r, c + 1, targetColor, colorToFill);
    paintFill(screen, r, c - 1, targetColor, colorToFill);
  }

  private static void printScreen(String[][] screen) {
    for (var row : screen) {
      for (var pixel : row) {
        System.out.print(pixel + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
