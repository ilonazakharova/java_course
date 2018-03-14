package ru.stqa.pft.sandbox;

public class Runner {

  public static void main(String[] args) {
    Point p1 = new Point();
    Point p2 = new Point();

    p1.x = 4;
    p1.y = 5;
    p2.x = 6;
    p2.y = 7;


    System.out.println("Координаты точки p1: x = " + p1.x + ", y = " + p1.y);
    System.out.println("Координаты точки p2: x = " + p2.x + ", y = " + p2.y);
    System.out.println("Расстояние между точками p1 и p2 = " + distance(p1, p2));

  }

  public static double distance (Point p1, Point p2) {
    double distance = Math.sqrt((Math.pow((p2.x - p1.x),2) + Math.pow((p2.y - p1.y),2)));
    return distance;
  }
}


