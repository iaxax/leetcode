// DFS Solution
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<HashSet<Integer>> graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i] && hasCycle(graph, visited, new boolean[numCourses], i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(List<HashSet<Integer>> graph, boolean[] visited, boolean[] onpath, int courseId) {
        if (onpath[courseId]) {
            return true;
        }
        
        visited[courseId] = onpath[courseId] = true;
        for (Integer id : graph.get(courseId)) {
            if (hasCycle(graph, visited, onpath, id)) {
                return true;
            }
        }
        onpath[courseId] = false;
        
        return false;
    }
    
    private List<HashSet<Integer>> buildGraph(int numCourses, int[][] prereq) {
        List<HashSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new HashSet<>());
        }
        
        for (int i = 0; i < prereq.length; ++i) {
            graph.get(prereq[i][0]).add(prereq[i][1]);
        }
        return graph;
    }
}

// BFS Solution (topological sort)
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<HashSet<Integer>> graph = buildGraph(numCourses, prerequisites);
        int[] indegree = computeIndegree(graph);
        for (int i = 0; i < numCourses; ++i) {
            int j = 0;
            for (; j < numCourses; ++j) {
                if (indegree[j] == 0) break;
            }
            if (j == numCourses) return false;
            indegree[j] = -1;
            for (Integer id : graph.get(j)) {
                indegree[id] -= 1;
            }
        }
        return true;
    }
    
    private List<HashSet<Integer>> buildGraph(int numCourses, int[][] prereq) {
        List<HashSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new HashSet<>());
        }
        
        for (int i = 0; i < prereq.length; ++i) {
            graph.get(prereq[i][1]).add(prereq[i][0]);
        }
        return graph;
    }
    
    private int[] computeIndegree(List<HashSet<Integer>> graph) {
        int[] indegree = new int[graph.size()];
        for (int i = 0; i < graph.size(); ++i) {
            for (Integer id : graph.get(i)) {
                indegree[id] += 1;
            }
        }
        return indegree;
    }
}
