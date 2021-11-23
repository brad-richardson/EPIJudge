package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeABst {
  @EpiTest(testDataFile = "is_tree_a_bst.tsv")

  public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
    if (tree == null) {
      return true;
    }
    return isBinaryTreeBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree, Integer min, Integer max) {
    if (tree == null) {
      return true;
    }
    if (tree.data < min || tree.data > max) {
      return false;
    }
    boolean leftValid = isBinaryTreeBST(tree.left, min, tree.data);
    boolean rightValid = isBinaryTreeBST(tree.right, tree.data, max);
    return leftValid && rightValid;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeABst.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
