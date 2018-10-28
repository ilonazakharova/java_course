package ru.stqa.pft.sandbox.Task2.SecondPart;
import java.util.ArrayList;

public class Runner {
  public static void main(String[] args) {
    Bouquet bouquet = new Bouquet();
    {
      bouquet.add(new Flower("Роза", 10, 200, "белая"));
      bouquet.add(new Flower("Пион", 10, 200, "розовый"));
      bouquet.add(new Flower("Тюльпан", 10, 200, "бордовый"));
      ArrayList<Flower> flowersByName = bouquet.findFlowersByName("Роза");

      for (Flower flower: flowersByName
           ) {
        System.out.println(flower);

      }
    }
  }
}
