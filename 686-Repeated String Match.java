class Solution {
    public int repeatedStringMatch(String A, String B) {
        HashSet<Character> s1 = new HashSet<>();
        for (char c : A.toCharArray()) {
            s1.add(c);
        }
        HashSet<Character> s2 = new HashSet<>();
        for (char c : B.toCharArray()) {
            s2.add(c);
        }
        for (char c : s2) {
            if (!s1.contains(c)) {
                return -1;
            }
        }
        
        int m = A.length(), n = B.length();
        String str = "";
        for (int i = 1; str.length() < m + n; ++i) {
            str += A;
            if (str.indexOf(B) != -1) {
                return i;
            }
        }
        return -1;
    }
}