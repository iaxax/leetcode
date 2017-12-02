public class Solution {
    public int firstUniqChar(String s) {
        int[] dict = new int[26];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            dict[s.charAt(i) - 'a'] += 1;
        }
        
        for (int i = 0; i < n; ++i) {
            if (dict[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
