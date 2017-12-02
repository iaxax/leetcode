class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = nums[0], sum = 0;
        int n = nums.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (visited[nums[i] - 1]) dup = nums[i];
            else visited[nums[i] - 1] = true;
        }
        
        int[] result = new int[2];
        result[0] = dup;
        result[1] = dup + (1 + n) * n / 2 - sum;
        return result;
    }
}
