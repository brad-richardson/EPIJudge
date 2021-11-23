package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class PowerXY {
  @EpiTest(testDataFile = "power_x_y.tsv")
  public static double power(double x, int y) {
    // multiply current by self, divide y by 2
    double result = 1.0;
    if (y < 0) {
      y = -y;
      x = 1.0 / x;
    }
    while (y != 0) {
      if (y % 2 != 0) {
        result *= x;
      }
      x *= x;
      y = y/2;
    }
    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PowerXY.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
