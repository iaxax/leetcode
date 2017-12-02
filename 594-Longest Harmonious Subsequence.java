// O(nlogn) Solution
class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, result = 0;
        int count = 1;
        while (count < n && nums[count] == nums[count - 1]) ++count;
        for (int i = count; i < n; ++i) {
            int num = 1, index = i;
            while (i + 1 < n && nums[i] == nums[i + 1]) {
                ++i; ++num;
            }
            if (nums[index] == nums[index - 1] + 1) {
                result = Math.max(result, num + count);
            }
            count = num;
        }
        
        return result;
    }
}

// O(n) Solution
class Solution {
    public int findLHS(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();
        for (long num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (long num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                result = Math.max(map.get(num) + map.get(num + 1), result);
            }
        }
        return result;
    }
}

