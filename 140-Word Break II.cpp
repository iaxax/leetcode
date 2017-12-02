class Solution {
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        vector<vector<string>> dp(s.size() + 1, vector<string>());
        dp[s.size()].push_back("");
        
        for (int i = s.size() - 1; i >= 0; --i) {
            for (const string &word : wordDict) {
                if (i + word.size() <= s.size() && !dp[i + word.size()].empty()) {
                    if (s.substr(i, word.size()) == word) {
                        dp[i].push_back(word);
                    }
                }
            }
        }
        
        vector<string> result, temp;
        if (!dp[0].empty()) {
            dp.pop_back();
            extract(dp, result, temp, 0);
        }
        return result;
    }
    
private:
    void extract(const vector<vector<string>> words, vector<string> &result, vector<string> &temp, int start) {
        if (start == words.size()) {
            string str = temp[0];
            for (int i = 1; i < temp.size(); ++i) {
                str += " " + temp[i];
            }
            result.push_back(str);
            return;
        }
        
        for (const string &word : words[start]) {
            temp.push_back(word);
            extract(words, result, temp, start + word.size());
            temp.pop_back();
        }
    }
};