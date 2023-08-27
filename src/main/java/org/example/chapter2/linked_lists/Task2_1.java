package org.example.chapter2.linked_lists;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Task2_1 {

  public static void main(String[] args) {
    LinkedList<Integer> input = new LinkedList<>();
    input.add(5);
    input.add(4);
    input.add(2);
    input.add(1);
    input.add(5);
    input.add(123);
    input.add(4);
    input.add(53);
    input.add(4);
    input.add(53);
    input.add(53);
    input.add(53);
    input.add(1);
    System.out.println(input);
    var result = deleteDuplicates2(input);
    System.out.println(result);
  }

  /** Need O(n) additional space and O(n) execution time */
  public static List<Integer> deleteDuplicates(List<Integer> list) {
    HashSet<Integer> buffer = new HashSet<>();
    var iterator = list.iterator();
    while (iterator.hasNext()) {
      var nextElement = iterator.next();
      if (buffer.contains(nextElement)) {
        iterator.remove();
      } else {
        buffer.add(nextElement);
      }
    }
    return list;
  }

  /** No need additional space and O(n^2) execution time */
  public static List<Integer> deleteDuplicates2(List<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        if (list.get(i).equals(list.get(j))) {
          list.remove(j);
          j--;
        }
      }
    }
    return list;
  }
}
