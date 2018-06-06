package ru.stqa.pft.sandbox;

import java.util.Scanner;

public class Lesson3_4Line01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number = 0;
    int digit = 0;
    System.out.print("Введите число: ");
    if (sc.hasNextInt())
      number = sc.nextInt();
    while (number != 0) {
      digit = number % 10;
      number = number / 10;
      if (digit % 2 == 0) {
        System.out.println("В числе есть четная цифра.");
        return;
      }
    }
    System.out.println("В числе нет четных цифр.");
  }
}

