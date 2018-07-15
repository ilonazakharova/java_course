package ru.stqa.pft.sandbox.Lecture8;

import java.util.ArrayList;

public class Payment {
  private int price;
  private static ArrayList<Thing> things;

  @Override
  public String toString() {
    return "Payment{" +
            "price=" + price +
            ", producerName='" + producerName + '\'' +
            '}';
  }

  private String producerName;

  public Payment(int price, String producerName) {
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
    Payment payment = (Payment) obj;
    if (price != payment.price) {
      return false;
    }
    if (null == producerName) {
      return (producerName == payment.producerName);
    } else {
      if (!producerName.equals(payment.producerName)) {
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

    things = new ArrayList<>();

    {
      things.add(new Thing.Dress("Samsung Galaxy G5    ", 10, 200));
      things.add(new Thing.Phone("iPhoneX              ", 1, 1000));
      things.add(new Thing.Thirt("Платье от Marc Jacobs", 1, 1000));
      
      int count = 0;
      int totalprice = 0;

      for (int i = 0; i < things.size(); i++) {

       Thing thing = things.get(i);
       count = thing.getQuantity() + count;
       totalprice = thing.getPrice() * thing.getQuantity()  + totalprice;
       System.out.println(thing);

      }
      System.out.println("Количество уникальных позиций в чеке = " + things.size());
      System.out.println("Количество товаров в чеке = " + count);
      System.out.println("Сумма товаров в чеке = " + totalprice);

      }
    }
  }


