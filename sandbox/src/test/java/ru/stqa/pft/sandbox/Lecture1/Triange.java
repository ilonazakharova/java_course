package ru.stqa.pft.sandbox.Lecture1;

public class Triange {
  public static void main(String[] args) {
    double a, b; // два катета
    double c = 0; // гипотенуза
    double p; // периметр
    double s; // площадь
    a = 10;
    b = 20;
    c = Math.sqrt(a * a + b * b);
    p = a + b + c;
    s = 0.5 * a * b;
    System.out.println("Периметр = " + p + " площадь = " + s);
    System.out.println("Длина гипотенузы прямоугольного треугольника = " + c);
  }
}

