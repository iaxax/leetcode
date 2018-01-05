class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        int count = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (!visited[i][j] && board[i][j] == 'X') {
                    markShip(board, visited, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }
    
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private void markShip(char[][] board, boolean[][] visited, int i, int j) {
        int row = board.length;
        int col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || board[i][j] == '.') {
            return;
        }
        
        visited[i][j] = true;
        for (int[] d : direction) {
            markShip(board, visited, i + d[0], j + d[1]);
        }
    }
}

// faster solution
class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        int count = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (!visited[i][j] && board[i][j] == 'X') {
                    markShip(board, visited, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }
    
    private void markShip(char[][] board, boolean[][] visited, int i, int j) {
        int row = board.length;
        int col = board[0].length;
        
        int ii = i;
        while (ii + 1 < row && board[ii + 1][j] == 'X') {
            visited[ii+ 1][j] = true;
            ii = ii + 1;
        }
        
        while (j + 1 < col && board[i][j + 1] == 'X') {
            visited[i][j + 1] = true;
            j = j + 1;
        }
    }
}

// faster and space-saving solution
class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        int count = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                count = count + 1;
            }
        }
        return count;
    }

}
