package ru.stqa.pft.sandbox.Lecture8;

import java.util.Objects;

public class BankAccount {
    private int id;
    private String firstName;
    private String lastName;
    private Double money;
    private String currency;

    public int getId() { return id; }
    public void setId(int id) { this.id = id;}

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Double getMoney() { return money; }
    public void setMoney(Double money) { this.money = money; }

  public String getCurrency() { return currency; }
  public void setCurrency(String currency) { this.currency = currency; }

  @Override
  public String toString() {
    return "BankAccount{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", money=" + money +
            ", currency='" + currency + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BankAccount that = (BankAccount) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(money, that.money) &&
            Objects.equals(currency, that.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, money, currency);
  }

}