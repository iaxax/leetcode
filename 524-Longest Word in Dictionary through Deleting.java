class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        for (String str : d) {
            if (isSubsequence(str, s)) return str;
        }
        return "";
    }
    
    private boolean isSubsequence(String s1, String s2) {
        int i = 0, j = 0, len1 = s1.length(), len2 = s2.length();
        while (i < len1 && j < len2) {
            if (s1.charAt(i) == s2.charAt(j)) ++i;
            ++j;
        }
        return i == len1;
    }
}

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longestStr = "";
        for (String str : d) {
            if (isSubsequence(str, s)) {
                if (longestStr.length() < str.length() || longestStr.length() == str.length() && longestStr.compareTo(str) > 0) {
                    longestStr = str;
                }
            }
        }
        return longestStr;
    }
    
    private boolean isSubsequence(String s1, String s2) {
        int i = 0, j = 0, len1 = s1.length(), len2 = s2.length();
        while (i < len1 && j < len2) {
            if (s1.charAt(i) == s2.charAt(j)) ++i;
            ++j;
        }
        return i == len1;
    }
}
