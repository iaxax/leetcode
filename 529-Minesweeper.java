class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0], c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X'; return board;
        }
        
        int row = board.length, col = board[0].length;
        char[][] matrix = new char[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                matrix[i][j] = '0';
            }
        }
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'M') {
                    matrix[i][j] = 'M';
                    for (int x = i - 1; x <= i + 1; ++x) {
                        for (int y = j - 1; y <= j + 1; ++y) {
                            if (x >= 0 && x < row && y >= 0 && y < col && board[x][y] != 'M') {
                                ++matrix[x][y];
                            }
                        }
                    }
                }
            }
        }
        

        if (matrix[r][c] != '0') {
            board[r][c] = matrix[r][c]; return board;
        }
        
        openEmpty(board, matrix, r, c);
        return board;
    }
    
    private void openEmpty(char[][] board, char[][] matrix, int r, int c) {
        int row = board.length, col = board[0].length;
        if (r >= 0 && r < row && c >= 0 && c < col && board[r][c] == 'E') {
            if (matrix[r][c] != '0') {
                board[r][c] = matrix[r][c]; return;
            }
            board[r][c] = 'B';
            for (int i = r - 1; i <= r + 1; ++i) {
                for (int j = c - 1; j <= c + 1; ++j) {
                    openEmpty(board, matrix, i, j);
                }
            }
        }
    }
}

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0], c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X'; return board;
        }
        
        click(board, r, c);
        return board;
    }
    
    private void click(char[][] board, int r, int c) {
        int row = board.length, col = board[0].length;
        if (r >= 0 && r < row && c >= 0 && c < col && board[r][c] == 'E') {
            int count = 0;
            for (int i = r - 1; i <= r + 1; ++i) {
                for (int j = c - 1; j <= c + 1; ++j) {
                    if (i >= 0 && i < row && j >= 0 && j < col && board[i][j] == 'M')
                        ++count;
                }
            }
            
            if (count > 0) {
                board[r][c] = (char)(count + '0'); return;
            }
            
            board[r][c] = 'B';
            for (int i = r - 1; i <= r + 1; ++i) {
                for (int j = c - 1; j <= c + 1; ++j) {
                    click(board, i, j);
                }
            }
        }
    }
}
