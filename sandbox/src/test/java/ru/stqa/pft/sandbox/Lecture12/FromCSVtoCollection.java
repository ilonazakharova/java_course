package ru.stqa.pft.sandbox.Lecture12;


import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FromCSVtoCollection {
  public static void main(String [] args) {
    List<Book> books = readBooksFromCSV("E:\\books.csv");


    for (Book b : books) System.out.println(b);
  }
  private static List<Book> readBooksFromCSV(String fileName) {
    List<Book> books = new ArrayList<>();
    Path pathToFile = Paths.get(fileName);
    try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
      String line = br.readLine();
      while (StringUtils.isNotEmpty(line)) {
        String[] attributes = line.split(";");
        Book book = createBook(attributes);
        books.add(book);
        line = br.readLine();
      }

    }catch (IOException ioe) {
      ioe.printStackTrace();
    }
    return books;
  }

  private static Book createBook(String[] metadata) {
    String name = metadata[0];
    String author = metadata[1];
    int pages = Integer.parseInt(metadata[2]);
    int year = Integer.parseInt(metadata[3]);
    int price = Integer.parseInt(metadata[4]);
    return new Book(name, author, pages, year, price);
  }

}

   class Book {
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
  public void setPages(Integer pages) { this.pages = pages; }

  public int getYear() { return year; }
  public void setYear(int year) { this.year = year; }


  @Override
  public String toString() {
    return "Название = " + name + "," +
            " Автор = " + author + "," +
            " Количество страниц = " + pages + "," +
            " Год выпуска = " + year + "," +
            " Цена = " + price;
  }
}


