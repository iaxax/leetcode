class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] prices = new int[n];
        Arrays.fill(prices, -1);
        prices[src] = 0;
        
        for (int i = 0; i <= K; ++i) {
            int[] temp = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                int s = flight[0], d = flight[1], p = flight[2];
                if (prices[s] == -1) continue;
                if (temp[d] == -1 || temp[d] > prices[s] + p) {
                    temp[d] = prices[s] + p;
                }
            }
            prices = temp;
        }
        
        return prices[dst];
    }
}