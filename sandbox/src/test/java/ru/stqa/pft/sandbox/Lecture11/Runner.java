package ru.stqa.pft.sandbox.Lecture11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Runner {
  public static void main(String[] args) {
    Library library = new Library();


    {
      library.add(new Book("Название книги №1", "Имя автора1", 100, 1000, 100));
      library.add(new Book("Название книги №2", "Имя автора2", 200, 2000, 200));
      library.add(new Book("Название книги №3", "Имя автора3", 300, 3000, 300));
      library.add(new Book("Название книги №4", "Имя автора4", 400, 4000, 400));

      library.add(new Book("Название книги №10", "Пушкин", 500, 5000, 5000));
      library.add(new Book("Название книги №11", "Пушкин", 500, 5000, 4000));
      library.add(new Book("Название книги №12", "Пушкин", 500, 5000, 3000));
      library.add(new Book("Название книги №13", "Пушкин", 500, 5000, 2000));
      library.add(new Book("Название книги №14", "Пушкин", 500, 5000, 1000));


      library.remove(new Book("Название книги №5", "Имя автора5", 500, 5000, 500));



      ArrayList<Book> booksByName = library.findBooksByAuthor("Пушкин");

      Collections.sort(booksByName, new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
          int result = b1.getPrice() - b2.getPrice();
          if (result > 0) {
            return 1;
          }
          else if (result < 0) {
            return -1;
          }
          else {return 0;}
        }
      });

      Collections.sort(booksByName, new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
          int result = b1.getYear() - b2.getYear();
          if (result > 0) {
            return 1;
          }
          else if (result < 0) {
            return -1;
          }
          else {return 0;}
        }
      });



      for (Book book: booksByName
           ) {
        System.out.println("Cписок найденных книг");
        System.out.println(book);

      }

    }
  }
}
