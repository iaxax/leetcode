class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        LinkedList<Pair> stack = new LinkedList<>();
        
        for (int i = 0; i < n; ++i) {
            while(!stack.isEmpty() && stack.peek().temparature < T[i]) {
                Pair p = stack.pop();
                result[p.position] = i - p.position;
            }
            stack.push(new Pair(T[i], i));
        }
        
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            result[p.position] = 0;
        }
        return result;
    }
    
    private static class Pair {
        int temparature, position;
        Pair(int t, int p) {
            temparature = t;
            position = p;
        }
    }
}