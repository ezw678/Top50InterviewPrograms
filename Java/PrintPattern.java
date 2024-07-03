// Printing patterns

public class PrintPattern {

  public static void main(String[] args) {
    printPattern (5);
  }

  static void printPattern (int base) {
    for (int i = 0; i < base; i++) {
      for (int j = 0; j < base - i; j++) {
        System.out.print(" ");
      }

      for (int k = 0; k <= i; k++) {
        System.out.print("* ");
      }

      System.out.println();
    }
  }

}
