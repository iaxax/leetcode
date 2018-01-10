class Solution {
    public int findMinArrowShots(int[][] points) {
        int size = points.length;
        if (size <= 1) return size;
        
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int count = 0, end = points[0][1], i = 0;
        while (i < size) {
            while (i + 1 < size && points[i + 1][0] <= end) {
                i = i + 1;
            }
            count += 1;
            
            if (i + 1 < size) end = points[i + 1][1];
            i = i + 1;
        }
        return count;
    }
}
