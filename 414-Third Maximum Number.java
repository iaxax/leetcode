public class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(3);
        for (int i = 0; i < nums.length; ++i) {
            if (queue.contains(nums[i])) continue;
            queue.add(nums[i]);
            if (queue.size() > 3) queue.poll();
        }
        
        if (queue.size() == 3) return queue.peek();
        
        while (queue.size() > 1) {
            queue.poll();
        }
        return queue.peek();
    }
}
