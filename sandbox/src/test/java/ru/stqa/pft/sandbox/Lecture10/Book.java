package ru.stqa.pft.sandbox.Lecture10;

public class Book{
  public String name;
  public String author;
  public Integer pages;
  public Integer year;
  public Integer price;

  Book(String name, String author, Integer pages, Integer year, Integer price) {
    this.name = name;
    this.author = author;
    this.pages = pages;
    this.year = year;
    this.price = price;
  }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getAuthor() { return author; }
  public void setAuthor(String author) { this.author = author; }

  public Integer getPages() { return pages; }
  public void setPages(int pages) { this.pages = pages; }

  public Integer getYear(int index) { return year; }
  public void setYear(int year) { this.year = year; }

  public Integer getPrice() { return price; }
  public void setPrice(int price) { this.price = price; }

  @Override
  public String toString() {
    return
            "|" + name +
            "|" + author  +
            "|" + pages +
            "|" + year +
            "|" + price + "|" + "\n" +
              "==============================================="
            ;
  }

  //наследник Энциклопедия
  public static class Encyclopedia extends Book {
    Encyclopedia(String name, String author, Integer pages, Integer year, Integer price) {
      super(name, author, pages, year, price);
    }
  }

  public static class Dictionary extends Book {
    //наследник Словарь
    Dictionary(String name, String author, Integer pages, Integer year, Integer price) {
      super(name, author, pages, year, price);
    }
  }

  //наследник Букварь
  public static class Abcbook extends Book {
    Abcbook(String name, String author, Integer pages, Integer year, Integer price) {
      super(name, author, pages, year, price);
    }
  }
}
