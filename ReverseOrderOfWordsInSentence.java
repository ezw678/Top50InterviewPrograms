// Reverse words of a sentence (solution)

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseOrderOfWordsInSentence {

  public static void main(String[] args) {
    String str = "Java is Great";

    System.out.println(reverseOrderOfWordsInSentence(str));
    System.out.println(reverseOrderOfWordsInSentence2(str));
    // output: Great is Java
  }

  static String reverseOrderOfWordsInSentence(String str) {
    String [] arr = str.split("\\s");

    String ans = "";
    for (String s : arr)
      ans = s + " " + ans;

    return ans;
  }

  static String reverseOrderOfWordsInSentence2(String str) {
    String [] arr = str.split("\\s");

    List<String> list = Arrays.asList(arr);
    Collections.reverse(list);

    return list.stream().collect(Collectors.joining(" "));
  }

}
