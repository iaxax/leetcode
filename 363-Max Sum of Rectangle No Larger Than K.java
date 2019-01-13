class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int result = Integer.MIN_VALUE;
        int row = matrix.length, col = matrix[0].length;
        for (int l = 0; l < col; ++l) {
            int[] sums = new int[row];
            for (int r = l; r < col; ++r) {
                for (int i = 0; i < row; ++i) {
                    sums[i] += matrix[i][r];
                }
                
                TreeSet<Integer> accSum = new TreeSet<>();
                accSum.add(0);
                int curSum = 0, curMax = Integer.MIN_VALUE;
                for (int sum : sums) {
                    curSum += sum;
                    Integer s = accSum.ceiling(curSum - k);
                    if (s != null) curMax = Math.max(curMax, curSum - s);
                    accSum.add(curSum);
                }
                result = Math.max(result, curMax);
            }
        }
        return result;
    }
}