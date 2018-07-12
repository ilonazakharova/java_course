package ru.stqa.pft.sandbox.Lecture5;

public class Photo {
  public double length;
  public double height;


  public Photo (double length, double height) {
    this.length = length; //используем ключевое слово this - это ссылка на объект
    this.height = height;
    if (length > 10) {
      System.out.println("Цена на фотографию будет равна = 20 $");
    }

    if (length > 20) {
      System.out.println("Цена на фотографию будет равна = 30 $");
    }

    if (length == height) {
      System.out.println("Цена на фотографию будет равна = 25$");
    }

    if (height < 0) {
      System.out.println("Вы ввели невалидное значение, возможно опечатка");
    }

    if (length < 0) {
      System.out.println("Вы ввели невалидное значение, возможно опечатка");
    }
  }
}
