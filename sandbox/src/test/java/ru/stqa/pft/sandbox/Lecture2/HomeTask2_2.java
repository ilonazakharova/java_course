package ru.stqa.pft.sandbox.Lecture2;

import java.util.Scanner;

public class HomeTask2_2 {
  public static void main(String[] args) {

    int a, b, c;
    double function;

    int r;
    double square;
    double length;

    Scanner conin = new Scanner(System.in);
    System.out.println("Введите a: ");
    while (!conin.hasNextInt())
      conin.next();
    a = conin.nextInt();

    System.out.println("Введите b: ");
    while (!conin.hasNextInt())
      conin.next();
    b = conin.nextInt();

    System.out.println("Введите c: ");
    while (!conin.hasNextInt())
      conin.next();
    c = conin.nextInt();

    if (a != 0) {
      System.out.println("Знаменатель a не равен нулю");
      function = (b + Math.sqrt(b * b + 4 * a * c) / 2 * a - Math.pow(a, 3) + b);
    } else {
      System.out.println("Знаменатель равен нулю");
      function = Double.NaN;
    }
    System.out.println("Значение функциии function равно = " + function);



  }
}






