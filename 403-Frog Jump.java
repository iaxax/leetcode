class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        List<Set<Integer>> dp = new ArrayList<>(n);
        for (int i = 0; i < 1100; ++i) {
            dp.add(new HashSet<>());
        }
        
        if (stones.length == 2) {
            return stones[1] == 1;
        }
        
        dp.get(1).add(1);
        for (int i = 2; i < n; ++i) {
            Set<Integer> set = dp.get(i);
            for (int j = i - 1; j > 0; --j) {
                Set<Integer> steps = dp.get(j);
                if (steps.contains(stones[i] - stones[j]) ||
                   steps.contains(stones[i] - stones[j] + 1) ||
                   steps.contains(stones[i] - stones[j] - 1)) {
                    set.add(stones[i] - stones[j]);
                }
            }
        }
        return !dp.get(n - 1).isEmpty();
    }
}

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        int end = stones[n - 1];
        if (end > 605550) return false;
        
        Set<Integer>[] dp = new Set[end + 1];
        for (int i = end; i >= 0; --i) {
            dp[i] = new HashSet<>();
        }
        
        dp[1].add(1);
        for (int i = 1; i < n; ++i) {
            int stone = stones[i];
            for (int step : dp[stone]) {
                if (step > 0 && stone + step <= end) {
                    dp[stone + step].add(step);
                }
                if (step > 1 && stone + step - 1 <= end) {
                    dp[stone + step - 1].add(step - 1);
                }
                if (step + 1 > 0 && stone + step + 1 <= end) {
                    dp[stone + step + 1].add(step + 1);
                }
            }
        }
        
        return !dp[end].isEmpty();
    }
}
