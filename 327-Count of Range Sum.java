// brute-force
class Solution {
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = nums[i] + (long)sum[i];
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                long s = sum[j + 1] - sum[i];
                if (s >= lower && s <= upper) ++count;
            }
        }
        return count;
    }
}

// naive divide and conquer
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            sums[i + 1] = nums[i] + sums[i];
        }
        return countRangeSum(sums, 0, n - 1, lower, upper);
    }
    
    private int countRangeSum(long[] sums, int l, int r, int lower, int upper) {
        if (l > r) return 0;
        
        int mid = (l + r) >>> 1;
        int count = countRangeSum(sums, l, mid - 1, lower, upper)
            + countRangeSum(sums, mid + 1, r, lower, upper);
        for (int i = l; i <= mid; ++i) {
            for (int j = mid; j <= r; ++j) {
                long s = sums[j + 1] - sums[i];
                if (s >= lower && s <= upper) ++count;
            }
        }
        return count;
    }
}

// smart divide and conquer
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        return countRangeSum(nums, 0, nums.length - 1, lower, upper);
    }
    
    private int countRangeSum(int[] nums, int l, int r, int lower, int upper) {
        if (l > r) return 0;
        if (l == r) return nums[l] >= lower && nums[r] <= upper ? 1 : 0;
        
        int mid = (l + r) >>> 1;
        int count = countRangeSum(nums, l, mid, lower, upper) + countRangeSum(nums, mid + 1, r, lower, upper);
        long[] prefix = new long[r - mid];
        long sum = 0;
        for (int i = mid + 1; i <= r; ++i) {
            sum += nums[i];
            prefix[i - mid - 1] = sum;
        }
        Arrays.sort(prefix);
        
        sum = 0;
        for (int i = mid; i >= l; --i) {
            sum += nums[i];
            count += findIndex(prefix, upper - sum + 0.5) - findIndex(prefix, lower - sum - 0.5);
        }
        return count;
    }
    
    private int findIndex(long[] arr, double val) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

// merge sort based
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        return countRangeSum(sums, 0, n + 1, lower, upper);
    }
    
    private int countRangeSum(long[] sums, int l, int r, int lower, int upper) {
        if (r - l <= 1) return 0;
        
        int mid = (l + r) >>> 1;
        int count = countRangeSum(sums, l, mid, lower, upper) + countRangeSum(sums, mid, r, lower, upper);
        long[] cached = new long[r - l];
        int m = mid, n = mid, t = mid;
        for (int i = l, j = 0; i < mid; ++i, ++j) {
            while (m < r && sums[m] - sums[i] < lower) ++m;
            while (n < r && sums[n] - sums[i] <= upper) ++n;
            while (t < r && sums[t] < sums[i]) cached[j++] = sums[t++];
            cached[j] = sums[i];
            count += n - m;
        }
        
        System.arraycopy(cached, 0, sums, l, t - l);
        return count;
    }
}