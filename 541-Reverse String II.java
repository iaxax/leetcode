class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i += 2 * k) {
            if (i + k >= n) {
                sb.append(new StringBuilder(s.substring(i)).reverse().toString());
            }
            else {
                sb.append(new StringBuilder(s.substring(i, i + k)).reverse().toString());
                if (i + 2 * k >= n) {
                    sb.append(s.substring(i + k));
                }
                else {
                    sb.append(s.substring(i + k, i + 2 * k));
                }
            }
        }
        return sb.toString();
    }
}
