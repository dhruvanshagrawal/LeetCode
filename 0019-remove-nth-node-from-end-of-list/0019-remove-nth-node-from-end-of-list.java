class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // First and second pointer both start at dummy
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from end
        second.next = second.next.next;

        return dummy.next;
    }
}
