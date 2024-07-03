// Remove all white space from String

public class ReplaceAllWhiteSpaces {

  public static void main(String[] args) {
    String str = " hello w orld ";

    System.out.println(replaceAllWhiteSpaces(str));
    // output: helloworld
  }

  static String replaceAllWhiteSpaces(String str) {
    return str.replaceAll("\\s", "");
  }

}

