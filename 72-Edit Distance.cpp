class Solution {
public:
    int minDistance(string word1, string word2) {
        int len1 = word1.length(), len2 = word2.length();
        vector<int> dp(len2 + 1);
        for (int i = 0; i <= len2; ++i) {
            dp[i] = i;
        }
        
        for (int i = 1; i <= len1; ++i) {
            int pre = dp[0];
            dp[0] = i;
            for (int j = 1; j <= len2; ++j) {
                int up = dp[j];
                if (word1[i - 1] == word2[j - 1]) {
                    dp[j] = pre;
                }
                else {
                    dp[j] = min(up, min(pre, dp[j - 1])) + 1;
                }
                pre = up;
            }
        }
        
        return dp[len2];
    }
};