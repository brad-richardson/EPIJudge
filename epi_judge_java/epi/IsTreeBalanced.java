package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeBalanced {

  @EpiTest(testDataFile = "is_tree_balanced.tsv")

  public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
    return balancedHeight(tree) >= 0;
  }

  // return -1 if unbalanced
  public static int balancedHeight(BinaryTreeNode<Integer> node) {
    if (node == null) {
      return 0;
    }
    int leftHeight = balancedHeight(node.left);
    int rightHeight = balancedHeight(node.right);
    if (leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1) {
      return -1; // unbalanced
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeBalanced.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
