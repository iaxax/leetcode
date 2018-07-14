class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return new int[0];
        int col = matrix[0].length;
        if (col == 0) return new int[0];
        
        int size = row * col, r = 0, c = 0;
        boolean up = true;
        int[] result = new int[size];
        for (int i = 0; i < size; ++i) {
            result[i] = matrix[r][c];
            if (up) {
                if (r - 1 >= 0 && c + 1 < col) {
                    --r; ++c;
                } else if (c + 1 < col) {
                    up = false;
                    ++c;
                } else {
                    up = false;
                    ++r;
                }
            } else {
                if (c - 1 >= 0 && r + 1 < row) {
                    --c; ++r;
                } else if (r + 1 < row) {
                    up = true;
                    ++r;
                } else {
                    up = true;
                    ++c;
                }
            }
        }
        return result;
    }
}

