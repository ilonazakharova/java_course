package ru.stqa.pft.sandbox.Lecture5;

public class ArrayFraction {
 public double n;     //числитель
 public double d;  //знаменатель

 // double[] n = {2, 4, 6, 8, 10};
  //double[] d = {3, 5, 7, 9, 11};


  //создаем конструктор (имя конструктора должно совпадать с именем класса,
  // и не имеет никакого возвращаемого значения, тип данных не указывается перед названием конструктора)
  //конструктор как функция может принимать параметры
  public ArrayFraction(double n, double d) {
    this.n = n; //используем ключевое слово this - это ссылка на объект
    this.d = d;

  }
}
