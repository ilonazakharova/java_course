package ru.stqa.pft.sandbox.Lecture10;

import java.util.ArrayList;

public class Library {
  @Override
  public String toString() {
    return "Library{}";
  }

  private ArrayList<Book> books = new ArrayList<>();

  public void add(Book book) {
    books.add(book);
  }

  public void remove(Book book) {
    books.remove(book);
  }

  public ArrayList<Book> findBooksByName(String name) {
    ArrayList<Book> resultBooks = new ArrayList<>();
    for (Book book : books) {
      if (book.getName().contains(name)) {
        resultBooks.add(book);
      }
    }
    return resultBooks;

  }

}

// public static void main(String[] args) {
     // }
