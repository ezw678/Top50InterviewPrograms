// A number is called an Armstrong number if it is equal to the cube of its every digit.
// For example, 153 is an Armstrong number because of 153= 1+ 125+27, which is equal to
// 1^3+5^3+3^3. You need to write a program to check if the given number is Armstrong
// number or not.

public class IsArmstrongNbr {

  public static void main(String[] args) {
    int n = 153;

    System.out.println(isArmstrongNbr(n));
    // output: true
    System.out.println(isArmstrongNbr2(n));
  }

  static boolean isArmstrongNbr (int nbr) {
    String str = Integer.toString(nbr);
    char [] chs = str.toCharArray();

    int sum = 0;
    for (char c : chs) {
      int d = Integer.parseInt(String.valueOf(c));
      sum += Math.pow(d, 3);
    }

    return nbr == sum;
  }

  static boolean isArmstrongNbr2 (int nbr) {
    int temp = nbr;

    int sum = 0;
    while (temp != 0) {
      int remainder = temp % 10;
      sum += Math.pow(remainder, 3);
      temp /= 10;
    }

    return nbr == sum;
  }

}
