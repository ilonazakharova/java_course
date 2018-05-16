package ru.stqa.pft.sandbox;

public class Formula {
  public static void main(String[] args) {
    double x = 0, y = 0, z;
    x = 10.2;
    y = 13.6;
    double temp;
    temp = Math.cos(x) - x / 3;
    if (temp != 0) {
      z = x * Math.log(x) + y / temp;
    } else {
      System.out.println("Знаменатель равен нулю.");
      z = Double.NaN;
    }
    System.out.println("z=" + z);
  }
}

