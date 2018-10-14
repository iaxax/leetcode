class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) {
            count[c - 'a'] += 1;
        }
        
        StringBuilder result = new StringBuilder(T.length());
        for (char c : S.toCharArray()) {
            int n = count[c - 'a'];
            for (int i = 0; i < n; ++i) {
                result.append(c);
            }
            count[c - 'a'] = 0;
        }
        
        for (int i = 0; i < 26; ++i) {
            int n = count[i];
            for (int j = 0; j < n; ++j) {
                result.append((char)(i + 'a'));
            }
        }
        
        return result.toString();
    }
}