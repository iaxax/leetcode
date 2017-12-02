class Solution {
public:
	string convert(string s, int numRows) {
		vector<vector<char>> *v = new vector<vector<char>>;
		for (int i = 0; i < numRows; ++i) {
			v->push_back({});
		}
		if (numRows == 1) return s;

		int len = s.size();
		int r = 0;
		int *pos = new int[2 * numRows - 2];
		for (int i = 0; i < numRows; ++i) {
			pos[i] = i;
		}
		for (int i = 2 * numRows - 3; i >= numRows; --i) {
			pos[i] = 2 * numRows - 2 - i;
		}

		for (int i = 0; i < len; ++i) {
			(*v)[pos[r]].push_back(s[i]);
			r = (r + 1) >= 2 * numRows - 2 ? 0 : r + 1;
		}

		string result = "";
		for (int i = 0; i < numRows; ++i) {
			const vector<char> &vec = (*v)[i];
			for (char c : vec) result += c;
		}
		delete v;
		delete[] pos;

		return result;
	}
};
