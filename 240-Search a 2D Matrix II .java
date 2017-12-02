// O(mlogn) Soution
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; ++i) {
            if (Arrays.binarySearch(matrix[i], target) >= 0) return true;
        }
        return false;
    }
}

// O(m+n) Solution
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int r = 0, c = col - 1;
        while (r < row && c >= 0) {
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] < target) ++r;
            else --c;
        }
        return false;
    }
}
