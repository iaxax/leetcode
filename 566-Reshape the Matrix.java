class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length, col = nums[0].length;
        if (row * col != r * c) return nums;
        int[][] result = new int[r][c];
        
        int m = 0, n = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                result[i][j] = nums[m][n];
                n += 1;
                if (n == col) {
                    n = 0; ++m;
                }
            }
        }
        return result;
    }
}
