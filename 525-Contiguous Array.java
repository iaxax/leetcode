class Solution {
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) nums[i] = -1;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            Integer s = map.get(sum);
            if (s != null) {
                max = Math.max(max, i - s);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}
