class Solution {
    
    private Map<Integer, ArrayList<Integer>> map = new HashMap();
    
    private Random rand = new Random();

    public Solution(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; ++i) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> indexes = new ArrayList<>();
                map.put(nums[i], indexes);
                indexes.add(i);
            }
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> indexes = map.get(target);
        return indexes.get(rand.nextInt(indexes.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
