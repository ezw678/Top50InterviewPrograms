// find The square root of a number

public class Sqrt {

  public static void main(String[] args) {
    int n = 35;

    System.out.println(sqrt(n));
    // output: 5.916079783113673
  }

  static double sqrt (double nbr) {
    for (int i = 1; i < nbr; i++) {
      int d = i * i;
      if (d == nbr)
        return i;
      else if (d > nbr) {
        return sqrt(nbr, i - 1, i);
      }
    }

    return Double.NaN;
  }

  static double sqrt(double nbr, double lower, double upper) {
    double mid = (lower + upper) / 2;

    double d = mid * mid;
    if (d == nbr || Math.abs(d - nbr) < 0.000000001)
      return mid;
    else if (d > nbr)
      return sqrt(nbr, lower, mid);
    else
      return sqrt(nbr, mid, upper);
  }

}
