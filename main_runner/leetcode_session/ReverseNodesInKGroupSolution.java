public class ReverseNodesInKGroupSolution {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode groupPrev = dummy;

    while (true) {
      ListNode kth = getKthNode(groupPrev, k);
      if (kth == null) break;

      ListNode groupNext = kth.next;
      ListNode prev = groupNext;
      ListNode current = groupPrev.next;

      while (current != groupNext) {
        ListNode temp = current.next;
        current.next = prev;
        prev = current;
        current = temp;
      }

      ListNode oldGroupStart = groupPrev.next;
      groupPrev.next = kth;
      groupPrev = oldGroupStart;
    }

    return dummy.next;
  }

  private ListNode getKthNode(ListNode current, int k) {
    while (current != null && k > 0) {
      current = current.next;
      k--;
    }

    return current;
  }
}
