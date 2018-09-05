class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; ++i) {
            int n = i;
            boolean valid = true, changed = false;
            while (n > 0) {
                int d = (n % 10);
                if (d == 3 || d == 4 || d == 7) {
                    valid = false;
                    break;
                }
                if (d == 2 || d == 5 || d == 6 || d == 9) {
                    changed = true;
                }
                n /= 10;
            }
            
            if (valid && changed) {
                count += 1;
            }
        }
        return count;
    }
}