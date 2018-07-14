class Solution {
    public int arrayNesting(int[] nums) {
        int len = nums.length, maxLen = 0;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; ++i) {
            if (!visited[i]) {
                int l = 0;
                while (!visited[i]) {
                    visited[i] = true;
                    l += 1;
                    i = nums[i];
                }
                maxLen = Math.max(maxLen, l);
            }
        }
        return maxLen;
    }
}
