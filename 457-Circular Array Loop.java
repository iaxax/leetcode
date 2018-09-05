class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        int count = n;
        for (int i = 0; i < n; ++i) {
            if (Math.abs(nums[i]) == n) {
                nums[i] = 0;
                count -= 1;
            }
        }
        
        while (count > 0) {
            int i = 0;
            while (i < count && nums[i] == 0) {
                i = i + 1;
            }
            
            Set<Integer> path = new HashSet<>();
            int sign = nums[i] > 0 ? 1 : -1;
            boolean fail = false;
            while (!path.contains(i)) {
                path.add(i);
                int j = next(nums, i);
                if (nums[j] * sign <= 0) {
                    for (int k : path) {
                        nums[k] = 0;
                        count -= 1;
                    }
                    fail = true;
                    break;
                } else {
                    i = j;
                }
            }
            
            if (!fail) {
                return true;
            }
        }
        
        return false;
    }
    
    private int next(int[] nums, int i) {
        if (nums[i] > 0) {
            return (i + nums[i]) % nums.length;
        } else {
            return i >= -nums[i] ? i + nums[i] : i + nums[i] + nums.length;
        }
    }
}