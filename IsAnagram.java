// Write a program to check if two given String is Anagram of each other. Your function
// should return true if two Strings are Anagram, false otherwise. A string is said to
// be an anagram if it contains the same characters and same length, but in a different
// order, e.g. army and Mary are anagrams. You can ignore cases for this problem

import java.util.Arrays;

public class IsAnagram {

  public static void main(String[] args) {
    String str1 = "army";
    String str2 = "mary";

    System.out.println(isAnagram(str1, str2));
    System.out.println(isAnagram2(str1, str2));
    // output: true
  }

  static boolean isAnagram(String s1, String s2) {
    if (s1.length() != s2.length() || s1.equals(s2))
      return false;

    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();

    char [] a1 = s1.toCharArray();
    char [] a2 = s2.toCharArray();
    Arrays.sort(a1);
    Arrays.sort(a2);

    return Arrays.equals(a1, a2);
  }

  static boolean isAnagram2(String s1, String s2) {
    if (s1.length() != s2.length() || s1.equals(s2))
      return false;

    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();

    for (int i = 0; i < s1.length(); i++) {
      if (!s2.contains(String.valueOf(s1.charAt(i))))
        return false;
    }

    return true;
  }

}
