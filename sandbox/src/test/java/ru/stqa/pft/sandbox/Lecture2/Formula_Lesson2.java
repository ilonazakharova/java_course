package ru.stqa.pft.sandbox.Lecture2;

import java.util.Scanner;

public class Formula_Lesson2 {
  public static void main (String[] args) {
    double x = 0,
            y = 0, z;
    Scanner sc = new Scanner(System.in); //создание объекта, констурктор class object
    // объявление переменной
    //имя класса + идентификатор
    // ссылочный тип переменной
    //читать данные с клавиатуры
    //создаем объект типа Scanner

    System.out.println("Ввведите x: ");
    if (sc.hasNextDouble()) {

    }
    System.out.println("Введите y: ");
    if (sc.hasNextDouble()) {
      y = sc.nextDouble(); //как он себя ведет
     }
     double temp;
    temp = Math.cos(x) - x / 3;
    if (temp != 0) {
      z = x * Math.log(x) + y / temp;
    } else {
      System.out.println("Знаменатеь равен нулю");
      z = Double.NaN;
    }
    System.out.println("z = " + z);
    }
  }

