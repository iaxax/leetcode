class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                int lives = 0;
                for (int m = i - 1; m <= i + 1; ++m) {
                    for (int n = j - 1; n <= j + 1; ++n) {
                        if (m == i && n == j) continue;
                        if (m >= 0 && m < row && n >= 0 && n < col && board[m][n] > 0) {
                            lives += 1;
                        }
                    }
                }
                
                if (board[i][j] == 1) {
                    if (lives < 2 || lives > 3) {
                        board[i][j] = 2;
                    }
                    else {
                        board[i][j] = 1;
                    }
                }
                else if (lives == 3) {
                    board[i][j] = -1;
                }
            }
        }
                
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (Math.abs(board[i][j]) == 1) {
                    board[i][j] = 1;
                }
                else {
                    board[i][j] = 0;
                }
            }
        }
    }
}
