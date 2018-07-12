package ru.stqa.pft.sandbox.Lecture3;

import java.util.Scanner;

public class Lesson3_3ColDays {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int year = 0, month = 0, col_day = 0;
    System.out.print("Введите год: ");
    if (sc.hasNextInt()) {
      year = sc.nextInt();
    }
    System.out.print("Введите номер месяца: ");
    if (sc.hasNextInt()) {
      month = sc.nextInt();
      switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:

          col_day = 31;
          break;
        case 2:
          if (year % 4 == 0) {
            col_day = 29;
          } else {
            col_day = 28;
          }
          break;
        case 4:
        case 6:
        case 9:
        case 11:
          col_day = 30;
          break;
      }
      System.out.println("Количество дней равно - " + col_day);
    }
  }
}

