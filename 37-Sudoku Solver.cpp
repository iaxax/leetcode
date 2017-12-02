class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        solveSudoku(board, 0);
    }
    
private:
    bool solveSudoku(vector<vector<char>> &board, int pos) {
        if (pos == 81) return true;
        
        int row = board.size();
        int col = board[0].size();
        int r = pos / row;
        int c = pos - r * row;
        if (board[r][c] != '.') {
            return solveSudoku(board, pos + 1);
        }
        else {
            const vector<char> &v = getValidNum(board, r, c);
            for (char ch : v) {
                board[r][c] = ch;
                if (solveSudoku(board, pos + 1)) return true;
                board[r][c] = '.';
            }
            return false;
        }
    }
    
    vector<char> getValidNum(const vector<vector<char>> &board, int r, int c) {
        int row = board.size();
        int col = board[0].size();
        bool exist[9] = {false};
        
        for (int i = 0; i < row; ++i) {
            if (i == r) continue;
            if (board[i][c] != '.') exist[board[i][c] - '0' - 1] = true;
        }
        
        for (int i = 0; i < col; ++i) {
            if (i == c) continue;
            if (board[r][i] != '.') exist[board[r][i] - '0' - 1] = true;
        }
        
        int rr = r / 3 * 3, cc = c / 3 * 3;
        for (int i = rr; i < rr + 3; ++i) {
            for (int j = cc; j < cc + 3; ++j) {
                if (i == r && j == c) continue;
                if (board[i][j] != '.') exist[board[i][j] - '0' - 1] = true;
            }
        }
        
        vector<char> result;
        for (int i = 0; i < 9; ++i) {
            if (!exist[i]) result.push_back('0' + (i + 1));
        }
        return result;
    }
};