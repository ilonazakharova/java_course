package ru.stqa.pft.sandbox;

public class Calc1 {
  public static void main(String[] args) {
    String str1 = "string1";
    String str2 = new String("string1");
    String str3 = "string1";

    if (str1 == str2) {
      System.out.println("a");
    } else {
      System.out.println("b");
    }
    if (str1 == str3) {
      System.out.println("c");
    } else {
      System.out.println("d");
    }
  }
}
