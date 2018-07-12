package ru.stqa.pft.sandbox;

import java.util.stream.IntStream;

public class Calc2 {
  public static void main(String[] args) {
    int[] mas = new int[] {23, 54, 12, 76, 45, 98, 12, 56};
    int sum;

    int total = IntStream.of(mas).sum();
    System.out.println(total);
    }
  }

