package ru.stqa.pft.sandbox.Lecture4;
import java.util.ArrayList;
public class HomeTask4_4 {
    private static ArrayList<Integer> getArray(int ... nums) {
      ArrayList<Integer> arrNums = new ArrayList<>();

      for (int i = 0; i < nums.length; i++)
        if (nums[i] == 0) arrNums.add(i);

      return arrNums;
    }

    public static void main(String[] args) {
      ArrayList<Integer> arr = getArray(0, 1, 0, 2, 0, 3, 0, 4, 0, 5);

      for (int anArr : arr) System.out.print(anArr + " ");
    }
  }

