package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class NumberOfScoreCombinations {
  @EpiTest(testDataFile = "number_of_score_combinations.tsv")

  public static int
  numCombinationsForFinalScore(int finalScore, List<Integer> individualPlayScores) {
    int result = 0;
    for (int i = 0; i < individualPlayScores.size(); i++) {
      int sum = individualPlayScores.get(i);
      if (sum == finalScore) {
        result++;
      }
      for (int j = i + 1; j < individualPlayScores.size(); j++) {
         
        if (sum == finalScore) {
          result++;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "NumberOfScoreCombinations.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
