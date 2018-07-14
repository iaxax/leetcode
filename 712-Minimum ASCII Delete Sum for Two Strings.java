class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int sum1 = 0;
        for (char c : s1.toCharArray()) sum1 += c;
        int sum2 = 0;
        for (char c : s2.toCharArray()) sum2 += c;
        
        return sum1 + sum2 - (lcs(s1, s2) << 1);
    }
    
    private int lcs(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][][] dp = new int[len1 + 1][len2 + 1][2];
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j][0] = dp[i - 1][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j - 1][1] + s1.charAt(i - 1);
                } else {
                    if (dp[i - 1][j][0] > dp[i][j - 1][0]) {
                        dp[i][j][0] = dp[i - 1][j][0];
                        dp[i][j][1] = dp[i - 1][j][1];
                    } else if (dp[i - 1][j][0] < dp[i][j - 1][0]) {
                        dp[i][j][0] = dp[i][j - 1][0];
                        dp[i][j][1] = dp[i][j - 1][1];
                    } else {
                        dp[i][j][0] = dp[i][j - 1][0];
                        dp[i][j][1] = Math.max(dp[i][j - 1][1], dp[i - 1][j][1]);
                    }
                }
            }
        }
        return dp[len1][len2][1];
    }
}

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int sum1 = 0;
        for (char c : s1.toCharArray()) sum1 += c;
        int sum2 = 0;
        for (char c : s2.toCharArray()) sum2 += c;
        
        return sum1 + sum2 - (lcs(s1, s2) << 1);
    }
    
    private int lcs(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.codePointAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
