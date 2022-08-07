// You need to write a simple Java program to check if a given String is palindrome or not.
// A Palindrome is a String which is equal to the reverse of itself, e.g., "Bob" is a
// palindrome because of the reverse of "Bob" is also "Bob."

public class IsPalindrome {

  public static void main(String[] args) {
    String str = "abba";

    System.out.println(isPalindrome(str));
    // output: true
    System.out.println(isPalindrome2(str));
    System.out.println(isPalindrome3(str));
    System.out.println(isPalindrome4(str));
  }

  // solution 1
  public static boolean isPalindrome(String word) {
    String str = "";
    for (int i = word.length() - 1; i >= 0; i--) {
      str += word.charAt(i);
    }

    return str.equals(word);
  }

  // solution 2
  public static boolean isPalindrome2(String word) {
    StringBuilder sb = new StringBuilder(word);

    return (sb.reverse().toString().equals(word));
  }

  // solution 3
  public static boolean isPalindrome3(String word) {
    int l = 0;
    int r = word.length() - 1;

    while (l <= r) {
      if (word.charAt(l) != word.charAt(r)) {
        return false;
      } else {
        l++;
        r--;
      }
    }

    return true;
  }

  // solution 4
  public static boolean isPalindrome4(String word) {
    int l = 0;
    int r = word.length() - 1;

    return isPalindrome4(word, l, r);
  }

  static boolean isPalindrome4 (String word, int l, int r) {
    if (l > r) return true;

    if (word.charAt(l) != word.charAt(r))
      return false;

    return isPalindrome4(word, l + 1, r - 1);
  }

}
