/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move `prev` to one node before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Reverse the sublist from left to right
        ListNode curr = prev.next;
        ListNode nextNode;
        ListNode prevNode = null;

        for (int i = left; i <= right; i++) {
            nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }

        // Reconnect the reversed part
        prev.next.next = curr;  // Connect tail of reversed part to `curr`
        prev.next = prevNode;    // Connect `prev` to new head of reversed part

        return dummy.next;
    }
}