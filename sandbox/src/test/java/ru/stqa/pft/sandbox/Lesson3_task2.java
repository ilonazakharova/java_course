package ru.stqa.pft.sandbox;

public class Lesson3_task2 {
  public static void main(String[] args) {
    int a;
    int b;
    double Fx, x, h;
    a = 0;
    b = 4;
    h = 0.5;
    for (x = a;
         x <= b - h;
         x += h) {
      System.out.print("x= " + x + ",");
      if (x >= 0) {
        Fx = 2 * Math.tan(x / 2) + 1;
        System.out.println("Fx =" + Fx);
      }

      }
     }

  }