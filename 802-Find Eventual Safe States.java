class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashSet<Integer> nodes = new HashSet<>();
        HashSet<Integer> remain = new HashSet<>();
        for (int i = 0; i < graph.length; ++i) {
            if (graph[i].length == 0) {
                nodes.add(i);
            } else {
                remain.add(i);
            }
        }
        
        int size = 0;
        while (nodes.size() != size) {
            size = nodes.size();
            HashSet<Integer> newRemain = new HashSet<>();
            for (int node : remain) {
                boolean safe = true;
                for (int next : graph[node]) {
                    if (!nodes.contains(next)) {
                        safe = false;
                        break;
                    }
                }
                
                if (safe) {
                    nodes.add(node);
                } else {
                    newRemain.add(node);
                }
            }
            remain = newRemain;
        }
        
        List<Integer> result = new ArrayList<>(nodes.size());
        result.addAll(nodes);
        Collections.sort(result);
        return result;
    }
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] safeNodes = new boolean[graph.length];
        boolean end = true;
        for (int i = 0; i < graph.length; ++i) {
            if (graph[i].length == 0) {
                safeNodes[i] = true;
                end = false;
            }
        }
        
        while (!end) {
            end = true;
            for (int i = 0; i < graph.length; ++i) {
                if (!safeNodes[i]) {
                    boolean safe = true;
                    for (int next : graph[i]) {
                        if (!safeNodes[next]) {
                            safe = false;
                            break;
                        }
                    }
                    if (safe) {
                        safeNodes[i] = true;
                        end = false;
                    }
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; ++i) {
            if (safeNodes[i]) {
                result.add(i);
            }
        }
        return result;
    }
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        // 0 means unvisited, 1 means no cycle, 2 means having cycle, 3 means visited
        int[] state = new int[graph.length];
        for (int i = 0; i < graph.length; ++i) {
            if (!hasCycle(graph, i, state)) {
                result.add(i);
            }
        }
        return result;
    }
    
    private boolean hasCycle(int[][] graph, int node, int[] state) {
        if (state[node] > 1) {
            return true;
        }
        if (state[node] == 1) {
            return false;
        }
        
        state[node] = 3;
        for (int next : graph[node]) {
            if (hasCycle(graph, next, state)) {
                state[node] = 2;
                return true;
            }
        }
        state[node] = 1;
        return false;
    }
}