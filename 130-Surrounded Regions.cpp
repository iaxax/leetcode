class Solution {
public:
    void solve(vector<vector<char>>& board) {
        int row = board.size();
        if (row == 0) return;
        int col = board[0].size();
        if (col == 0) return;
        
        for (int i = 0; i < row; ++i) {
            fillPlaceholder(board, i, 0, row, col);
            if (col > 1)
                fillPlaceholder(board, i, col - 1, row, col);
        }
        
        for (int i = 1; i < col - 1; ++i) {
            fillPlaceholder(board, 0, i, row, col);
            if (row > 1)
                fillPlaceholder(board, row - 1, i, row, col);
        }
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == '-') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    
private:
    void fillPlaceholder(vector<vector<char>> &board, int i, int j, int row, int col) {
        if (board[i][j] == 'O') {
            board[i][j] = '-';
            if (i + 1 < row)
                fillPlaceholder(board, i + 1, j, row, col);
            if (i - 1 > 0)
                fillPlaceholder(board, i - 1, j, row, col);
            if (j + 1 < col)
                fillPlaceholder(board, i, j + 1, row, col);
            if (j - 1 > 0)
                fillPlaceholder(board, i, j - 1, row, col);
        }
    }
};