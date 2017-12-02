public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        
        int n = num;
        while ((n / 2) * 2 == n) {
            n /= 2;
        }
        
        while ((n / 3) * 3 == n) {
            n /= 3;
        }
        
        while ((n / 5) * 5 == n) {
            n /= 5;
        }
        
        return n == 1;
    }
}
