/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode current = head;
        ListNode p = null;

        // skipping the first left - 1 nodes
        for (int i=0; current != null && i < left - 1; i++) {
            p = current;
            current = current.next;
        }

        ListNode last = p;
        ListNode newEnd = current;

        // reverse between left and right
        for (int i=0; current != null && i < right - left + 1; i++) {
            ListNode nextNode = current.next;
            current.next = p;
            p = current;
            current = nextNode;
        }

        // making connections with the reversed part
        newEnd.next = current;
        if (last != null) {
            last.next = p;
        } else {
            head = p;
        }

        return head;
    }
}