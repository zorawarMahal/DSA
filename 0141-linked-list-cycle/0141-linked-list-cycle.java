/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fastP = head;
        ListNode slowP = head;

        do {
            fastP = fastP.next;
            if (fastP == null) {
                return false;
            }
            fastP = fastP.next;
            slowP = slowP.next;

            if (fastP == slowP) {
                return true;
            }
        } while (fastP != null && slowP != null);

        return false;
    }
}