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
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode node = head;

        while (node != null) {
            size++;
            node = node.next;
        }

        int middle = size/2 + 1;

        size = 1;
        node = head;

        while (size < middle) {
            node = node.next;
            size++;
        }

        return node;
    }
}