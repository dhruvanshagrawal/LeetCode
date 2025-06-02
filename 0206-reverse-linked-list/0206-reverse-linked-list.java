class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        

        while (curr != null) {
            ListNode nextNode = curr.next; // store next node
            curr.next = prev;              // reverse current node's pointer
            prev = curr;                   // move prev to current
            curr = nextNode;               // move to next node
        }

        return prev; // new head
    }
}
