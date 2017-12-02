public class Solution {
    public int largestPalindrome(int n) {
        if (n==1) return 9;
        int max = (int)Math.pow(10, n) - 1;
        for (int i = max - 1; i > max / 10; --i) {
            long palindrome = Long.valueOf(i + new StringBuilder().append(i).reverse().toString());
            for (long j = max; j * j > palindrome; --j) {
                if (palindrome % j == 0) return (int)(palindrome % 1337);
            }
        }
        return 0;
    }
}
