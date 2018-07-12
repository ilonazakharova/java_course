package ru.stqa.pft.sandbox.Lecture1;

import ru.stqa.pft.sandbox.Rectangle;
import ru.stqa.pft.sandbox.Square;

public class MyFirstProgram {

  public static void main(String[] args) {
    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());


    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

}