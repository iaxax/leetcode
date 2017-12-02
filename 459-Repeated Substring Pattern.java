public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int half = n / 2;
        for (int i = 1; i <= half; ++i) {
            if (n % i != 0) continue;
            boolean repeated = true;
            for (int j = 0; j < n; j += i) {
                if (j + i < n) {
                    if (!s.substring(j, j + i).equals(s.substring(j + i, j + i * 2))) {
                        repeated = false;
                        break;
                    }
                }
            }
            if (repeated) return true;
        }
        return false;
    }
}
