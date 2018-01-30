class Solution {
    public String optimalDivision(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < len - 1; ++i) {
                builder.append(nums[i]).append("/");
            }
            builder.append(nums[len - 1]);
            return builder.toString();
        }
        
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0]).append("/(");
        for (int i = 1; i < len - 1; ++i) {
            builder.append(nums[i]).append("/");
        }
        builder.append(nums[len - 1]).append(")");
        return builder.toString();
    }
}
