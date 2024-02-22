package org.example.chapter15.threads_and_locks;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

public class Task15_3 {

  private static Random r = new Random();

  public static void main(String[] args) {
    printWithCurrentThread();
    var count = 5;
    var chopsticks = new Chopsticks(count);
    var philosophers =
        IntStream.range(0, count).mapToObj(i -> new Philosopher(i, chopsticks)).toList();
    philosophers.forEach(Philosopher::start);
  }

  @AllArgsConstructor
  public static class Philosopher extends Thread {

    private int number;
    private Chopsticks chopsticks;

    @SneakyThrows
    @Override
    public void run() {
      for (int i = 0; i < 2; i++) {
        if (pickUp()) {
          chew();
          putDown();
        }
      }
    }

    public boolean pickUp() {
      if (!chopsticks.pickUpLeft(number)) {
        return false;
      }
      if (!chopsticks.pickUpRight(number)) {
        chopsticks.putDownLeft(number);
        return false;
      }
      return true;
    }

    public void putDown() {
      chopsticks.putDownRight(number);
      chopsticks.putDownLeft(number);
    }

    @SneakyThrows
    public void chew() {
      printWithCurrentThread("chewing");
      //      Thread.sleep(1000);
    }
  }

  @Data
  public static class Chopsticks {
    private List<Chopstick> list;

    public Chopsticks(int count) {
      list = IntStream.range(0, count).mapToObj(i -> new Chopstick()).toList();
    }

    public boolean pickUpLeft(int num) {
      boolean isPicked = list.get(num).pickUp();
      printWithCurrentThread("+L " + num + " " + isPicked);
      return isPicked;
    }

    public boolean pickUpRight(int num) {
      var i = (num + 1) % list.size();
      boolean isPicked = list.get(i).pickUp();
      printWithCurrentThread("+R " + i + " " + isPicked);
      return isPicked;
    }

    public void putDownLeft(int num) {
      printWithCurrentThread("-L " + num);
      list.get(num).putDown();
    }

    public void putDownRight(int num) {
      var i = (num + 1) % list.size();
      printWithCurrentThread("-R " + i);
      list.get(i).putDown();
    }
  }

  public static class Chopstick {
    private final Lock lock = new ReentrantLock();

    @SneakyThrows
    public boolean pickUp() {
      return lock.tryLock(r.nextInt(1000), TimeUnit.MILLISECONDS);
    }

    public void putDown() {
      lock.unlock();
    }
  }

  public static void printWithCurrentThread() {
    printWithCurrentThread("");
  }

  public static void printWithCurrentThread(String message) {
    System.out.println(Thread.currentThread().getName() + ": " + message);
  }
}
