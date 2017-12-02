public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length, count = 0;
        for (int i = 0; i < n; ++i) {
            Map<Long, Integer> map = new HashMap<>();
            for (int j = 0; j < n; ++j) {
                long d = ((long)points[i][0] - points[j][0]) * ((long)points[i][0] - points[j][0]) +
                    ((long)points[i][1] - points[j][1]) * ((long)points[i][1] - points[j][1]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for (Integer value : map.values()) {
                count += value * (value - 1);
            }
        }
        return count;
    }
}
