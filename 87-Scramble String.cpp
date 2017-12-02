class Solution {
public:
	bool isScramble(string s1, string s2) {
		int len1 = s1.size(), len2 = s2.size();
		if (len1 != len2) return false;
		if (s1 == s2) return true;

		unordered_map<char, int> mp;
		for (int i = 0; i < len1; ++i) {
		    mp[s1[i]] += 1;
		    mp[s2[i]] -= 1;
		}
		
		for (auto p : mp) {
		    if (p.second != 0) return false;
		}
		
		for (int i = 1; i < len1; ++i) {
		    if (isScramble(s1.substr(0, i), s2.substr(0, i)) && isScramble(s1.substr(i), s2.substr(i)))
		        return true;
		    if (isScramble(s1.substr(i), s2.substr(0, len1 - i)) && isScramble(s1.substr(0, i), s2.substr(len1 - i)))
		        return true;
		}
		
		return false;
	}
};

// DP Solution
class Solution {
public:
	bool isScramble(string s1, string s2) {
		if (s1.length() != s2.length()) return false;
		if (s1 == s2) return true;

		int len = s1.length();
		vector<vector<vector<bool>>> dp;
		dp.resize(len + 1);
		for (int i = 0; i <= len; ++i) {
			dp[i].resize(len);
			for (int j = 0; j < len; ++j) {
				dp[i][j].resize(len);
			}
		}

		for (int i = 0; i < len; ++i) {
			for (int j = 0; j < len; ++j) {
				dp[1][i][j] = s1[i] == s2[j];
			}
		}

		for (int l = 2; l <= len; ++l) {
			for (int i = 0; i <= len - l; ++i) {
				for (int j = 0; j <= len - l; ++j) {
					dp[l][i][j] = false;
					for (int k = 1; k < l && !dp[l][i][j]; ++k) {
						dp[l][i][j] = dp[l][i][j] || (dp[k][i][j] && dp[l - k][i + k][j + k]);
						dp[l][i][j] = dp[l][i][j] || (dp[k][i][j + l - k] && dp[l - k][i + k][j]);
					}
				}
			}
		}

		return dp[len][0][0];
	}
};

// Memorized Search Solution
class Solution {
public:
    bool isScramble(string s1, string s2) {
        unordered_map<string, bool> mp;
        return isScramble(mp, s1, s2);
    }

private:
    bool isScramble(unordered_map<string, bool> &mp, string s1, string s2) {
        if (s1.length() != s2.length()) return false;
        if (s1 == s2) return true;
        
        if (mp.find(s1 + s2) != mp.end()) return mp[s1 + s2];
        
        int len = s1.length();
        for (int i = 1; i < len; ++i) {
            if (isScramble(mp, s1.substr(0, i), s2.substr(0, i)) && isScramble(mp, s1.substr(i), s2.substr(i))) 
                return mp[s1 + s2] = true;
            if (isScramble(mp, s1.substr(0, i), s2.substr(len - i)) && isScramble(mp, s1.substr(i), s2.substr(0, len - i)))
                return mp[s1 + s2] = true;
        }
        
        return mp[s1 + s2] = false;
    }
};