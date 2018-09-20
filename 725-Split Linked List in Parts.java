/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int l = length(root);
        int part = l / k, more = l % k;
        
        ListNode[] result = new ListNode[k];
        ListNode node = root;
        for (int i = 0; i < more; ++i) {
            if (node == null) {
                result[i] = null;
                continue;
            }
            ListNode current = forward(node, part);
            result[i] = node;
            node = current.next;
            current.next = null;
        }
        
        for (int i = more; i < k; ++i) {
            if (node == null) {
                result[i] = null;
                continue;
            }
            ListNode current = forward(node, part - 1);
            result[i] = node;
            node = current.next;
            current.next = null;
        }
        
        return result;
    }
    
    private int length(ListNode root) {
        int l = 0;
        while (root != null) {
            l = l + 1;
            root = root.next;
        }
        return l;
    }
    
    private ListNode forward(ListNode node, int step) {
        for (int i = 0; i < step; ++i) {
            node = node.next;
        }
        return node;
    }
}