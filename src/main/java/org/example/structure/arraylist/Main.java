package org.example.structure.arraylist;

public class Main {

  public static void main(String[] args) {
    CustomArrayList<Integer> a = new CustomArrayList<>();
    for (int i = 0; i < 5; i++) {
      a.add(i);
    }

    for (int i = 0; i < a.size(); i++) {
      System.out.println(a.get(i));
    }
  }
}
