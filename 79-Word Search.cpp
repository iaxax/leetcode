class Solution {
public:
	bool exist(vector<vector<char>>& board, string word) {
		int row = board.size();
		if (row == 0) return false;
		int col = board[0].size();
		if (col == 0) return false;

		int len = word.size();
		if (len == 0) return true;

		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (exist(board, i, j, word, 0)) {
					return true;
				}
			}
		}

		return false;
	}

private:
	bool exist(vector<vector<char>> &board, int r, int c,
		const string &word, int i)
	{
		if (i == word.length()) return true;
        if (!inside(board.size(), board[0].size(), r, c)) return false;
        if (board[r][c] == '\0' || board[r][c] != word[i]) return false;
        
        char temp = board[r][c];
        board[r][c] = '\0';
        
        bool found = exist(board, r + 1, c, word, i + 1)
                || exist(board, r, c + 1, word, i + 1)
                || exist(board, r - 1, c, word, i + 1)
                || exist(board, r, c - 1, word, i + 1);
        
        board[r][c] = temp;
        return found;
	}

	inline bool inside(int row, int col, int r, int c) {
		return r >= 0 && r < row && c >= 0 && c < col;
	}
};