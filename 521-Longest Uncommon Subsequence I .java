class Solution {
    public int findLUSlength(String a, String b) {
        int n1 = a.length(), n2 = b.length();
        if (n1 == n2) {
            return a.equals(b) ? -1 : n1;
        }
        else {
            return Math.max(n1, n2);
        }
    }
}
