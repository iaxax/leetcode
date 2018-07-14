class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length, count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
            Integer n = map.get(sum - k);
            if (n != null) {
                count += n;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
