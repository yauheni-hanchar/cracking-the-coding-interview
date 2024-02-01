package org.example.chapter10.sorting_and_searching;

import lombok.Data;
import lombok.ToString;

public class Task10_10 {

  public static void main(String[] args) {
    var root = new TreeNode();
    root.track(20);
    root.track(15);
    root.track(10);
    root.track(5);
    root.track(13);
    root.track(25);
    root.track(23);
    root.track(24);
    System.out.println(root.getRankOfNumber(11));
  }

  @Data
  public static class TreeNode {
    private Integer data;
    private int leftChilds = 0;
    @ToString.Exclude private TreeNode left;
    @ToString.Exclude private TreeNode right;

    public void track(int num) {
      if (data == null) {
        data = num;
        return;
      }
      if (data < num) {
        if (right == null) {
          right = new TreeNode();
          right.track(num);
        } else {
          right.track(num);
        }
      } else {
        leftChilds++;
        if (left == null) {
          left = new TreeNode();
          left.track(num);
        } else {
          left.track(num);
        }
      }
    }

    public int getRankOfNumber(int num) {
      if (num == data) {
        return leftChilds;
      } else if (num < data) {
        if (left == null) {
          return -1;
        }
        return left.getRankOfNumber(num);
      } else {
        var rightRank = right == null ? -1 : right.getRankOfNumber(num);
        if (rightRank == -1) {
          return rightRank;
        }
        return leftChilds + 1 + rightRank;
      }
    }
  }
}
