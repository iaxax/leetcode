class Solution {
public:
	vector<vector<int>> generateMatrix(int n) {
		vector<vector<int>> result;
		result.resize(n);
		for (int i = 0; i < n; ++i) {
			result[i].resize(n);
		}

		int dir[4][2] = { { 0, 1 },{ 1, 0 },{ 0, -1 },{ -1, 0 } };
		int len[2] = { n, n - 1 };
		int r = 0, c = -1;
		int dirIdx = 0, num = 1;;
		while (len[dirIdx % 2]) {
			for (int i = 0; i < len[dirIdx % 2]; ++i) {
				r += dir[dirIdx][0];
				c += dir[dirIdx][1];
				result[r][c] = num++;
			}
			len[dirIdx % 2]--;
			dirIdx = (dirIdx + 1) % 4;
		}

		return result;
	}
};