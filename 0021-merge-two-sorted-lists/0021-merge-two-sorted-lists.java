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
                temp = insertNext(list1.val, temp);
                list1 = list1.next;
            }
            else {
                temp = insertNext(list2.val, temp);
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            temp = insertNext(list1.val, temp);
            list1 = list1.next;
        }

        while (list2 != null) {
            temp = insertNext(list2.val, temp);
            list2 = list2.next;
        }

        return head.next;
    }

    public ListNode insertNext(int val, ListNode ans) {
        ans.next = new ListNode(val);
        return ans.next;
    }
}