class Solution {
public:
	string longestPalindrome(string s) {
		string ss = insert(s);
		int dp[2001];
		dp[0] = 1;
		dp[1] = 2;

		int maxRight = 2, maxLength = 2;
		int len = ss.size();
		for (int i = 2; i < len; ++i) {
			int left = 2 * (maxRight - maxLength + 1) - i;
			int begin;
			if (i >= maxRight) {
				begin = i + 1;
			}
			else {
				begin = dp[left] - 1 < maxRight - i ? i + dp[left] : maxRight + 1;
			}

			while (begin < len && 2 * i - begin >= 0
				&& ss[begin] == ss[2 * i - begin])
			{
				++begin;
			}

			dp[i] = begin - i;
			if (dp[i] > maxLength) {
				maxLength = dp[i];
				maxRight = i + dp[i] - 1;
			}
		}

		int begin = maxRight - 2 * (maxLength - 1);
		string result = "";
		for (int i = begin + 1; i <= maxRight; i += 2) {
			result += ss[i];
		}
		return result;
	}
private:
	string insert(const string &s) {
		int len = s.size();
		string result = "#";
		for (int i = 0; i < len; ++i) {
			result += s[i];
			result += "#";
		}
		return result;
	}
};
