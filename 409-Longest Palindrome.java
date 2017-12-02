public class Solution {
    public int longestPalindrome(String s) {
        int[] letters = new int[52];
        int length = 0;
        int n = s.length();
        long map = 0;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            int index;
            if (c >= 'a' && c <= 'z') {
                index = c - 'a';
            }
            else {
                index = c - 'A' + 26;
            }
            
            if (letters[index] > 0) {
                length += 2;
                letters[index] = 0;
                map &= ~(1 << index);
            }
            else {
                letters[index] = 1;
                map |= 1 << index;
            }
        }
        return map == 0 ? length : length + 1;
    }
}
