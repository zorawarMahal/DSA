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
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        return ispalindrome(head);
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = p;
            p = current;
            current = nextNode;
        }
        
        return p;
    }

    public boolean ispalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode secondHead = reverseList(mid);
        ListNode rereverseHead = secondHead;

        // compare both halves
        while (secondHead != null) {
            if (secondHead.val != head.val) {
                return false;
            }
            secondHead = secondHead.next;
            head = head.next;
        }
        return true;
    }
}