package ru.stqa.pft.sandbox.Lecture2;

import java.util.Scanner;

public class HomeTask2_3 {
  public static void main(String[] args) {
    int r;
    double square;
    double length;

    Scanner conin = new Scanner(System.in);
    System.out.println("Введите значение радиуса окружности r: ");
    while (!conin.hasNextInt())
      conin.next();
    r = conin.nextInt();

    if (r != 0) {
      System.out.println("Радиус окружности не равен нулю, можно продолжать расчеты");
      square = 3.14 * r * r;

    } else {
      System.out.println("Радиус окружности равен нулю");
      square = Double.NaN;
    }
    System.out.println("Значение площади круга равно = " + square);

    if (r != 0) {
      System.out.println("Радиус окружности не равен нулю, можно продолжать расчеты");
      length = 3.14 * r * r;

    } else {
      System.out.println("Радиус окружности равен нулю");
      length = Double.NaN;
    }
    System.out.println("Значение длины окружности равно = " + length);
  }
}

