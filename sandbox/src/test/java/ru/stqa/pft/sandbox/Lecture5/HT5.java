package ru.stqa.pft.sandbox.Lecture5;

public class HT5 {
  public static void main(String[] args) {
      System.out.println("=======================================================================");
      Frac f = new Frac(6, 10);
      System.out.println("2. Дробь в обычном виде выглядит так = " + f.numerator + "/"
              + f.denominator);
      System.out.println("3. Дробь в десятичном виде выглядит так = " + drobishka1(f) + ","
              + "\n" + "если числитель дроби равен = " + f.numerator + ", "
              + "а знаменатель дроби равен = " + f.denominator);

      System.out.println("=======================================================================");

    }

    public static double drobishka1 (Frac f){
      return f.numerator / f.denominator;
    }

    public static double drobishka2 (double numerator, double denominator) {
      return numerator / denominator ;
    }


  }


  //внутри класса объявить псевдо-функцию (это конструктор),
// нужна для заполнения атрибутов объекта какими-то значениями, которые передаютя в качестве параметра в конструктор

