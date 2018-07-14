class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1, word2);
        return word1.length() - lcs + word2.length() - lcs;
    }
    
    private int longestCommonSubsequence(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
