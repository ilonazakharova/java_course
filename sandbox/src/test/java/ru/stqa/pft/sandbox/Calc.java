package ru.stqa.pft.sandbox;

public class Calc {
  public static void main (String[] args) {
    double x = 3.4;
    double y = 5.6;
    double z = 7.8;



    double result;
    result = func (x, y, z);
    System.out.println("result = " + result);
  }

  private static double func(double a, double b, double c) {
    return a+b+c;
  }
}
