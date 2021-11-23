package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
import java.util.*;
public class SortedArraysMerge {
  @EpiTest(testDataFile = "sorted_arrays_merge.tsv")

  public static List<Integer>
  mergeSortedArrays(List<List<Integer>> sortedArrays) {
    // TODO - preserve with list id and grab next in line
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (List<Integer> array : sortedArrays) {
      for (Integer value : array) {
        pq.add(value);
      }
    }

    List<Integer> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(pq.poll());
    }
    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedArraysMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
