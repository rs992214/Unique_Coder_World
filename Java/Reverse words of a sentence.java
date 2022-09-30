import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Java Program to reverse words in String. There are multiple way to solve this
 * problem. you can either use any collection class like List and reverse the
 * List and later create reverse String by joining individual words.
 *
 * @author Javin Paul
 * @author Aman Jha
 */
class Testing {
 
  public static void main(String args[]) {
 
  }
 
  /*
  * Method to reverse words in String in Java
  */
  public static String reverseWords(String sentence) {
    List< String> words = Arrays.asList(sentence.split("\\s"));
    Collections.reverse(words);
    StringBuilder sb = new StringBuilder(sentence.length());
 
    for (int i = words.size() - 1; i >= 0; i--) {
      sb.append(words.get(i)).append(' ');
    }
 
    return sb.toString().trim();
   }
 
  public static String reverseString(String line) {
    if (line.trim().isEmpty()) {
      return line;
    }
 
    StringBuilder reverse = new StringBuilder();
    String[] sa = line.trim().split("\\s");
 
     for (int i = sa.length - 1; i >= 0; i--) {
        reverse.append(sa[i]).append(' ');
     }
 
     return reverse.toString().trim();
   }
 }
}


Read more: https://www.java67.com/2015/06/how-to-reverse-words-in-string-java.html#ixzz6aCM9OKFh
