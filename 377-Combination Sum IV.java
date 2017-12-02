class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return solve(nums, target, map);
    }
    
    private int solve(int[] nums, int target, Map<Integer, Integer> map) {
        if (map.containsKey(target)) return map.get(target);
        
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (target < nums[i]) return count;
            int result = solve(nums, target - nums[i], map);
            map.put(target - nums[i], result);
            count += result;
        }
        return count;
    }
}
