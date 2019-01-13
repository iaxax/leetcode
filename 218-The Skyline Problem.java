class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[] {b[0], -b[2]});
            heights.add(new int[] {b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> {
            return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });
        
        List<int[]> result = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int prev = 0;
        q.offer(0);
        for (int[] h : heights) {
            if (h[1] < 0) {
                q.offer(-h[1]);
            } else {
                q.remove(h[1]);
            }
            
            int current = q.peek();
            if (prev != current) {
                result.add(new int[] {h[0], current});
                prev = current;
            }
        }
        return result;
    }
}