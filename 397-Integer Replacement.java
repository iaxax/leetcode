class Solution {
    public int integerReplacement(int n) {
        Map<Long, Integer> history = new HashMap<>();
        history.put(1L, 0);
        return integerReplacement(n, history);
    }

    private int integerReplacement(long n, Map<Long, Integer> history) {
        if (history.containsKey(n)) {
            return history.get(n);
        }

        int count;
        if (n % 2 == 0) {
            count = integerReplacement(n / 2, history) + 1;
        } else {
            count = Math.min(
                integerReplacement(n + 1, history),
                integerReplacement(n - 1, history)
            ) + 1;
        }

        history.put(n, count);
        return count;
    }

}
