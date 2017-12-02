class Solution {
public:
	string countAndSay(int n) {
		string result = "1";
		for (int i = 1; i < n; ++i) {
			string next = "";
			int len = result.size();
			for (int j = 0; j < len; ++j) {
				int from = j;
				while (j + 1 < len && result[j] == result[j + 1]) ++j;
				next += to_string(j - from + 1);
				next += result[from];
			}
			result = next;
		}
		return result;
	}
};