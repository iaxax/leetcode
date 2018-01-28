class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int time = 0, len = timeSeries.length;
        if (len == 0) return 0;
        
        for (int i = 0; i < len - 1; ++i) {
            if (timeSeries[i] + duration > timeSeries[i + 1]) {
                time += timeSeries[i + 1] - timeSeries[i];
            } else {
                time += duration;
            }
        }
        return time + duration;
    }
}
