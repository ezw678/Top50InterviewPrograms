// Reverse a String in place. See also reverseStr.java

public class ReverseStrInPlace {

  public static void main(String[] args) {
    String str = "abcde";
    System.out.println(reverseStr (str));
    System.out.println(reverseStr2 (str));
    System.out.println(reverseStr3 (str));
    // output: edcba
  }

  static String reverseStr (String str) {
    int len = str.length();
    int l = 0, r = len - 1;

    String beginning = "";
    String ending = "";
    while (l < r) {
      beginning += str.charAt(r);
      ending = str.charAt(l) + ending;
      l++;
      r--;
    }

    if (l == r)
      return beginning + str.charAt(l) + ending;
    else
      return beginning + ending;
  }

  static String reverseStr2 (String str) {
    char [] chs = str.toCharArray();

    String temp = "";

    for (char ch : chs) {
      temp = (char) ch + temp;
    }

    return temp;
  }

  static String reverseStr3 (String str) {
    int len = str.length();
    char [] chs = new char [len];

    for (int i = 0; i < len; i++) {
      chs[i] = str.charAt(len - 1 - i);
    }

    return String.valueOf(chs);
  }

}