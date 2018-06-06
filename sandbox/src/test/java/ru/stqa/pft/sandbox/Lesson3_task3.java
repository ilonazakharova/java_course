package ru.stqa.pft.sandbox;

public class Lesson3_task3 {
  public static void main(String[] args) {
    int x = 4;
    int Fx;

    if (x <= 3) {
      Fx = 9;
      System.out.println("Fx = " + Fx);
    }

    if (x > 3) {
      Fx = 1/((x * x) + 1);
      System.out.println("Fx = " + Fx);
    }
  }

}