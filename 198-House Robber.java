public class Solution {
    
    private static class Pair {
        int a, b;
    }
    
    public int rob(int[] nums) {
        Pair[] money = new Pair[nums.length + 1];
        for (int i = 0; i <= nums.length; ++i) {
            money[i] = new Pair();
        }
        
        money[0].a = money[0].b = 0;
        for (int i = 1; i <= nums.length; ++i) {
            money[i].a = Math.max(money[i - 1].a, money[i - 1].b);
            money[i].b = money[i - 1].a + nums[i - 1];
        }
        return Math.max(money[nums.length].a, money[nums.length].b);
    }
}