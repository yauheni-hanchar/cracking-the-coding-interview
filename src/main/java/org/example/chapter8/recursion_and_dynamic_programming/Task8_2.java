package org.example.chapter8.recursion_and_dynamic_programming;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static java.util.Collections.emptyList;

public class Task8_2 {

  public static void main(String[] args) {
    var map = generateTable(1000, 1000);
    printTable(map);

    /*boolean[][] map = {
      {true, false, true, true, true, true, true},
      {true, true, false, true, true, true, true},
      {true, true, true, true, true, false, true},
      {true, true, true, true, true, true, true}
    };*/
    var path = findPath(map);
    printPath(map, path);
    System.out.println("result = " + path);
  }

  public static List<Coordinates> findPath(boolean[][] map) {
    if (map == null || map.length == 0) {
      return emptyList();
    }
    var path = new ArrayList<Coordinates>();
    HashSet<Coordinates> failedCoordinates = new HashSet<>();
    findPath(map.length - 1, map[0].length - 1, map, path, failedCoordinates);
    return path;
  }

  public static boolean findPath(
      int r,
      int c,
      boolean[][] map,
      List<Coordinates> path,
      HashSet<Coordinates> failedCoordinates) {
    if (r < 0 || c < 0 || !map[r][c]) {
      return false;
    }
    var currentCoordinates = new Coordinates(r, c);
    if (failedCoordinates.contains(currentCoordinates)) {
      return false;
    }
    var isStartPoint = r == 0 && c == 0;
    if (isStartPoint
        || findPath(r - 1, c, map, path, failedCoordinates)
        || findPath(r, c - 1, map, path, failedCoordinates)) {
      path.add(currentCoordinates);
      return true;
    }
    failedCoordinates.add(currentCoordinates);
    return false;
  }

  private static boolean[][] generateTable(int r, int c) {
    boolean[][] table = new boolean[r][c];
    var random = new Random();
    var randomInt = random.nextInt(0, 100);
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (randomInt != 0) {
          table[i][j] = true;
        }
        randomInt = random.nextInt(0, 100);
      }
    }
    return table;
  }

  private static void printTable(boolean[][] map) {
    for (var booleans : map) {
      for (int j = 0; j < map[0].length; j++) {
        if (booleans[j]) {
          System.out.print("□ ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void printPath(boolean[][] map, List<Coordinates> path) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if (path.contains(new Coordinates(i, j))) {
          System.out.print("* ");
        } else if (map[i][j]) {
          System.out.print("□ ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  @Data
  @AllArgsConstructor
  public static class Coordinates {
    private int r;
    private int c;
  }
}
