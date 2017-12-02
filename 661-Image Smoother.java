class Solution {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length, col = M[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                result[i][j] = getAvg(i, j, M);
            }
        }
        return result;
    }
    
    private int getAvg(int r, int c, int[][] M) {
        int sum = 0, count = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (r + i >= 0 && r + i < M.length && c + j >= 0 && c + j < M[0].length) {
                    sum += M[r + i][c + j]; ++count;
                }
            }
        }
        return (int)(sum / (double)count);
    }
}
