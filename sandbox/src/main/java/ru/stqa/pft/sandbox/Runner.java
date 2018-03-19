package ru.stqa.pft.sandbox;

public class Runner {

  public static void main(String[] args) {


    Point p1 = new Point(4.0, 6.0);
    Point p2 = new Point(6.1, 7.2);


    System.out.println("Координаты точки p1: x = " + p1.x + ", y = " + p1.y);
    System.out.println("Координаты точки p2: x = " + p2.x + ", y = " + p2.y);
    System.out.println("Расстояние между точками p1 и p2 = " + p1.distance(p2));

  }
}