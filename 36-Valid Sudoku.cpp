class Solution {
public:
	bool isValidSudoku(vector<vector<char>>& board) {
		int row = board.size();
		int col = board[0].size();
		bool rowMap[9][9] = {false}, colMap[9][9] = {false}, blockMap[9][9] = {false};
		for (int i = 0; i < 9; ++i) {
		    for (int j = 0; j < 9; ++j) {
		        if (board[i][j] == '.') continue;
		        int pos = board[i][j] - '0' - 1;
		        int r = i / 3, c = j / 3;
		        if (rowMap[i][pos] || colMap[j][pos] || blockMap[r * 3 + c][pos]) return false;
		        rowMap[i][pos] = colMap[j][pos] = blockMap[r * 3 + c][pos] = true;
		    }
		}

		return true;
	}
};