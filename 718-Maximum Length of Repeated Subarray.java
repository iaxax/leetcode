class Solution {
    public int findLength(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length, maxLen = 0;
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 1; i <= lenA; ++i) {
            for (int j = 1; j <= lenB; ++j) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }
}
