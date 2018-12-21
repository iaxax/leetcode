class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int openNum = 0;
        boolean[] open = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                int next = q.poll();
                if (open[next]) continue;
                open[next] = true;
                openNum += 1;
                for (int key : rooms.get(next)) {
                    q.offer(key);
                }
            }
        }
        return openNum == rooms.size();
    }
    
}