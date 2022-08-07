// Write a Java program to check if a given number is prime or not. Remember,
// a prime number is a number which is not divisible by any other number,
// e.g. 3, 5, 7, 11, 13, 17, etc.

public class IsPrime {

  public static void main(String[] args) {
    System.out.println(isPrime(15));
    // output: false
  }

  public static Boolean isPrime(Integer n) {
    if (n <= 1) return false;
    if (n == 2) return true;

    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }

}
