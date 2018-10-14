class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; ++i) {
            if (colors[i] != 0) continue;
            
            colors[i] = 1;
            q.offer(i);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int j = 0; j < size; ++j) {
                    int node = q.poll();
                    for (int next : graph[node]) {
                        if (colors[next] == 0) {
                            colors[next] = -colors[node];
                            q.offer(next);
                        } else if (colors[next] == colors[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}