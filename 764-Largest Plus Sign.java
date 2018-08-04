class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] board = new int[N][N];
        initialize(board);
        
        for (int[] mine : mines) {
            int r = mine[0], c = mine[1];
            board[r][c] = 0;
            
            for (int i = r - 1; i >= 0; --i) {
                if (r - i < board[i][c]) {
                    board[i][c] = r - i;
                }
            }
            for (int i = r + 1; i < N; ++i) {
                if (i - r < board[i][c]) {
                    board[i][c] = i - r;
                }
            }
            
            for (int i = c - 1; i >= 0; --i) {
                if (c - i < board[r][i]) {
                    board[r][i] = c - i;
                }
            }
            for (int i = c + 1; i < N; ++i) {
                if (i - c < board[r][i]) {
                    board[r][i] = i - c;
                }
            }
        }
        
        return maxPlusSign(board);
    }
    
    private void initialize(int[][] board) {
        int n = board.length;
        int l = n / 2;
        for (int i = 0; i <= l; ++i) {
            for (int j = i; j < n - 1 - i; ++j) {
                board[i][j] = i + 1;
                board[j][n - 1 - i] = i + 1;
            }
            for (int j = i + 1; j < n - i; ++j) {
                board[j][i] = i + 1;
                board[n - 1 - i][j] = i + 1;
            }
        }
        
        if (n % 2 == 1) {
            board[l][l] = l + 1;
        }
    }
    
    private int maxPlusSign(int[][] board) {
        int n = board.length;
        int result = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                result = Math.max(result, board[i][j]);
            }
        }
        return result;
    }
}

class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] board = new int[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(board[i], N);
        }
        
        for (int[] mine : mines) {
            int r = mine[0], c = mine[1];
            board[r][c] = 0;
        }
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; ++j, --k) {
                board[i][j] = Math.min(board[i][j], l = (board[i][j] == 0 ? 0 : l + 1));
                board[i][k] = Math.min(board[i][k], r = (board[i][k] == 0 ? 0 : r + 1));
                board[j][i] = Math.min(board[j][i], u = (board[j][i] == 0 ? 0 : u + 1));
                board[k][i] = Math.min(board[k][i], d = (board[k][i] == 0 ? 0 : d + 1));
            }
        }
        
        int result = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                result = Math.max(result, board[i][j]);
            }
        }
        return result;
    }
}