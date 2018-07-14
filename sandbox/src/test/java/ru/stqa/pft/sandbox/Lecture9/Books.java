package ru.stqa.pft.sandbox.Lecture9;

public class Books extends Library {
  public String name;
  public String author;
  public Integer pages;
  public Integer year;

  Books(String name, String author, Integer pages, Integer year) {
    this.name = name;
    this.author = author;
    this.pages = pages;
    this.year = year;
  }

  public String getName() { return name; }
  public void setName(String title) { this.name = name; }

  public String getAuthor() { return author; }
  public void setAuthor(String author) { this.author = author; }

  public Integer getPages() { return pages; }
  public void setPages(int price) { this.pages = pages; }

  public Integer getYear() { return year; }
  public void setYear(int year) { this.year = year; }

  //наследник Энциклопедия
  public static class Encyclopedia extends Books {

    Encyclopedia(String name, String author, Integer pages, Integer year) {
      super(name, author, pages, year);
      this.name = name;
      this.author = author;
      this.pages = pages;
      this.year = year;
    }
    public String getName() { return name;}
    public String getAuthor() { return author;}
    public Integer getPages() { return pages;}
    public Integer getYear() { return year;}
  }

  public static class Dictionary extends Books {
    //наследник Словарь
    Dictionary(String name, String author, Integer pages, Integer year) {
      super(name, author, pages, year);
      this.name = name;
      this.author = author;
      this.pages = pages;
      this.year = year;
    }
    public String getName() { return name;}
    public String getAuthor() { return author;}
    public Integer getPages() { return pages;}
    public Integer getYear() { return year;}
  }

  //наследник Букварь
  public static class Abcbook extends Books {
    Abcbook(String name, String author, Integer pages, Integer year) {
      super(name, author, pages, year);
      this.name = name;
      this.author = author;
      this.pages = pages;
      this.year = year;
    }
    public String getName() { return name;}
    public String getAuthor() { return author;}
    public Integer getPages() { return pages;}
    public Integer getYear() { return year;}
  }
}




