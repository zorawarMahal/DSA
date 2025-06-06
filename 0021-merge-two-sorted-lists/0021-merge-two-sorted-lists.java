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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return list1;
        }

        ListNode head = new ListNode(-101);
        ListNode temp = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = insertNewnode(list1.val);
                list1 = list1.next;
            }
            else {
                temp.next = insertNewnode(list2.val);
                list2 = list2.next;
            }
            temp = temp.next;
        }    

        while (list1 != null) {
            temp.next = insertNewnode(list1.val);
            temp = temp.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            temp.next = insertNewnode(list2.val);
            temp = temp.next;
            list2 = list2.next;
        }

        return head.next;
    }

    public ListNode insertNewnode(int val) {
        ListNode node = new ListNode(val);
        return node;
    }
}