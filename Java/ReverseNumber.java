// reverse a number in Java without using any API

public class ReverseNumber {

  public static void main(String[] args) {
    int nbr = 1234;

    System.out.println(reverseNumber(nbr));
    System.out.println(reverseNumber2(nbr));
    // output: 4321
  }

  static int reverseNumber(int nbr) {
    String str = Integer.toString(nbr);

    StringBuilder sb = new StringBuilder(str);

    return Integer.parseInt(sb.reverse().toString());
  }

  static int reverseNumber2(int nbr) {
    int temp = nbr;

    int reversed = 0;
    while (temp != 0) {
      reversed = reversed * 10 + temp % 10;
      temp /= 10;
    }

    return reversed;
  }

}
