package org.example.chapter10.sorting_and_searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Task10_2 {

  public static void main(String[] args) {
    var strs = new String[] {"abc", "cbaa", "cbbba", "cba", "abca", "cbabb", "aa", "aba", "aab"};
    System.out.println(sort("asbw3biue2v9283h213ivu"));
    groupAnagrams(strs);
    System.out.println(Arrays.toString(strs));
  }

  private static void groupAnagrams(String[] strs) {
    var map = new HashMap<String, LinkedList<String>>();
    for (var s : strs) {
      var sorted = sort(s);
      if (!map.containsKey(sorted)) {
        var list = new LinkedList<String>();
        list.add(s);
        map.put(sorted, list);
      } else {
        var list = map.get(sorted);
        list.add(s);
      }
    }
    var k = 0;
    for (var entry : map.entrySet()) {
      for (var value : entry.getValue()) {
        strs[k] = value;
        k++;
      }
    }
  }

  private static String sort(String s) {
    var chars = s.toCharArray();
    sort(chars, 0, s.length() - 1);
    return new String(chars);
  }

  private static void sort(char[] s, int left, int right) {
    var index = partition(s, left, right);
    if (left < index - 1) {
      sort(s, left, index - 1);
    }
    if (index < right) {
      sort(s, index, right);
    }
  }

  private static int partition(char[] s, int left, int right) {
    var pivot = s[(left + right) / 2];
    while (left < right) {
      while (pivot > s[left]) {
        left++;
      }
      while (pivot < s[right]) {
        right--;
      }
      if (left <= right) {
        var buf = s[left];
        s[left] = s[right];
        s[right] = buf;
        left++;
        right--;
      }
    }
    return left;
  }
}
