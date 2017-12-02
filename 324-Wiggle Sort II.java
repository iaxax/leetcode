// O(n) Solution
class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        if (len == 1) return;
        int mid = kthSmallestElement(nums, (len + 1) >> 1);
        int i = 0, j = 0, n = len - 1;
        System.out.println(mid);
        while (j <= n) {
            if (nums[rewireIndex(j, len)] > mid)
                swap(nums, rewireIndex(i++, len), rewireIndex(j++, len));
            else if (nums[rewireIndex(j, len)] < mid)
                swap(nums, rewireIndex(j, len), rewireIndex(n--, len));
            else
                ++j;
        }
    }
    
    private int kthSmallestElement(int[] nums, int k) {
        int low = 0, high = nums.length - 1, mid = k - 1;
        while (low < high) {
            int i = partition(nums, low, high);
            if (i < mid) low = i + 1;
            else if (i > mid) high = i - 1;
            else break;
        }
        return nums[mid];
    }
    
    private int partition(int[] nums, int start, int end) {
        int mid = (start + end) >>> 1;
        if (nums[start] < nums[mid]) {
            swap(nums, start, mid);
        }
        if (nums[start] > nums[end]) {
            swap(nums, start, nums[mid] > nums[end] ? mid : end);
        }
        
        int i = start + 1, j = end;
        while (i <= j) {
            while (i <= j && nums[i] < nums[start]) ++i;
            while (j >= i && nums[j] >= nums[start]) --j;
            if (i <= j) swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }
    
    private int rewireIndex(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// O(nlogn) Solution
class Solution {
    public void wiggleSort(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int n = nums.length;
        int j = n - 1;
        for (int i = 1; i < n; i += 2, j -= 1) {
            nums[i] = sorted[j];
        }
        for (int i = 0; i < n; i += 2, j -= 1) {
            nums[i] = sorted[j];
        }
    }
}
