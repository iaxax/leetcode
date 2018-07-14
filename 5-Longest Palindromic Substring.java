class Solution {
    public String longestPalindrome(String s) {
        String str = preprocess(s);
        
        int len = str.length();
        int[] dp = new int[len];
        int center = 0, boundary = 0, left = 0, right = 0;
        for (int i = 1; i < len; ++i) {
            dp[i] = i >= boundary ? 0 : Math.min(boundary - i, dp[2 * center - i]);
            
            while (i - 1 - dp[i] >= 0 && i + 1 + dp[i] < len && str.charAt(i - 1 - dp[i]) == str.charAt(i + 1 + dp[i]))
                ++dp[i];
            
            if (right - left < dp[i] * 2 + 1) { right = i + dp[i]; left = i - dp[i]; }
            if (boundary < i + dp[i]) { boundary = i + dp[i]; center = i; }
        }
        
        return s.substring(left >> 1, right >> 1);
    }
    
    private String preprocess(String s) {
        StringBuilder builder = new StringBuilder(s.length() * 2 + 1);
        for (char c : s.toCharArray()) {
            builder.append('#').append(c);
        }
        builder.append('#');
        return builder.toString();
    }
}
