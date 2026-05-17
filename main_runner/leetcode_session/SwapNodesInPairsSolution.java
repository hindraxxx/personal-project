public class SwapNodesInPairsSolution {
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;

    while (prev.next != null && prev.next.next != null) {
      ListNode first = prev.next;
      ListNode second = first.next;
      ListNode nextPair = second.next;

      first.next = nextPair;
      second.next = first;
      prev.next = second;

      prev = first;
    }

    return dummy.next;
  }
}
