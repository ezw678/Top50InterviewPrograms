// Write a method that reverses a string.
// For example, 'java interview' becomes 'weivretni avaj'.

import java.util.Stack;

public class ReverseString {

  public static void main(String[] args) {
    String str = "java interview";

    System.out.println(reverse(str));
    // output: weivretni avaj

    System.out.println(reverse2(str));
    System.out.println(reverse3(str));
    System.out.println(reverse4(str));
  }

  // solution 1
  public static String reverse(String s) {
    StringBuilder sb = new StringBuilder(s);

    return sb.reverse().toString();
  }

  // solution 2
  public static String reverse2(String s) {
    String res = "";

    for (int i = s.length() - 1; i >= 0; i--)    {
      res += s.charAt(i);
    }

    return res;
  }

  // solution 3
  public static String reverse3(String s) {
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < s.length(); i++)    {
      st.push(s.charAt(i));
    }

    String res = "";
    for (int i = 0; i < s.length(); i++)    {
      res += st.pop();
    }

    return res;
  }

  // solution 4
  public static String reverse4(String s) {
    if (s.length() == 1) return s;

    return reverse3(s.substring(1, s.length())) + s.charAt(0);
  }

}
