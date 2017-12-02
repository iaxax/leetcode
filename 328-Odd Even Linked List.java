/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode n = even;
        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            if (odd.next != null)
                odd = odd.next;
            even.next = even.next.next;
            if (even.next != null)
                even = even.next;
        }
        odd.next = n;
        return head;
    }
}
