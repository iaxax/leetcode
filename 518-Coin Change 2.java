class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int n = coins.length;
        for (int i = 0; i < n; ++i) {
            map.put(i, new HashMap<>());
        }
        
        return change(amount, coins, 0, map);
    }
    
    private int change(int amount, int[] coins, int index, HashMap<Integer, HashMap<Integer, Integer>> map) {
        if (amount == 0) {
            return 1;
        }
        if (index == coins.length) {
            return 0;
        }
        
        Integer count = map.get(index).get(amount);
        if (count != null) {
            return count;
        }
        
        int temp = amount;
        int sum = change(temp, coins, index + 1, map);
        while (temp > 0) {
            sum += change(temp - coins[index], coins, index + 1, map);
            temp -= coins[index];
        }
        
        map.get(index).put(amount, sum);
        return sum;
    }
}

// a smarter and faster solution
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for (int c : coins) {
            for (int i = c; i <= amount; ++i) {
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }
}