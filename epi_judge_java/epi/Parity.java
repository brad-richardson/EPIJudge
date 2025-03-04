package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class Parity {
  @EpiTest(testDataFile = "parity.tsv")
  public static short parity(long x) {
    short count = 0;
    while (x != 0) {
      count += ((x & 1) == 1 ? 1 : 0);
      x >>>= 1; // unsigned shift
    }
    // System.out.println("count: " + count);
    return (short) (count % 2);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Parity.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
