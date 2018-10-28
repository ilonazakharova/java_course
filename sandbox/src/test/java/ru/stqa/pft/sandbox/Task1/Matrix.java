package ru.stqa.pft.sandbox.Task1;

public class Matrix {
  public static void main(String[] args) {
      int[][] matrix = new int[][]
              {
                      { 1, 0,  -1 },
                      { 2, 3,  4 }
              };

      System.out.println("Матрица исходная");
      prettyPrintMatrix( matrix );

      System.out.println();

      System.out.println("Транспонированная матрица");
      int[][] result = transpose( matrix );
      prettyPrintMatrix( result );
    }

    static int[][] transpose(int[][] matrix) {
      int[][] result = new int[matrix[0].length][matrix.length];
      for ( int i = 0; i < matrix.length; i++ ) {
        for ( int j = 0; j < matrix[0].length; j++ ) {
          result[j][i] = matrix[i][j];
        }
      }
      return result;
    }

    static void prettyPrintMatrix( int[][] matrix ) {
      if ( matrix == null ) return;
      for (int[] row : matrix) {
        for ( int i : row ) {
          System.out.printf( ensureLength( String.valueOf(i), 8) );
        }
        System.out.println();
      }
    }

    static String ensureLength( String str, int length ) {
      int count = length - str.length();
      if ( count > 0 ) {
        String format = "%" + count + "s ";
        str = String.format(format, str);
      }
      return str;
    }
  }


