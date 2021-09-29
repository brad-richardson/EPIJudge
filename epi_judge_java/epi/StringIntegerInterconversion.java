package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
public class StringIntegerInterconversion {

  public static String intToString(int x) {
    StringBuilder sb = new StringBuilder();
    boolean negative = x < 0;
    do {
      sb.append((char) ('0' + Math.abs(x % 10)));
      x /= 10;
    } while (x != 0);
    if (negative) {
      sb.append('-');
    }
    String result = sb.reverse().toString();
    return result;
  }
  public static int stringToInt(String s) {
    int result = 0;
    boolean negative = false;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '-') {
        negative = true;
        continue;
      } else if (s.charAt(i) == '+') {
        continue;
      }
      result *= 10;
      result += (int) (s.charAt(i) - '0');
    }
    if (negative) {
      result *= -1;
    }
    return result;
  }
  @EpiTest(testDataFile = "string_integer_interconversion.tsv")
  public static void wrapper(int x, String s) throws TestFailure {
    if (Integer.parseInt(intToString(x)) != x) {
      throw new TestFailure("Int to string conversion failed");
    }
    if (stringToInt(s) != x) {
      throw new TestFailure("String to int conversion failed");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "StringIntegerInterconversion.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
