class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        vector<int> lens;
        for (const string &word : wordDict) {
            lens.push_back(word.size());
        }
        
        set<string> wordSet(wordDict.begin(), wordDict.end());
        vector<bool> dp(s.size() + 1, false);
        dp[s.size()] = true;
        
        for (int i = s.size() - 1; i >= 0; --i) {
            for (int len : lens) {
                if (i + len <= s.size() && dp[i + len]) {
                    if (wordSet.find(s.substr(i, len)) != wordSet.end()) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        
        return dp[0];
    }
};