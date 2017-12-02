public class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int vowel = n - 1;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                while(vowel >= 0 && !isVowel(s.charAt(vowel))) {
                    --vowel;
                }
                sb.append(s.charAt(vowel));
                --vowel;
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
