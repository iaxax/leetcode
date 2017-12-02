class Solution {
public:
	bool isMatch(string s, string p) {
		int sLen = s.size(), pLen = p.size();
		bool **dp = new bool*[sLen + 1];
		for (int i = 0; i <= sLen; ++i) {
			dp[i] = new bool[pLen + 1];
		}

		dp[0][0] = true;
		for (int i = 1; i <= sLen; ++i) {
			dp[i][0] = false;
		}

		dp[0][1] = false;
		for (int i = 2; i <= pLen; ++i) {
			dp[0][i] = p[i - 1] == '*' && dp[0][i - 2];
		}

		for (int i = 1; i <= sLen; ++i) {
			for (int j = 1; j <= pLen; ++j) {
				if (p[j - 1] == '*') {
					dp[i][j] = dp[i][j - 2] || ((s[i - 1] == p[j - 2] || p[j - 2] == '.') && dp[i - 1][j]);
				}
				else {
					dp[i][j] = (s[i - 1] == p[j - 1] || p[j - 1] == '.') && dp[i - 1][j - 1];
				}
			}
		}

		bool result = dp[sLen][pLen];
		for (int i = 0; i <= sLen; ++i) {
			delete[] dp[i];
		}
		delete[] dp;
		return result;
	}
};
