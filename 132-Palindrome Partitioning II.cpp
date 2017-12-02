class Solution {
public:
    int minCut(string s) {
        vector<int> dp(s.size() + 1, 0);
        for (int i = 0; i <= s.size(); ++i) dp[i] = i - 1;
        
        for (int i = 0; i < s.size(); ++i) {
            for (int len = 0; i - len >= 0 && i + len < s.size() && s[i - len] == s[i + len]; ++len)
                dp[i + len + 1] = min(dp[i + len + 1], dp[i - len] + 1);
                
            for (int len = 0; i - len >= 0 && i + 1 + len < s.size() && s[i - len] == s[i + 1 + len]; ++len)
                dp[i + len + 2] = min(dp[i + len + 2], dp[i - len] + 1);
        }
        
        return s.size() == 0 ? 0 : dp[s.size()];
    }
};
