// Leap year

public class IsLeapYear {

  public static void main(String[] args) {
    System.out.println(isLeapYear(2000));
    // output: true

    System.out.println(isLeapYear(1911));
    // output: false
  }

  static boolean isLeapYear(int year) {
    if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
      return true;

    return false;
  }

}
