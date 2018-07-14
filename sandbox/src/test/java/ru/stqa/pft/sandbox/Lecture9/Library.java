package ru.stqa.pft.sandbox.Lecture9;

public class Library {
  public static void main(String[] args) {

    Books.Dictionary dictionary = new Books.Dictionary("Словарь русского языка", "Игорь Даль", 500, 1950);
    Books.Encyclopedia encyclopedia = new Books.Encyclopedia("Энциклопедия русского языка", "Игорь Даль", 5000, 1940);
    Books.Abcbook abcbook = new Books.Abcbook("Букварь", "Игорь Даль", 100, 1940);
  }
}
