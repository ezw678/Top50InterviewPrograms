// matrix addition

import java.util.Arrays;

public class MatrixAddition {

  public static void main(String[] args) {
    int [][] a = {{1, 2, 3}, {4, 5, 6}};
    int [][] b = {{1, 1, 1}, {1, 1, 1}};

    int [] [] temp = matrixAddition(a, b);

    for (int [] r : temp)
      System.out.println(Arrays.toString(r));
    // output:
    // [2, 3, 4]
    // [5, 6, 7]
  }

  static int [][] matrixAddition(int [] [] a, int [][] b) {
    if (a.length != b.length || a[0].length != b[0].length)
      return null;

    int rows = a.length;
    int cols = a[0].length;

    int [][] temp = new int [rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        temp[i][j] = a[i][j] + b[i][j];
      }
    }

    return temp;
  }

}
