public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        int n = pattern.length();
        if (n != words.length) return false;
        
        Map<Character, String> char2Str = new HashMap<>();
        Map<String, Character> str2Char = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            char c = pattern.charAt(i);
            if (char2Str.containsKey(c)) {
                if(!char2Str.get(c).equals(words[i])) return false;
            }
            else if (str2Char.containsKey(words[i]) && str2Char.get(words[i]) != c) {
                return false;
            }
            char2Str.put(c, words[i]);
            str2Char.put(words[i], c);
        }
        return true;
    }
}
