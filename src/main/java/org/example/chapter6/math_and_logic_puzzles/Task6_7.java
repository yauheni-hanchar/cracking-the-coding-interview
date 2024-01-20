package org.example.chapter6.math_and_logic_puzzles;

import java.util.Arrays;
import java.util.Random;

public class Task6_7 {

  public static void main(String[] args) {
    var count = 200000000;
    int[] families = new int[count];
    var random = new Random();
    random.nextBoolean();
    for (int i = 0; i < families.length; ) {
      var nextChild = random.nextBoolean();
      if (nextChild) {
        i++;
      } else {
        families[i] += 1;
      }
    }

    //    System.out.println(Arrays.toString(families));
    Arrays.stream(families).average().ifPresent(System.out::println);
  }
}
