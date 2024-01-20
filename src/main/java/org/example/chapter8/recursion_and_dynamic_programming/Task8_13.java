package org.example.chapter8.recursion_and_dynamic_programming;

import static java.lang.Math.max;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Task8_13 {

  public static void main(String[] args) {
    var random = new Random();
    var boxes =
        IntStream.range(1, 100001)
            .mapToObj(
                index ->
                    new Box(
                        random.nextInt(1, 1000), random.nextInt(1, 1000), random.nextInt(1, 1000)))
            .collect(toList());

    var result = createStack(boxes);
    System.out.println("result = " + result);
  }

  private static int createStack(List<Box> boxes) {
    boxes.sort(comparing(Box::height).reversed());
    var maxHeight = 0;
    var memo = new int[boxes.size()];
    for (int i = 0; i < boxes.size(); i++) {
      var height = createStack(boxes, 0, memo);
      maxHeight = max(height, maxHeight);
    }
    return maxHeight;
  }

  private static int createStack(List<Box> boxes, int bottomIndex, int[] memo) {
    if (boxes == null) {
      return 0;
    }
    if (bottomIndex < boxes.size() && memo[bottomIndex] != 0) {
      return memo[bottomIndex];
    }
    var bottomBox = boxes.get(bottomIndex);
    var maxHeight = 0;
    for (int i = bottomIndex + 1; i < boxes.size(); i++) {
      if (boxes.get(i).canBeAbove(bottomBox)) {
        var height = createStack(boxes, i, memo);
        maxHeight = max(maxHeight, height);
      }
    }
    maxHeight += bottomBox.height;
    memo[bottomIndex] = maxHeight;
    return maxHeight;
  }

  record Box(int height, int width, int length) {

    public boolean canBeAbove(Box other) {
      return height < other.height && width < other.width && length < other.length;
    }
  }
}
