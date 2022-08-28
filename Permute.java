// Write a Java program to print all permutations of a given String. For example, if given String
// is "GOD" then your program should print all 6 permutations of this string, e.g.
// "GOD," "OGD," "DOG," "GDO," "ODG," and "DGO."

public class Permute {

  public static void main(String[] args) {
    String word = "GOD";
    permute(word);
    // output: GOD GDO OGD ODG DOG DGO
  }

  static void permute(String word) {
    permute(word, 0, word.length() - 1);
  }

  static void permute(String word, int l, int r) {
    if (l == r)
      System.out.print(word + " ");
    else {
      for (int i = l; i <= r; i++) {
        word = swap(word, l, i);
        permute(word, l + 1, r);
        word = swap(word, l, i); //backtrack
      }
    }
  }

  static String swap(String word, int l, int r) {
    if (word.length() == 0) return word;

    if (l == r) return word;

    return word.substring(0, l) + word.charAt(r) + word.substring(l + 1, r) + word.charAt(l) + word.substring(r + 1, word.length());
  }

}

