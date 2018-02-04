class Solution {
    public boolean isPossible(int[] nums) {
        if (nums.length < 3) return false;

        ListNode head = constructList(nums);
        int val = head.next.val;
        while (head.next != null) {
            ListNode current = head;
            int len = 0, count = current.count;
            while (current.next != null && count <= current.next.count && current.next.val == val) {
                ++val; ++len;
                count = current.next.count;
                --current.next.count;
                current = current.next;
            }

            if (len < 3) return false;

            while (head.next != null && head.next.count == 0) {
                head.next = head.next.next;
            }

            if (head.next != null) val = head.next.val;
            else break;
        }

        return true;
    }
    
    private ListNode constructList(int[] nums) {
        int size = nums.length, i = 0;
        ListNode head = new ListNode(0, 0);
        ListNode current = head;
        while (i < size) {
            int j = i;
            while (i < size && nums[i] == nums[j]) ++i;
            ListNode n = new ListNode(nums[j], i - j);
            current.next = n;
            current = n;
        }
        return head;
    }
    
    private class ListNode {
        int val, count;
        ListNode next;
        ListNode(int v, int c) {
            val = v; count = c;
        }
    }
    
}

class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int start = nums[0];
        while (map.containsKey(start)) {
            int val = start;
            Integer prev = map.get(val), curr = map.get(val + 1);
            while (prev != null && curr != null && prev <= curr) {
                ++val;
                prev = curr;
                curr = map.get(val + 1);
            }

            if (val - start < 2) return false;
            
            for (int j = start; j <= val; ++j) {
                int temp = map.get(j);
                if (temp > 1) {
                    map.put(j, temp - 1);
                } else {
                    ++start;
                }
            }
        }
        return true;
    }
}
