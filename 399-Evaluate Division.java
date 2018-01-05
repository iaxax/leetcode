class Solution {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, HashMap<String, Double>> graph = buildGraph(equations, values);
        int size = queries.length;
        double[] result = new double[size];
        for (int i = 0; i < size; ++i) {
            String dividend = queries[i][0];
            String divisor = queries[i][1];
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                result[i] = -1.0;
            } else if (dividend.equals(divisor)){
                result[i] = 1.0;
            } else {
                result[i] = search(graph, new HashSet<>(), dividend, divisor);
            }
        }
        return result;
    }

    private Map<String, HashMap<String, Double>> buildGraph(String[][] equations, double[] values) {
        Map<String, HashMap<String, Double>> graph = new HashMap<>();
        int size = values.length;
        for (int i = 0; i < size; ++i) {
            String dividend = equations[i][0];
            String divisor = equations[i][1];
            double value = values[i];

            if (graph.containsKey(dividend)) {
                HashMap<String, Double> map = graph.get(dividend);
                map.put(divisor, value);
            } else {
                HashMap<String, Double> map = new HashMap<>();
                graph.put(dividend, map);
                map.put(divisor, value);
            }

            if (graph.containsKey(divisor)) {
                HashMap<String, Double> map = graph.get(divisor);
                map.put(dividend, 1.0 / value);
            } else {
                HashMap<String, Double> map = new HashMap<>();
                graph.put(divisor, map);
                map.put(dividend, 1.0 / value);
            }
        }
        return graph;
    }

    private double search(Map<String, HashMap<String, Double>> graph,
                          Set<String> visited, String dividend, String divisor) {
        HashMap<String, Double> map = graph.get(dividend);
        if (map.containsKey(divisor)) {
            return map.get(divisor);
        }

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String key = entry.getKey();
            if (visited.contains(key)) {
                continue;
            }

            visited.add(key);
            double value = search(graph, visited, entry.getKey(), divisor);
            if (value != -1.0) {
                map.put(divisor, entry.getValue() * value);
                return entry.getValue() * value;
            }
            visited.remove(key);
        }
        return -1.0;
    }
    
}
