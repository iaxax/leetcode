class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int moves = 0, mid = nums[nums.length >> 1];
        for (int n : nums) {
            moves += Math.abs(n - mid);
        }
        return moves;
    }
}

class Solution {
    public int minMoves2(int[] nums) {
        int moves = 0, mid = findMid(nums, 0, nums.length - 1, (nums.length - 1) >> 1);
        for (int n : nums) {
            moves += Math.abs(n - mid);
        }
        return moves;
    }
    
    private int findMid(int[] nums, int start, int end, int mid) {
        if (start == end) return nums[start];
        int i = start + 1, j = end;
        while (i <= j) {
            while (i <= j && nums[i] <= nums[start]) ++i;
            while (i <= j && nums[j] > nums[start]) --j;
            if (i > j) break;
            swap(nums, i, j);
        }
        
        swap(nums, start, i - 1);
        if (i - 1 == mid) return nums[mid];
        else if (i - 1 > mid) {
            return findMid(nums, start, i - 2, mid);
        } else {
            return findMid(nums, i, end, mid);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
