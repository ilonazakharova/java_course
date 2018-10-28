package ru.stqa.pft.sandbox.Task2.FirstPart;

import java.util.ArrayList;

public class Bouquet {
  private int price;
  private static ArrayList<Flower> flowers;

  @Override
  public String toString() {
    return "Payment{" +
            "price=" + price +
            ", producerName='" + producerName + '\'' +
            '}';
  }

  private String producerName;

  public Bouquet() {
    this.price = price;
    this.producerName = producerName;
  }

  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Bouquet bouquet = (Bouquet) obj;
    if (price != bouquet.price) {
      return false;
    }
    if (null == producerName) {
      return (producerName == bouquet.producerName);
    } else {
      if (!producerName.equals(bouquet.producerName)) {
        return false;
      }
    }
    return true;
  }

  public int hashCode() {
    return (int) (31 * price + ((null == producerName) ? 0 : producerName
            .hashCode()));
  }

  public static void main(String[] args) {
    flowers = new ArrayList<>();
    {
      flowers.add(new Flower.Rose("Роза", 10, 200, "белая"));
      flowers.add(new Flower.Pion("Пион", 10, 200, "розовый"));
      flowers.add(new Flower.Tulipa("Тюльпан", 10, 200, "бордовый"));
      flowers.add(new Flower.Dianthus("Гвоздика", 10, 200, "белая"));
      flowers.add(new Flower.Convallaria("Ландыш", 10, 200, "белый"));
      flowers.add(new Flower.Syrigna("Сирень", 10, 200, "фиолетовая"));

      int count = 0;
      int totalprice = 0;

      for (int i = 0; i < flowers.size(); i++) {

        Flower flower = flowers.get(i);
        count = flower.getQuantity() + count;
        totalprice = flower.getPrice() * flower.getQuantity() + totalprice;
        System.out.println(flower);

      }
      System.out.println("Количество уникальных цветов в букете = " + flowers.size());
      System.out.println("Количество цветков в букете = " + count);
      System.out.println("Стоимость букета = " + totalprice);

    }
  }


  public void add(Flower flower) { flowers.add(flower); }

  public void remove(Flower flower) { flowers.remove(flower); }

  public ArrayList<Flower> findFlowersByName(String name) {
    ArrayList<Flower> resultFlowers = new ArrayList<>();
    for (Flower flower : flowers) {
      if (flower.getName().contains(name)) {
        resultFlowers.add(flower);
      }

    }

    return resultFlowers;
  }
}





