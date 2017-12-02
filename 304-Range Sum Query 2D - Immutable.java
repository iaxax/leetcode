class NumMatrix {
    
    int[][] accumulate;

    public NumMatrix(int[][] matrix) {
        if (matrix.length > 0 && matrix[0].length > 0) {
            int row = matrix.length, col = matrix[0].length;
            accumulate = new int[row][col];
            accumulate[0][0] = matrix[0][0];
            for (int i = 1; i < col; ++i) {
                accumulate[0][i] = accumulate[0][i - 1] + matrix[0][i];
            }
            for (int i = 1; i < row; ++i) {
                accumulate[i][0] = accumulate[i - 1][0] + matrix[i][0];
            }
            for (int i = 1; i < row; ++i) {
                for (int j = 1; j < col; ++j) {
                    accumulate[i][j] = accumulate[i - 1][j] + accumulate[i][j - 1] - accumulate[i - 1][j - 1] + matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = accumulate[row2][col2];
        if (row1 > 0) {
            sum -= accumulate[row1 - 1][col2];
        }
        if (col1 > 0) {
            sum -= accumulate[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            sum += accumulate[row1 - 1][col1 - 1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
