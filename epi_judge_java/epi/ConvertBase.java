package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;
public class ConvertBase {
  @EpiTest(testDataFile = "convert_base.tsv")

  public static String convertBase(String numAsString, int b1, int b2) {
    long total = 0l;
    boolean negative = false;
    for (int i = 0; i < numAsString.length(); i++) {
      char current = numAsString.charAt(i);
      if (current == '-') {
        negative = true;
        continue;
      }
      total *= b1;
      if (Character.isDigit(current)) {
        total += ((int) (current - '0'));
      } else {
        total += ((int) (current - 'A' + 10));
      }
    }
    // System.out.println(total);
    StringBuilder sb = new StringBuilder();
    do {
      long remainder = total % b2;
      char out = (char) ('0' + remainder);
      if (remainder > 9) {
        out = (char) ('A' + (remainder - 10));
      }
      sb.append(out);
      total /= b2;
    } while (total != 0); // handle initial 0
    return (negative ? "-" : "") + sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ConvertBase.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
