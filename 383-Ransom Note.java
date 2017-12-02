public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dict = new int[26];
        for (int i = 0; i < magazine.length(); ++i) {
            dict[magazine.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < ransomNote.length(); ++i) {
            int index = ransomNote.charAt(i) - 'a';
            if (dict[index] == 0) return false;
            dict[index] -= 1;
        }
        return true;
    }
}
