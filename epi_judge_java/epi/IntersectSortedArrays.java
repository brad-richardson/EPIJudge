package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
import java.util.ArrayList;
public class IntersectSortedArrays {
  @EpiTest(testDataFile = "intersect_sorted_arrays.tsv")

  public static List<Integer> intersectTwoSortedArrays(List<Integer> A,
                                                       List<Integer> B) {
    // two pointers, one per list
    int a = 0;
    int b = 0;
    List<Integer> result = new ArrayList<>();
    while (a < A.size() && b < B.size()) { // if either at end, done
      int aCurrent = A.get(a);
      int bCurrent = B.get(b);
      if (aCurrent == bCurrent) {
        if (result.size() == 0 || (result.size() > 0 && aCurrent != result.get(result.size() - 1))) {
          result.add(aCurrent);
        }
        a++;
        b++;
      } else if (aCurrent < bCurrent) {
        a++;
      } else {
        b++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntersectSortedArrays.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
