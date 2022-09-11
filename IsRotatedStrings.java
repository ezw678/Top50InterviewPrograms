// Write a program which accepts two given String and checks if they are the rotation of
// each. If they then return true otherwise return false. A String is said to be a
// rotation of other string if they contain same characters and the sequence is rotated
// across any character, e.g. "dabc" is a rotation of "abcd" but "dbac" is not.

public class IsRotatedStrings {

  public static void main(String[] args) {
    String str1 = "dabc";
    String str2 = "abcd";
    System.out.println(isRotatedStrings(str1, str2));
    System.out.println(isRotatedStrings2(str1, str2));
    // output: true
  }

  // solution 1
  static boolean isRotatedStrings(String str1, String str2) {
    if (str1.length() != str2.length()) return false;

    int len = str1.length();
    for (int i = 0; i < len - 1; i++) {
      if (str1.equals(str2))
        return true;
      str1 = str1.substring(1) + str1.charAt(0);
    }

    return false;
  }

  // solution 2
  static boolean isRotatedStrings2(String str1, String str2) {
    if (str1.length() != str2.length()) return false;

    if ((str1 + str1).indexOf(str2) != -1)
      return true;

    return false;
  }

}

