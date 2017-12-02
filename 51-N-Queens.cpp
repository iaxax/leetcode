class Solution {
public:
	vector<vector<string>> solveNQueens(int n) {
		vector<vector<string>> result;
		vector<int> queens;
		solveNQueens(queens, n, 0, result);
		return result;
	}

private:
	void solveNQueens(vector<int> &queens, int n, int row, vector<vector<string>> &result) {
		if (row == n) {
			vector<string> v;
			for (int i = 0; i < queens.size(); ++i) {
				string str = "";
				for (int j = 0; j < n; ++j) {
					str += j == queens[i] ? 'Q' : '.';
				}
				v.push_back(str);
			}
			result.push_back(v);
			return;
		}

		for (int i = 0; i < n; ++i) {
			if (queenValid(queens, row, i)) {
				queens.push_back(i);
				solveNQueens(queens, n, row + 1, result);
				queens.pop_back();
			}
		}
	}

	bool queenValid(const vector<int> &queens, int row, int col) {
		for (int i = 0; i < queens.size(); ++i) {
			if (col == queens[i] || (abs(i - row) == abs(queens[i] - col))) {
				return false;
			}
		}
		return true;
	}
};