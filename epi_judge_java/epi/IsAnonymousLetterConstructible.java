package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.*;
public class IsAnonymousLetterConstructible {
  @EpiTest(testDataFile = "is_anonymous_letter_constructible.tsv")

  public static boolean isLetterConstructibleFromMagazine(String letterText,
                                                          String magazineText) {
    Map<Character, Integer> counts = new HashMap<>();
    for (Character current : magazineText.toCharArray()) {
      counts.put(current, counts.getOrDefault(current, 0) + 1);
    }

    for (Character current : letterText.toCharArray()) {
      Integer previous = counts.put(current, counts.getOrDefault(current, 0) - 1);
      if (previous == null || previous <= 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsAnonymousLetterConstructible.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
