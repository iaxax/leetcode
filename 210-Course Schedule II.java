public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];
        List<HashSet<Integer>> graph = buildGraph(numCourses, prerequisites);
        int[] indegree = computeIndegree(graph);
        for (int i = 0; i < numCourses; ++i) {
            int j = 0;
            for (; j < numCourses; ++j) {
                if (indegree[j] == 0) break;
            }
            if (j == numCourses) return new int[0];
            courses[i] = j;
            indegree[j] = -1;
            for (Integer neighbor : graph.get(j)) {
                indegree[neighbor] -= 1;
            }
        }
        return courses;
    }
    
    private int[] computeIndegree(List<HashSet<Integer>> graph) {
        int[] indegree = new int[graph.size()];
        for (HashSet<Integer> neighbors : graph) {
            for (Integer neighbor : neighbors) {
                indegree[neighbor] += 1;
            }
        }
        return indegree;
    }
    
    private List<HashSet<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        List<HashSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new HashSet<>());
        }
        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
        }
        return graph;
    }
}
