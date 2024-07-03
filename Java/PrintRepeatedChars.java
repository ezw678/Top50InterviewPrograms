//write a program to find repeated characters in a String

import java.util.Map;
import java.util.HashMap;

public class PrintRepeatedChars {

  public static void main(String[] args) {
    printRepeatedChars("Programming");
    printRepeatedChars("Combination");
    printRepeatedChars("Java");
  }

  static void printRepeatedChars(String str) {
    int len = str.length();

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      char curr = str.charAt(i);
      if (map.containsKey(curr)) {
        map.put (curr, map.get(curr) + 1);
      } else {
        map.put (curr, 1);
      }
    }

    System.out.println("List of dup characters in string \'" + str + "\':");
    map.forEach((key, value) -> {
      if (value > 1)
        System.out.println(key + ": " + value);
    });
  }

}