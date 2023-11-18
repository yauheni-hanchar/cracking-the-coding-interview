package org.example.chapter8.recursion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task8_4 {

  public static void main(String[] args) {
    var set = IntStream.range(1, 25)
                    .boxed()
                            .map(i -> List.of(i)).collect(Collectors.toCollection(LinkedList::new));
    set.addFirst(List.of());
//    System.out.println("set = " + set);
    var result = allSubsets(set);
    System.out.println("size = " + result.size());
//    System.out.println(result);
  }

  private static LinkedList<List<Integer>> allSubsets(LinkedList<List<Integer>> set) {
    var subsets = new LinkedList<List<Integer>>();
    allSubsets(set, subsets);
    return subsets;
  }

  private static void allSubsets(LinkedList<List<Integer>> set, LinkedList<List<Integer>> subsets) {
    if(set.isEmpty()){
      return;
    }
    if(subsets.isEmpty()) {
      subsets.add(set.poll());
      allSubsets(set, subsets);
      return;
    }
    var firstSubset = set.pollLast();
    var iterator = subsets.listIterator();
    while(iterator.hasNext()) {
      var subset = iterator.next();
      var newElement = new LinkedList<>(firstSubset);
      newElement.addAll(subset);
      iterator.add(newElement);
    }
    allSubsets(set, subsets);
  }
}
