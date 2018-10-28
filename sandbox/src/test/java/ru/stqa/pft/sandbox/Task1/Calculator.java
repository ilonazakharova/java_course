package ru.stqa.pft.sandbox.Task1;

import java.util.Scanner;

public class Calculator {

  public static void main(String[] args) {
    double x, y, sum, mul, dif, raz;

    Scanner conin = new Scanner(System.in);
    System.out.println("Введите число №1: ");
    while (!conin.hasNextInt())
      conin.next();
    x = conin.nextInt();
    System.out.println("Введите число №2: ");
    while (!conin.hasNextInt())
      conin.next();
    y = conin.nextInt();


    if (y != 0 | x != 0 && y !=0) {
      System.out.println("Мы не делим на 0, можно продолжать расчеты");
      dif = x / y;

    } else {
      System.out.println("Делимое или делитель равен/равны нулю, это исключительная ситуация, которая привела к ошибке");
      dif = Double.NaN;
      sum = x + y;
      mul = x * y;
      raz = x - y;
      System.out.println("Сумма чисел №1 и №2 = " + sum);
      System.out.println("Разность чисел №1 и №2 = " + raz);
      System.out.println("Произведение чисел №1 и №2 = " + mul);
    }

    sum = x + y;
    mul = x * y;
    dif = x / y;
    raz = x - y;


    System.out.println("Сумма чисел №1 и №2 = " + sum);
    System.out.println("Разность чисел №1 и №2 = " + raz);
    System.out.println("Произведение чисел №1 и №2 = " + mul);
    System.out.println("Деление числа №1 на №2 = " + dif);
  }

}
