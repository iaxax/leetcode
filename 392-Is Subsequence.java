class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int i = 0, j = 0;
        while (i < slen) {
            char c = s.charAt(i);
            while (j < tlen && t.charAt(j) != c) ++j;
            if (j == tlen) return false;
            j += 1;
            i += 1;
        }
        return true;
    }
}
