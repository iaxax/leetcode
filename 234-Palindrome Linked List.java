/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        
        int size = list.size();
        for (int i = 0; i < size / 2; ++i) {
            if (list.get(i).intValue() != list.get(size - 1 - i).intValue()) return false;
        }
        return true;
    }
}
