package ru.stqa.pft.sandbox.Lecture8;

public class Thing {
  public String name;
  public Integer quantity;
  public Integer price;

  Thing(String name, Integer quantity, Integer price) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return

                    "|" + name +
                    "|" + quantity +
                    "|" + price + "|" + "\n" +
                    "===================================="
            ;
  }


  public static class Dress extends Thing {
    Dress(String name, Integer quantity, Integer price) {
      super(name, quantity, price);
    }

  }

    public static class Phone extends Thing {
      Phone(String name, Integer quantity, Integer price) {
        super(name, quantity, price);
      }
    }


      public static class Thirt extends Thing {
        Thirt(String name, Integer quantity, Integer price) {
          super(name, quantity, price);
        }
      }
      }










