class Solution {
public:
	int strStr(string haystack, string needle) {
		return kmp(haystack, needle);
	}
private:
	int kmp(const string &str, const string &pat) {
		int *n = next(pat);
		int len1 = str.size(), len2 = pat.size();
		if (len2 == 0) return 0;
		if (len1 == 0) return len2 == 0 ? 0 : -1;

		int i = 0, j = 0;
		while (i < len1 && j < len2) {
			if (j == -1 || str[i] == pat[j]) {
				++i; ++j;
			}
			else {
				j = n[j];
			}
		}

		delete[] n;
		return j == len2 ? i - len2 : -1;
	}
	
	int* next(const string &pat) {
		int len = pat.size();
		int *n = new int[len + 1];
		int k = -1, i = 0;
		n[i] = k;
		while (i < len) {
			if (k == -1 || pat[i] == pat[k]) {
				++i; ++k;
				n[i] = k;
			}
			else {
				k = n[k];
			}
		}
		return n;
	}
};