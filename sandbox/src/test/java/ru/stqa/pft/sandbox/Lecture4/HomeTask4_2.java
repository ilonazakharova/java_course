package ru.stqa.pft.sandbox.Lecture4;

import java.util.Arrays;

public class HomeTask4_2 {
    public static void main(String[] args) {

        int a[] = {33, 44, 66, 10, 20, 30, 40};

        int s = Arrays.stream(a).filter(x -> x % 10 == 0).sum();

        System.out.println("Сумма элементов массива, которые кратны числу фильтра равна = " + s);

      }
      }


