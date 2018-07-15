class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int result = 0;
        int[][] path = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                result = Math.max(result, findPath(path, matrix, i, j));
            }
        }
        return result;
    }
    
    private int findPath(int[][] path, int[][] matrix, int i, int j) {
        if (path[i][j] > 0) return path[i][j];
        
        int m = path.length, n = path[0].length;
        int length = 0, val = matrix[i][j];
        if (i - 1 >= 0 && matrix[i - 1][j] > val) {
            length = Math.max(length, findPath(path, matrix, i - 1, j));
        }
        if (i + 1 < m && matrix[i + 1][j] > val) {
            length = Math.max(length, findPath(path, matrix, i + 1, j));
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > val) {
            length = Math.max(length, findPath(path, matrix, i, j - 1));
        }
        if (j + 1 < n && matrix[i][j + 1] > val) {
            length = Math.max(length, findPath(path, matrix, i, j + 1));
        }
        return path[i][j] = 1 + length;
    }
}