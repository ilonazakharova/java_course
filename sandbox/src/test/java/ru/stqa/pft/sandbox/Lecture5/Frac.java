package ru.stqa.pft.sandbox.Lecture5;

public class Frac {

    //задаю атрибуты дроби
    public double numerator;     //числитель
    public double denominator;  //знаменатель


    //создаем конструктор (имя конструктора должно совпадать с именем класса,
    // и не имеет никакого возвращаемого значения, тип данных не указывается перед названием конструктора)
    //конструктор как функция может принимать параметры
    public Frac (double numerator, double denominator){
      this.numerator = numerator; //используем ключевое слово this - это ссылка на объект
      this.denominator = denominator;
      if (Math.abs(numerator) < Math.abs(denominator)) {
        System.out.println("1. Эта дробь рациональная");
      }

      if (Math.abs(numerator) > Math.abs(denominator)) {
        System.out.println("1. Эта дробь неправильная");
      }

      if (Math.abs(numerator) == Math.abs(denominator)) {
        System.out.println("1. Совпадение! Знаменатель и числитель равны друг другу! Получили 1 в результате деления");
      }

      if (numerator == 0) {
        System.out.println("1. У этой дроби числитель равен = 0, поэтому результат деления числителя и знаменателя равен = 0");
      }

      if (denominator == 0) {
        System.out.println("! Делить на ноль нельзя");
      }

    }
  }

  //1 numerator - атрибут
  //2 numerator - переменная, которая объявлена как аргумент функции




