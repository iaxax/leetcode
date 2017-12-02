class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        
        List<Set<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            graph.add(new HashSet<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (graph.get(i).size() == 1) leaves.add(i);
        }
        
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int l : leaves) {
                int i = graph.get(l).iterator().next();
                graph.get(i).remove(l);
                if (graph.get(i).size() == 1) {
                    newLeaves.add(i);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
