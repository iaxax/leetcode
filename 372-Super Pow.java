class Solution {
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length - 1);
    }
    
    private int superPow(int a, int[] b, int index) {
        if (index < 0) return 1;
        return powMod(superPow(a, b, index - 1), 10) * powMod(a, b[index]) % 1337;
    }
    
    private int powMod(int a, int digit) {
        a %= 1337;
        int result = 1;
        for (int i = 0; i < digit; ++i) {
            result = (result * a) % 1337;
        }
        return result;
    }
}
