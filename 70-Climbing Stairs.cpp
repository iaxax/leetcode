class Solution {
public:
    int climbStairs(int n) {
        if (n <= 0) return n;
        int f1 = 1, f2 = 1, result = 1;
        for (int i = 1; i < n; ++i) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }

};