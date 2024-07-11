package org.example.trees;

import lombok.Data;
import lombok.ToString;

public class BalanceBinaryTree {

  public static void main(String[] args) {
    var root = getExampleTree();
    dayStoutWarren(root);
  }

  private static TreeNode dayStoutWarren(TreeNode root) {
    var grand = new TreeNode(0);
    grand.setRight(root);

    var count = bstToVine(grand);
    var maxHeight = log2(count);
    var nodesNumUntilLastLevel = (int) (Math.pow(2, maxHeight)) - 1;

    compress(grand, count - nodesNumUntilLastLevel);
    for (nodesNumUntilLastLevel /= 2; nodesNumUntilLastLevel > 0; nodesNumUntilLastLevel /= 2) {
      compress(grand, nodesNumUntilLastLevel);
    }
    return grand.getRight();
  }

  private static int bstToVine(TreeNode grand) {
    var count = 0;

    var tmp = grand.getRight();
    while (tmp != null) {
      if (tmp.getLeft() != null) {
        var oldTmp = tmp;
        tmp = oldTmp.getLeft();
        oldTmp.setLeft(tmp.getRight());
        tmp.setRight(oldTmp);
        grand.setRight(tmp);
      } else {
        count++;
        grand = tmp;
        tmp = tmp.getRight();
      }
    }

    return count;
  }

  private static int log2(int a) {
    return (int) (Math.log(a) / Math.log(2));
  }

  private static void compress(TreeNode grand, int m) {
    var tmp = grand.getRight();
    for (int i = 0; i < m; i++) {
      var oldTmp = tmp;
      tmp = tmp.getRight();
      grand.setRight(tmp);
      oldTmp.setRight(tmp.getLeft());
      tmp.setLeft(oldTmp);
      grand = tmp;
      tmp = tmp.getRight();
    }
  }

  private static TreeNode getExampleTree() {
    var root = new TreeNode(5);
    var n3 = root.setLeft(3);
    n3.setLeft(2).setLeft(1);
    n3.setRight(4);

    var n10 = root.setRight(10);
    n10.setLeft(7).setRight(8);

    var n35 = n10.setRight(20).setRight(35);
    n35.setLeft(33);
    n35.setRight(38);
    return root;
  }
}

@Data
class TreeNode {

  private int value;
  @ToString.Exclude private TreeNode left;
  @ToString.Exclude private TreeNode right;

  public TreeNode(int value) {
    this.value = value;
  }

  public TreeNode setLeft(TreeNode node) {
    left = node;
    return left;
  }

  public TreeNode setLeft(int value) {
    left = new TreeNode(value);
    return left;
  }

  public TreeNode setRight(TreeNode node) {
    right = node;
    return right;
  }

  public TreeNode setRight(int value) {
    right = new TreeNode(value);
    return right;
  }
}
