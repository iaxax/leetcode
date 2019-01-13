class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        
        HashSet<String> points = new HashSet<>();
        int area = 0;
        for (int[] rec : rectangles) {
            x1 = Math.min(x1, rec[0]);
            x2 = Math.max(x2, rec[2]);
            y1 = Math.min(y1, rec[1]);
            y2 = Math.max(y2, rec[3]);
            
            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
            
            String bl = rec[0] + " " + rec[1];
            String tl = rec[0] + " " + rec[3];
            String br = rec[2] + " " + rec[1];
            String tr = rec[2] + " " + rec[3];
            
            if (!points.add(bl)) points.remove(bl);
            if (!points.add(tl)) points.remove(tl);
            if (!points.add(br)) points.remove(br);
            if (!points.add(tr)) points.remove(tr);
        }
        
        if (!points.contains(x1 + " " + y1) ||
            !points.contains(x1 + " " + y2) ||
            !points.contains(x2 + " " + y1) ||
            !points.contains(x2 + " " + y2) ||
            points.size() != 4) return false;
        
        return area == (x2 - x1) * (y2 - y1);
    }
}