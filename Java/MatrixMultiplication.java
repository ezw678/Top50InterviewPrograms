// Matrix multiplication

import java.util.Arrays;

public class MatrixMultiplication {

  public static void main(String[] args) {
    int [][] matrix1 = {
      {1, 2, 3},
      {4, 5, 6}
    };

    int [][] matrix2 = {
      {7, 8},
      {9, 10},
      {11, 12}
    };

    int temp [][] = matrixMultiplication(matrix1, matrix2);

    for (int[] r : temp) {
      System.out.println(Arrays.toString(r));
    }
    // output:
    // [58, 64]
    // [139, 154]
  }

  static int [][] matrixMultiplication (int [][] m1, int [][] m2) {
    if (m1[0].length != m2.length)
      return null;

    int m1_row_len = m1.length;
    int m1_col_len = m1[0].length;
    int m2_col_len = m2[0].length;

    int [][] temp = new int [m1_row_len][m2_col_len];
    for (int k = 0; k < m2_col_len; k++) {
      for (int i = 0; i < m1_row_len; i++) {
        for (int j = 0; j < m1_col_len; j++) {
          temp[i][k] += m1[i][j] * m2[j][k];
        }
      }
    }

    return temp;
  }

}
