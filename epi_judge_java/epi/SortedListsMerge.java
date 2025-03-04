package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SortedListsMerge {
  @EpiTest(testDataFile = "sorted_lists_merge.tsv")
  public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                      ListNode<Integer> L2) {
    ListNode<Integer> dummy = new ListNode<Integer>(0, null);
    ListNode<Integer> current = dummy;
    while (L1 != null || L2 != null) {
      if (L1 == null) {
        current.next = L2;
        break;
      } else if (L2 == null) {
        current.next = L1;
        break;
      } else {
        if (L1.data < L2.data) {
          current.next = L1;
          L1 = L1.next;
        } else {
          current.next = L2;
          L2 = L2.next;
        }
        current = current.next;
      }
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
