package org.example.structure.arraylist;

import java.util.Arrays;

public class CustomArrayList<T> {

  private final int DEFAULT_CAPACITY = 10;
  private Object[] storage;
  private int lastFreeIndex;

  public CustomArrayList() {
    storage = new Object[DEFAULT_CAPACITY];
  }

  public CustomArrayList(int capacity) {
    storage = new Object[capacity];
  }

  public void add(T element) {
    var newCapacity = storage.length + (storage.length >> 1);
    if (lastFreeIndex >= storage.length) {
      storage = Arrays.copyOf(storage, newCapacity);
    }
    storage[lastFreeIndex] = element;
    lastFreeIndex++;
  }

  @SuppressWarnings("unchecked")
  public T get(int index) {
    return (T) storage[index];
  }

  public int size() {
    return lastFreeIndex;
  }

  // remove

  // set

  // add on index

  // contains

  // indexOf

  public boolean isEmpty() {
    return storage.length == 0;
  }
}
