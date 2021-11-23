package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ReverseSublist {
  @EpiTest(testDataFile = "reverse_sublist.tsv")

  public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start,
                                                 int finish) {
    ListNode<Integer> dummy = new ListNode<>(0, L);
    ListNode<Integer> sublistHead = dummy;
    int i = 1;
    while (i++ < start) {
      sublistHead = sublistHead.next;
    }
    ListNode<Integer> sublistIter = sublistHead.next;
    while (start++ < finish) {
      // Bubble start node all the way to the back
      ListNode<Integer> temp = sublistIter.next;
      sublistIter.next = temp.next;
      temp.next = sublistHead.next;
      sublistHead.next = temp;
    }
    return dummy.next;;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseSublist.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
