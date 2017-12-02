class Solution {
public:
	int numDistinct(string s, string t) {
		int slen = s.size(), tlen = t.size();
		vector<vector<int>> dp(tlen + 1, vector<int>(slen + 1, 0));
		for (int i = 0; i <= slen; ++i) {
			dp[0][i] = 1;
		}

		for (int i = 1; i <= tlen; ++i) {
			for (int j = 1; j <= slen; ++j) {
				if (t[i - 1] == s[j - 1]) {
				    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
				}
				else {
				    dp[i][j] = dp[i][j - 1];
				}
			}
		}

		return dp[tlen][slen];
	}
};