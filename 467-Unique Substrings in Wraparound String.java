class Solution {
    public int findSubstringInWraproundString(String p) {
        int len = p.length();
        if (len <= 1) return len;
        
        int[] count = new int[26];
        count[p.charAt(0) - 'a'] = 1;
        
        int start = 0, result = 1;
        for (int i = 1; i < len; ++i) {
            if (p.charAt(i) - 'a' == (p.charAt(i - 1) - 'a' + 1) % 26) {
                int diff = i - start + 1 - count[p.charAt(i) - 'a'];
                if (diff > 0) {
                    result += diff;
                    count[p.charAt(i) - 'a'] = i - start + 1;
                }
            } else {
                start = i;
                if (count[p.charAt(i) - 'a'] < 1) {
                    count[p.charAt(i) - 'a'] = 1;
                    result += 1;
                }
            }
        }
        return result;
    }
}
