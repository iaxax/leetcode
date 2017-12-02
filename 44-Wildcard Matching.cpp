class Solution {
public:
	bool isMatch(string s, string p) {
		int slen = s.size(), plen = p.size();
		int i = 0, j = 0, starPos = -1, match;
		while (i < slen) {
			if (j < plen && (s[i] == p[j] || p[j] == '?')) {
				++i; ++j;
			}
			else if (j < plen && p[j] == '*') {
				starPos = j++;
				match = i;
			}
			else if (starPos != -1) {
				i = match++;
				j = starPos + 1;
			}
			else {
				return false;
			}
		}

		while (j < plen && p[j] == '*') ++j;
		return j == plen;
	}
};