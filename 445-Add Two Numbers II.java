/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        List<Integer> num1 = toList(l1);
        List<Integer> num2 = toList(l2);
        int i = num1.size() - 1, j = num2.size() - 1;
        int carry = 0;
        ListNode result = new ListNode(0);
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.get(i) : 0;
            int b = j >= 0 ? num2.get(j) : 0;
            int sum = a + b;
            result.val = (sum + carry) % 10;
            carry = (sum + carry) / 10;
            i = i - 1;
            j = j - 1;
            
            ListNode n = new ListNode(0);
            n.next = result;
            result = n;
        }
        
        if (carry != 0) {
            ListNode n = new ListNode(carry);
            n.next = result.next;
            return n;
        }
        
        return result.next;
    }
    
    private List<Integer> toList(ListNode l) {
        List<Integer> result = new ArrayList<>();
        while (l != null) {
            result.add(l.val);
            l = l.next;
        }
        return result;
    }
}

// O(1) space
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        int len1 = getLength(l1), len2 = getLength(l2);
        ListNode result = null;
        while (len1 > 0 && len2 > 0) {
            int sum = 0;
            if (len1 >= len2) {
                sum += l1.val;
                l1 = l1.next;
                len1 -= 1;
            }
            if (len1 < len2) {
                sum += l2.val;
                l2 = l2.next;
                len2 -= 1;
            }
            result = addToFront(result, sum);
        }
        
        ListNode current = result;
        ListNode pre = result;
        int carry = 0;
        while (current != null) {
            current.val += carry;
            carry = current.val / 10;
            current.val %= 10;
            pre = current;
            current = current.next;
        }
        
        if (carry != 0) {
            pre.next = new ListNode(carry);
        }
        return reverse(result);
    }
    
    private int getLength(ListNode l) {
        int len = 0;
        while (l != null) {
            len += 1;
            l = l.next;
        }
        return len;
    }
    
    private ListNode addToFront(ListNode n, int val) {
        ListNode front = new ListNode(val);
        front.next = n;
        return front;
    }
    
    private ListNode reverse(ListNode l) {
        ListNode head = new ListNode(0);
        head.next = l;
        while (l != null && l.next != null) {
            ListNode temp = l.next.next;
            l.next.next = head.next;
            head.next = l.next;
            l.next = temp;
        }
        return head.next;
    }
}
