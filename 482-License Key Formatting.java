class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = process(S);
        int pos = 0, n = S.length();
        if (n == 0) return "";
        
        int headLength = n % K == 0 ? K : n % K;
        StringBuilder result = new StringBuilder();
        result.append(S.substring(pos, headLength));
        pos += headLength;
        while (pos < n) {
            result.append('-');
            result.append(S.substring(pos, pos + K));
            pos += K;
        }
        return result.toString();
    }
    
    private String process(String s) {
        s = s.toUpperCase();
        StringBuilder result = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if (c != '-') result.append(c);
        }
        return result.toString();
    }
}