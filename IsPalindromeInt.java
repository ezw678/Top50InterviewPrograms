// This time you need to check if given Integer is palindrome or not. An integer is
// called palindrome if it's equal to its reverse, e.g. 1001 is a palindrome, but
// 1234 is not because the reverse of 1234 is 4321 which is not equal to 1234. You
// can use divide by 10 to reduce the number and modulus 10 to get the last digit.

public class IsPalindromeInt {

  public static void main(String[] args) {
    int n = 5302035;

    System.out.println(isPalindromeInt(n));
    // output: true
    System.out.println(isPalindromeInt2(n));
    System.out.println(isPalindromeInt3(n));
  }

  public static boolean isPalindromeInt(int number) {
    String str = Integer.toString(number);
    StringBuilder sb = new StringBuilder(str);

    return sb.reverse().toString().equals(str);
  }

  public static boolean isPalindromeInt2(int number) {
    int temp = number;

    int reversed = 0;
    while (temp != 0) {
      reversed = reversed * 10 + temp % 10;
      temp /= 10;
    }

    return number == reversed;
  }

  public static boolean isPalindromeInt3(int number) {
    return number == isPalindromeInt3(number, 0);
  }

  public static int isPalindromeInt3(int number, int reversed) {
    if (number == 0)
      return reversed;

    reversed = reversed * 10 + number % 10;

    return isPalindromeInt3(number / 10, reversed);
  }

}