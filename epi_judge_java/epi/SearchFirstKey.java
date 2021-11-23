package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class SearchFirstKey {
  @EpiTest(testDataFile = "search_first_key.tsv")

  public static int searchFirstOfK(List<Integer> A, int k) {
    int result = -1;
    int left = 0;
    int right = A.size() - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int value = A.get(mid);
      if (k <= value) {
        // keep searching left even if found, store best result
        if (value == k) {
          result = mid;
        }
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchFirstKey.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
