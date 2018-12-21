class Solution {
    public int numTilings(int N) {
        int c = 1000000007;
        long[] nums = new long[Math.max(3, N + 1)];
        long[] arr = {1, 1, 2};
        for (int i = 0; i <= 2; ++i) {
            nums[i] = arr[i];
        }
        
        for (int i = 3; i <= N; ++i) {
            nums[i] += nums[i - 1] + nums[i - 2];
            if (nums[i] > Integer.MAX_VALUE) {
                nums[i] %= c;
            }
            for (int j = i - 3; j >= 0; --j) {
                nums[i] += 2 * nums[j];
                if (nums[i] > Integer.MAX_VALUE) {
                    nums[i] %= c;
                }
            }
        }
        return (int)(nums[N] % c);
    }
}

class Solution {
    public int numTilings(int N) {
        long[] nums = new long[Math.max(4, N + 1)];
        int[] arr = {0, 1, 2, 5};
        for (int i = 0; i <= 3; ++i) {
            nums[i] = arr[i];
        }
        
        for (int i = 4; i <= N; ++i) {
            nums[i] = 2 * nums[i - 1] + nums[i - 3];
            nums[i] = nums[i] % 1000000007;
        }
        return (int)nums[N];
    }
}