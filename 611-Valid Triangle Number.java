// O(n^3) solution
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int num = 0, len = nums.length;
        for (int i = 0; i < len; ++i)
            for (int j = i + 1; j < len; ++j)
                for (int k = j + 1; k < len && nums[i] + nums[j] > nums[k]; ++k)
                    ++num;
        return num;
    }
}

// O(n^2logn) solution
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int num = 0, len = nums.length;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                num += bsearch(nums, j + 1, len - 1, nums[i] + nums[j]) - j - 1;
            }
        }
        return num;
    }
    
    private int bsearch(int[] nums, int start, int end, int key) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
    
}

// O(n^2) solution
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int num = 0, len = nums.length;
        for (int i = len - 1; i >= 2; --i) {
            int j = 0, k = i - 1;
            while (j < k) {
                if (nums[j] + nums[k] > nums[i]) {
                    num += k - j;
                    --k;
                } else {
                    ++j;
                }
            }
        }
        return num;
    }
}


