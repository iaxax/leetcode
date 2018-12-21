class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int a : answers) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        int num = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int n = entry.getKey(), m = entry.getValue();
            num += (m + n) / (n + 1) * (n + 1);
        }
        return num;
    }
}