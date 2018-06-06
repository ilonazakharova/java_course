package ru.stqa.pft.sandbox;

import java.util.Scanner;

public class SumAndMul_Lesson2 {
  public static void main(String[] args) {
    int x, y, sum, mul;

    Scanner conin = new Scanner(System.in);
    System.out.println("Введите x: ");
    while (!conin.hasNextInt())
      conin.next();
   x = conin.nextInt();
    System.out.println("Введите y: ");
    while (!conin.hasNextInt())
      conin.next();
    y = conin.nextInt();
    sum = x + y;
    mul = x * y;
    System.out.println("sum = " + sum + "; mul = " + mul);
  }


}
