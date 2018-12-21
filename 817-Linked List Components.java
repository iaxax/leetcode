/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        for (int g : G) set.add(g);
        
        int count = 0;
        boolean connected = false;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!connected) connected = true;
            } else if (connected) {
                count += 1;
                connected = false;
            }
            head = head.next;
        }
        
        if (connected) count += 1;
        return count;
    }
}