public class Solution {
    public char findTheDifference(String s, String t) {
        int[] dict1 = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            dict1[s.charAt(i) - 'a'] += 1;
        }
        
        int[] dict2 = new int[26];
        for (int i = 0; i < t.length(); ++i) {
            dict2[t.charAt(i) - 'a'] += 1;
        }
        
        for (int i = 0; i < 26; ++i) {
            if (dict1[i] == dict2[i] - 1) return (char)(i + 'a');
        }
        return 0;
    }
}
