package ru.stqa.pft.sandbox.Lecture10;

import java.util.ArrayList;

public class Runner {
  public static void main(String[] args) {
    Library library = new Library();


    {
      library.add(new Book("Название книги №1", "Имя автора1", 100, 1000, 100));
      library.add(new Book("Название книги №2", "Имя автора2", 200, 2000, 200));
      library.add(new Book("Название книги №3", "Имя автора3", 300, 3000, 300));
      library.add(new Book("Название книги №4", "Имя автора4", 400, 4000, 400));
      library.add(new Book("Название книги №5", "Имя автора5", 500, 5000, 500));
      library.remove(new Book("Название книги №5", "Имя автора5", 500, 5000, 500));
      ArrayList<Book> booksByName = library.findBooksByName("Название книги №3");

      for (Book book: booksByName
           ) {
        System.out.println(book);

      }

    }
  }
}
