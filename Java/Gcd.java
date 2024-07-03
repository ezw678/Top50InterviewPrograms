// The Greatest Common Divisor of two positive integers is the largest integer
// that divides both without remainder. Write a method that returns the Greatest
// Common Divisor of p and q.

public class Gcd {

  public static void main(String[] args) {
    int p = 54;
    int q = 24;

    System.out.println(gcd(p, q));
    // output: 6
  }

  public static Integer gcd(Integer p, Integer q) {
    int smaller = Math.min(p, q);

    for (int i = smaller; i >= 2; i--) {
      if (p % i == 0 && q % i == 0)
        return i;
    }

    return 1;
  }

}
