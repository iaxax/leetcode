class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        
        int n = nums.length;
        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < k && i < n; ++i) {
            add(q, i, nums[i]);
        }
        
        if (k >= n) return new int[] {q.getFirst()[1]};
        int[] result = new int[n - k + 1];
        for (int i = k - 1; i < n; ++i) {
            remove(q, i, k);
            add(q, i, nums[i]);
            result[i - k + 1] = q.getFirst()[1];
        }
        return result;
    }
    
    private void add(LinkedList<int[]> q, int index, int value) {
        while (!q.isEmpty() && q.getLast()[1] <= value) {
            q.removeLast();
        }
        q.addLast(new int[] {index, value});
    }
    
    private void remove(LinkedList<int[]> q, int index, int k) {
        while (!q.isEmpty() && index - q.getFirst()[0] >= k) {
            q.removeFirst();
        }
    }
}