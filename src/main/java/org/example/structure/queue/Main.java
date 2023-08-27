package org.example.structure.queue;


public class Main {

  public static void main(String[] args) {
    var queue = new CustomQueue<Integer>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    queue.add(5);
    queue.print();

    var first = queue.peek();
    System.out.println(first);
    queue.print();

    first = queue.remove();
    System.out.println(first);
    queue.print();
  }
}
