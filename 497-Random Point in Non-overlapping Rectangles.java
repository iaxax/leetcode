class Solution {
    
    private int[][] rectangles;
    
    private int[] map = new int[100];
    
    private Random rand = new Random();

    public Solution(int[][] rects) {
        rectangles = new int[rects.length][4];
        int areas = 0;
        for (int[] rec : rects) {
            areas += area(rec);
        }
        
        int id = 0, i = 0;
        for (int[] rec : rects) {
            int ratio = (int)(area(rec) * 100.0 / areas);
            int k = Math.min(100, i + ratio);
            for (int j = i; j < k; ++j) {
                map[j] = id;
            }
            i = k;
            rectangles[id++] = rec;
        }
    }
    
    public int[] pick() {
        int rectId = map[rand.nextInt(100)];
        int[] rect = rectangles[rectId];
        int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
        int x = rand.nextInt(x2 - x1 + 1) + x1;
        int y = rand.nextInt(y2 - y1 + 1) + y1;
        return new int[] {x, y};
    }
    
    private int area(int[] rec) {
        int x1 = rec[0], y1 = rec[1], x2 = rec[2], y2 = rec[3];
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */