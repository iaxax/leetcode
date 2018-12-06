class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        allPathsSourceTarget(result, new LinkedList<>(), graph, 0);
        return result;
    }
    
    private void allPathsSourceTarget(List<List<Integer>> result, LinkedList<Integer> path, int[][] graph, int currentNode) {
        path.addLast(currentNode);
        if (currentNode == graph.length - 1) {
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        
        for (int next : graph[currentNode]) {
            allPathsSourceTarget(result, path, graph, next);
        }
        path.removeLast();
    }
}