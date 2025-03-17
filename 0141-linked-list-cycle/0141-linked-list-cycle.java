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

        ListNode fastP = head; // the fast pointer moves 2 places in each iteration
        ListNode slowP = head; // slow pointer will move 1 place in each iteration

        do {
            fastP = fastP.next;

            // fastP.next won't exist if there are only 2 elements therefore, this will give
            // NullPonterException. Hence this check!
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



        // better code

        // ListNode fast = head;
        // ListNode slow = head;

        // while (fast != null && fast.next != null) {
        //     fast = fast.next.next;
        //     slow = slow.next;
        //     if (fast == slow) {
        //         return true;
        //     }
        // }
        
        // return false;
    }
}