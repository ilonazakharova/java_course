package ru.stqa.pft.sandbox.Lecture11;

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

  public ArrayList<Book> findBooksByAuthor(String author) {
    ArrayList<Book> resultBooks = new ArrayList<>();
    for (Book book : books) {
      if (book.getAuthor().contains(author)) {
        resultBooks.add(book);
      }
    }
    return resultBooks;

  }



}

// public static void main(String[] args) {
     // }
