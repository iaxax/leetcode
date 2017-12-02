public class Solution {
    public int countSegments(String s) {
        int count = 0, n = s.length();
        int i = 0;
        while (i < n) {
            while (i < n && s.charAt(i) == ' ') ++i;
            if (i == n) break;
            while (i < n && s.charAt(i) != ' ') ++i;
            ++count;
        }
        return count;
    }
}
