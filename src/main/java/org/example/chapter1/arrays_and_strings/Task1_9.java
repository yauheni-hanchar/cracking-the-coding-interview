package org.example.chapter1.arrays_and_strings;

public class Task1_9 {

  public static void main(String[] args) {
    var result = isRotation("waterbottle", "erbottlewat");
    System.out.println(result);
  }

  public static boolean isRotation(String str1, String str2) {
    if(str1.length() != str2.length()) {
      return false;
    }
    var concatenated = str1 + str1;
    return concatenated.contains(str2);
  }
}
