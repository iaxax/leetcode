class Solution {
public:
    int numTrees(int n) {
        vector<int> dp(n + 1, 0);
        for (int len = 1; len <= n; ++len) {
            for (int i = 0; i < len; ++i) {
                int left = dp[i] == 0 ? 1 : dp[i];
                int right = dp[len - 1 - i] == 0 ? 1 : dp[len - 1 - i];
                dp[len] += left * right;
            }
        }
        return dp[n];
    }
};