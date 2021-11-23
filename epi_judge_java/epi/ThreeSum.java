package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
public class ThreeSum {
  @EpiTest(testDataFile = "three_sum.tsv")

  public static boolean hasThreeSum(List<Integer> A, int t) {
    Set<Integer> twoSumPossibilities = new HashSet<>();
    // Fill set with needed offset values
    for (Integer a : A) {
      twoSumPossibilities.add(t - a);
    }
    for (int i = 0; i < A.size(); i++) {
      for (int j = i; j < A.size(); j++) {
        if (twoSumPossibilities.contains(A.get(i) + A.get(j))) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ThreeSum.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
