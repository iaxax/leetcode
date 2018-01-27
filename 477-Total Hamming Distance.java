class Solution {
    public int totalHammingDistance(int[] nums) {
        int distance = 0;
        for (int i = 0; i < 31; ++i) {
            int zero = 0, one = 0;
            for (int n : nums) {
                if ((n & (1 << i)) != 0) ++one;
                else ++zero;
            }
            distance += zero * one;
        }
        return distance;
    }

}
