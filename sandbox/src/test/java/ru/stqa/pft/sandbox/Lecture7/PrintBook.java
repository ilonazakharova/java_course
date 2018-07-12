package ru.stqa.pft.sandbox.Lecture7;

  public class PrintBook {
    public static void main(String[] args) {
      PrintBook test = new PrintBook();
      test.print(10);
      test.print('a', 2);
      test.print();
      test.print(2.3);
      test.print(1, 'g');
    }
    public void print(int x) {
      System.out.println("public void print(int x)");
    }
    public void print(char x, int y) {
      System.out.println("public void print(char x, int y)");
    }
    public void print() {
      System.out.println("public void print()");
    }
    public int print(double w) {
      System.out.println("public int print(double w)");
      return 2;
    }
    public void print(int y, char x) {
      System.out.println("public void print(int y, char x)");
    }
// public print(int x){}//ERROR
}
