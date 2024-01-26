package org.example.chapter10.sorting_and_searching;

public class Task10_5 {

  public static void main(String[] args) {
    var strs =
        new String[] {
          "at", "", "", "", "ball", "", "", "ball1", "ball2", "", "", "car", "", "", "dad", "", ""
        };
    var result = findString(strs, "ball");
    System.out.println("result = " + result);
  }

  private static int findString(String[] strs, String x) {
    return findString2(strs, x, 0, strs.length - 1);
  }

  private static int findString(String[] strs, String x, int left, int right) {
    if (left > right) {
      return -1;
    }
    var middle = (left + right) / 2;
    if (strs[middle].isEmpty()) {
      var result = findString(strs, x, 0, middle - 1);
      if (result != -1) {
        return result;
      }
      return findString(strs, x, middle + 1, right);
    } else if (strs[middle].compareTo(x) > 0) {
      return findString(strs, x, 0, middle - 1);
    } else if (strs[middle].compareTo(x) < 0) {
      return findString(strs, x, middle + 1, right);
    } else {
      return middle;
    }
  }

  private static int findString2(String[] strs, String x, int left, int right) {
    if (left > right) {
      return -1;
    }
    var middle = (left + right) / 2;
    if (strs[middle].isEmpty()) {
      var l = middle - 1;
      var r = middle + 1;
      while (true) {
        if (l < left && r > right) {
          return -1;
        } else if (r <= right && !strs[r].isEmpty()) {
          middle = r;
          break;
        } else if (l >= left && !strs[l].isEmpty()) {
          middle = l;
          break;
        }
        l--;
        r++;
      }
    }
    if (strs[middle].equals(x)) {
      return middle;
    } else if (strs[middle].compareTo(x) < 0) {
      return findString2(strs, x, middle + 1, right);
    } else {
      return findString2(strs, x, left, middle - 1);
    }
  }
}
