class Solution {
    public int countSubstrings(String s) {
        String str = transfer(s);
        int len = str.length();
        int[] dp = new int[len];
        int count = 0, center = 0, right = 0;
        for (int i = 0; i < len; ++i) {
            dp[i] = i >= right ? 0 : Math.min(right - i, dp[2 * center - i]);
            while (i + dp[i] < len && i - dp[i] >= 0 && str.charAt(i + dp[i]) == str.charAt(i - dp[i])) ++dp[i];
            count += dp[i] >> 1;
            if (i + dp[i] > right) {
                right = i + dp[i];
                center = i;
            }
        }
        return count;
    }
    
    private String transfer(String s) {
        StringBuilder builder = new StringBuilder(s.length() * 2 + 1);
        for (char c : s.toCharArray()) builder.append('#').append(c);
        builder.append('#');
        return builder.toString();
    }
}
