package ru.stqa.pft.sandbox.Task2.SecondPart;

public class Flower {
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
    return

            "|" + name +
                    "|" + quantity +
                    "|" + price +
                    "|" + colour + "|" + "\n" +
                    "====================================" ;
  }

  public static class Rose extends Flower { Rose(String name, Integer quantity, Integer price, String colour) { super(name, quantity, price, colour); } }

  public static class Pion extends Flower { Pion(String name, Integer quantity, Integer price, String colour) { super(name, quantity, price, colour); } }

  public static class Tulipa extends Flower { Tulipa(String name, Integer quantity, Integer price, String colour) { super(name, quantity, price, colour); } }

  public static class Dianthus extends Flower { Dianthus(String name, Integer quantity, Integer price, String colour) { super(name, quantity, price, colour); } }

  public static class Convallaria extends Flower { Convallaria(String name, Integer quantity, Integer price, String colour) { super(name, quantity, price, colour); } }

  public static class Syrigna extends Flower { Syrigna(String name, Integer quantity, Integer price, String colour) { super(name, quantity, price, colour); } }
}