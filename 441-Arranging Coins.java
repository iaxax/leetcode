public class Solution {
    public int arrangeCoins(int n) {
        return (int)Math.floor(-0.5 + 0.5 * Math.sqrt(1 + 8L * n));
    }
}
