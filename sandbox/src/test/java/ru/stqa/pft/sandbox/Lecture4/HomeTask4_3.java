package ru.stqa.pft.sandbox.Lecture4;
import static java.lang.System.out;
public class HomeTask4_3 {

    public static void main(String[] args) {
      int m = 0;
      int[]mas1 = new int[6];
      for(int i = 0; i < mas1.length; i++ ){
        mas1[i] = (int)(Math.random()*89 + 10);
        System.out.print(mas1[i]+ " ");
      }
      m = 1;

      System.out.println("\n");
      for(int i = 0, j = 1; i<mas1.length-1; i++, j++){if(mas1[i]>mas1[j]){ m++; }
      }

      if(m==mas1.length){ System.out.println("Массив возрастает"); }
      if(m<((mas1.length)-1)){ System.out.println("Массив не возрастающий"); }
    }
  }

