public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n1 = g.length, n2 = s.length;
        int i = 0, j = 0;
        int count = 0;
        while (i < n1 && j < n2) {
            if (g[i] <= s[j]) {
                ++i; ++j;
                count += 1;
            }
            else {
                ++j;
            }
        }
        return count;
    }
}
