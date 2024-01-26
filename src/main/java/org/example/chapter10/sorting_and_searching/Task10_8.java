package org.example.chapter10.sorting_and_searching;

import lombok.Data;

public class Task10_8 {

  public static void main(String[] args) {
    var array = new int[] {2, 2, 1523, 154, 3, 31999, 4636, 123, 5153, 1235, 1235, 3, 1235, 125};
    printDuplicates(array);
  }

  private static void printDuplicates(int[] array) {
    var bitSet = new BitSet(32000);
    for (int num : array) {
      var index = num - 1;
      if (bitSet.get(index)) {
        System.out.println(num);
      } else {
        bitSet.set(index);
      }
    }
  }

  @Data
  public static class BitSet {

    private byte[] bitsArray;
    private int lastIndex;

    public BitSet(int bits) {
      if (bits < 1) {
        throw new IllegalArgumentException();
      }
      bitsArray = new byte[(bits >> 3) + 1];
      lastIndex = bits - 1;
    }

    public void set(int index) {
      var wordNum = index >> 3;
      var bitNum = index & 7; // mod 8
      bitsArray[wordNum] |= (byte) (1 << bitNum);
    }

    public boolean get(int index) {
      var word = bitsArray[index >> 3];
      return (word & (1 << (index & 7))) != 0;
    }
  }
}
