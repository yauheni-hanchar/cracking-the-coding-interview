package org.example.chapter5.bit_manipulation;

import static java.lang.Integer.toBinaryString;

public class Task5_8 {

  public static void main(String[] args) {
    byte[] screen = {
      0b00000000, 0b00000000, 0b00000000,
      0b00000000, 0b00000000, 0b00000000,
      0b00000000, 0b00000000, 0b00000000
    };
    drawLine(screen, 24, 2, 6, 1);
  }

  public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
    var startOffset = x1 % 8;
    var firstFullByte = x1 / 8;
    if (startOffset != 0) {
      firstFullByte++;
    }

    var endOffset = x2 % 8;
    var lastFullByte = x2 / 8;
    if (endOffset != 0) {
      lastFullByte--;
    }

    for (int i = firstFullByte; i <= lastFullByte; i++) {
      screen[(width / 8) * y + i] = (byte) 0xFF;
    }

    var startMask = (byte) (0xFF >>> startOffset);
    var endMask = (byte) ~(0xFF >>> (endOffset + 1));
    var startIndexOfRow = (width / 8) * y;

    if ((x1 / 8) == (x2 / 8)) {
      screen[startIndexOfRow + firstFullByte - 1] = (byte) (startMask & endMask);
    } else {
      if (startOffset != 0) {
        screen[startIndexOfRow + firstFullByte - 1] = startMask;
      }
      if (endOffset != 7) {
        screen[startIndexOfRow + lastFullByte + 1] = endMask;
      }
    }

    for (int i = 0; i < screen.length; i++) {
      if (i % (width / 8) == 0) {
        System.out.println();
      }
      System.out.print(String.format("%8s", toBinaryString(screen[i] & 0xFF)).replace(' ', '0'));
    }
  }
}
