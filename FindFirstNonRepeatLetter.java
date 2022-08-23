// Write a Java program to find the first non-repeated character in a String

import java.util.Map;
import java.util.LinkedHashMap;

public class FindFirstNonRepeatLetter {

  public static void main(String[] args) {
    String str = "abcdefghija";

    System.out.println(findFirstNonRepeatLetter(str));
    // output: b
  }

  static char findFirstNonRepeatLetter(String str) {
    char [] chs = str.toCharArray();

    Map<Character, Integer> map = new LinkedHashMap<>();
    for (char ch : chs) {
      if (map.containsKey(ch))
        map.put(ch, map.get(ch) + 1);
      else
        map.put(ch, 1);
    }

    for (char ch : chs) {
      if (map.get(ch) == 1)
        return ch;
    }

    return '\u0000';
  }

}
