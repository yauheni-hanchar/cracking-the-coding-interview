package org.example.chapter3.stacks_and_queues;

import lombok.Data;

import java.util.Arrays;

public class Task3_1 {

    public static void main(String[] args){
        var multiStack = new FixedMultiStack(5);
        multiStack.push(11, 0);
        multiStack.push(12, 0);
        multiStack.push(13, 0);
        multiStack.push(14, 0);

        multiStack.push(21, 1);
        multiStack.push(22, 1);
        multiStack.push(23, 1);

        multiStack.push(31, 2);
        multiStack.push(32, 2);

        System.out.println(Arrays.toString(multiStack.getData()));

        System.out.println(multiStack.pop(1));
        System.out.println(Arrays.toString(multiStack.getData()));
        System.out.println(multiStack.pop(1));
        System.out.println(Arrays.toString(multiStack.getData()));
        System.out.println(multiStack.pop(1));
        System.out.println(Arrays.toString(multiStack.getData()));
  }

    @Data
    public static class FixedMultiStack {

        private int numberOfStacks = 3;
        private int capacity;
        private int stackSize;
        private int[] data;
        private int[] sizes = {0, 0, 0};

        public FixedMultiStack() {
            this.capacity = 9;
            data = new int[capacity];
        }

        public FixedMultiStack(int stackSize) {
            this.stackSize = stackSize;
            this.capacity = stackSize * 3;
            data = new int[capacity];
        }

        public void push(int value, int stackNum) {
            if(stackNum > numberOfStacks - 1) {
                throw new IndexOutOfBoundsException();
            }
            if (isFull(stackNum)) {
                throw new IllegalArgumentException(String.format("Stack %s is full.", stackNum));
            }
            var positionToPush = nextFreeIndexOf(stackNum);
            data[positionToPush] = value;
            sizes[stackNum]++;
        }

        public int pop(int stackNum) {
            if(isEmpty(stackNum)) {
                throw new IllegalArgumentException(String.format("Stack %s is empty.", stackNum));
            }
            var positionToPop = lastIndexOf(stackNum);
            var last = data[positionToPop];
            data[positionToPop] = 0;
            sizes[stackNum]--;
            return last;
        }

        public int peek(int stackNum) {
            if(isEmpty(stackNum)) {
                throw new IllegalArgumentException(String.format("Stack %s is empty.", stackNum));
            }
            var positionToPeek = lastIndexOf(stackNum);
            return data[positionToPeek];
        }

        public boolean isFull(int stackNum) {
            return sizes[stackNum] >= stackSize;
        }

        public boolean isEmpty(int stackNum) {
            return sizes[stackNum] <= 0;
        }

        public int nextFreeIndexOf(int stackNum) {
            return stackNum * stackSize + sizes[stackNum];
        }

        public int lastIndexOf(int stackNum) {
            return stackNum * stackSize + sizes[stackNum] - 1;
        }

    }

}
