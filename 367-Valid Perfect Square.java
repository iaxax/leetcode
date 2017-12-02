public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num <= 1) return true;
        long start = 2, end = num / 2;
        while (start <= end) {
            long mid = (start + end) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            }
            else if (square < num) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}
