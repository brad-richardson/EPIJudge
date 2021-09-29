package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class BuyAndSellStock {
  @EpiTest(testDataFile = "buy_and_sell_stock.tsv")
  public static double computeMaxProfit(List<Double> prices) {
    double max = Double.MIN_VALUE;
    double minSoFar = prices.get(0);
    for (int i = 0; i < prices.size(); i++) {
      max = Math.max(max, prices.get(i) - minSoFar);
      minSoFar = Math.min(minSoFar, prices.get(i));
    }
    return max;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStock.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
