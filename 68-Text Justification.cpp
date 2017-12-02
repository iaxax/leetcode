class Solution {
public:
	vector<string> fullJustify(vector<string>& words, int maxWidth) {
		int sz = words.size(), i = 0;
		vector<string> result;
		while (i < sz) {
			int wordNum = 1, width = words[i].size();
			while (i + 1 < sz && width + words[i + 1].length() + wordNum <= maxWidth) {
				width += words[++i].length();
				wordNum += 1;
			}

			string str = words[i - wordNum + 1];
			for (int j = 0; j < wordNum - 1; ++j) {
				int space = (maxWidth - width) / (wordNum - 1);
				int moreSpaceBound = (maxWidth - width) % (wordNum - 1);
				if (i + 1 == sz) {
					str += " ";
				}
				else {
					str += string(space + (j < moreSpaceBound ? 1 : 0), ' ');
				}
				str += words[i - wordNum + 2 + j];
			}

			str += string(maxWidth - str.size(), ' ');
			result.push_back(str);
			i += 1;
		}
		return result;
	}
};