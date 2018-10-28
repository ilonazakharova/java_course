package ru.stqa.pft.sandbox.Task3;
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
    List<Flower> flowers = readFlowersFromCSV("E:\\flowers.csv");
    for (Flower f : flowers) System.out.println(f);
  }
  private static List<Flower> readFlowersFromCSV(String fileName) {
    List<Flower> flowers = new ArrayList<>();
    Path pathToFile = Paths.get(fileName);
    try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
      String line = br.readLine();
      while (StringUtils.isNotEmpty(line)) {
        String[] attributes = line.split(";");
        Flower flower = createFlower(attributes);
        flowers.add(flower);
        line = br.readLine();
      }

    }catch (IOException ioe) {
      ioe.printStackTrace();
    }
    return flowers;
  }

  private static Flower createFlower(String[] metadata) {
    String name = metadata[0];
    int quantity = Integer.parseInt(metadata[1]);
    int price = Integer.parseInt(metadata[2]);
    String colour = metadata[3];
    return new Flower(name, quantity, price, colour);
  }

}

class Flower {
  public String name;
  public Integer quantity;
  public Integer price;
  public String colour;


 Flower(String name, Integer quantity, Integer price, String colour) {
   this.name = name;
   this.quantity = quantity;
   this.price = price;
   this.colour = colour;
 }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }

  public Integer getPrice() { return price; }
  public void setPrice(int price) { this.price = price; }

  public String getColour() { return colour; }
  public void setColour(String colour) { this.colour = colour; }

  @Override
  public String toString() {
    return "Название = " + name + "," +
            " Количество = " + quantity + "," +
            " Цена = " + price + "," +
            " Цвет = " + colour;

  }
}


