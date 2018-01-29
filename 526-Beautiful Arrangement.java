class Solution {
    public int countArrangement(int N) {
        return countArrangement(0, N, 1);
    }
    
    private int countArrangement(int used, int N, int index) {
        if (index > N) return 1;
        
        int mask = 1, count = 0;
        for (int i = 1; i <= N; ++i) {
            if ((mask & used) == 0 && (i % index == 0 || index % i == 0)) {
                count += countArrangement(used | mask, N, index + 1);
            }
            mask <<= 1;
        }
        return count;
    }
}

class Solution {
    public int countArrangement(int N) {
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; ++i) nums[i] = i;
        return countArrangement(nums, 1);
    }
    
    private int countArrangement(int[] nums, int start) {
        if (start == nums.length) return 1;
        
        int count = 0;
        for (int i = start; i < nums.length; ++i) {
            if (nums[i] % start == 0 || start % nums[i] == 0) {
                swap(nums, i, start);
                count += countArrangement(nums, start + 1);
                swap(nums, i, start);
            }
        }
        return count;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
