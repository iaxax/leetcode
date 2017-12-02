// O(nlogn) Solution
class Solution {
    public boolean judgeSquareSum(int c) {
        int upbound = (int)Math.sqrt(c);
        if (upbound * upbound == c) return true;
        
        for (long i = upbound; 2 * i * i >= c; --i) {
            long square = i * i;
            long left = 0, right = i;
            while (left <= right) {
                long mid = (left + right) / 2;
                long sum = mid * mid + square;
                if (sum == c) return true;
                else if (sum < c) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}

// O(n) Solution
class Solution {
    public boolean judgeSquareSum(int c) {
        int small = 0, large = (int) Math.sqrt(c);
        while (small <= large) {
            long sum = (long)small * small + (long)large * large;
            if (sum == c) return true;
            if (sum < c) ++small;
            else --large;
        }
        return false;
    }
}

