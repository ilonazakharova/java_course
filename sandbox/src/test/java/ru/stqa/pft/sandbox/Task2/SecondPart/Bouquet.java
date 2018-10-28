package ru.stqa.pft.sandbox.Task2.SecondPart;

import java.util.ArrayList;

public class Bouquet {
  @Override
  public String toString() { return "Bouquet{}"; }

  private ArrayList<Flower> flowers = new ArrayList<>();

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

