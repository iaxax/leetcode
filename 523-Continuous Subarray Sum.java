// O(n^2) solution
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return false;
        
        int[] sums = new int[len];
        sums[0] = nums[0];
        for (int i = 1; i < len; ++i) {
            sums[i] = sums[i - 1] + nums[i];
            if (k == 0) {
                if (sums[i] == 0) return true;
            } else {
                if (sums[i] % k == 0) return true;
            }
        }
        
        for (int i = 1; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                int s = sums[j] - sums[i - 1];
                if (k == 0) {
                    if (s == 0) return true;
                } else {
                    if (s % k == 0) return true;
                }
            }
        }
        return false;
    }
}

// O(n) solution
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
            if (k != 0) sum %= k;
            Integer prev = map.get(sum);
            if (prev != null) {
                if (i - prev > 1) return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
