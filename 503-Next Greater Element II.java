// O(n^2) solution
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; ++i) {
            int j = i;
            while ((j + 1) % len != i && nums[i] >= nums[(j + 1) % len]) j = (j + 1) % len;
            result[i] = (j + 1) % len == i ? -1 : nums[(j + 1) % len];
        }
        return result;
    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        if (len == 0) return new int[0];
        
        int[] result = new int[len];
        Deque<Integer> dq = new ArrayDeque<>(len);
        dq.offerLast(0);
        for (int i = 1; i < len; ++i) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                int index = dq.pollLast();
                result[index] = nums[i];
            }
            dq.offerLast(i);
        }
        
        if (!dq.isEmpty()) {
            int first = dq.pollFirst();
            result[first] = -1;
            while (!dq.isEmpty() && nums[dq.peekFirst()] == nums[first]) {
                result[dq.pollFirst()] = -1;
            }
            
            while (!dq.isEmpty()) {
                int index = dq.pollLast();
                int i = (index + 1) % len;
                while (nums[index] >= nums[i]) i = (i + 1) % len;
                result[index] = nums[i];
                while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                    result[dq.pollLast()] = nums[i];
                }
            }
        }
        
        return result;
    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len * 2; ++i) {
            int num = nums[i % len];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                result[stack.pop()] = num;
            if (i < len) stack.push(i);
        }
        return result;
    }
}
