// O(nlogn) Solution
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}

// O(n) Solution
class Solution {
    public int arrayPairSum(int[] nums) {
        int[] arr = new int[20001];
        for (int num : nums) ++arr[num + 10000];
        int sum = 0, turn = 1, count = 0, n = nums.length;
        for (int i = 0; i < 20001;) {
            if (arr[i] > 0) {
                if (turn == 1) {
                    sum += i - 10000;
                    turn = 0;
                }
                else {
                    turn = 1;
                }
                --arr[i];
                ++count;
            }
            else {
                ++i;
            }
            if (n == count) return sum;
        }
        return sum;
    }
}
