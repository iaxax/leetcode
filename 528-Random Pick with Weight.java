import java.util.SortedMap;

class Solution {
    
    private TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
    
    private Random rand = new Random();
    
    private int bound = 0;
    
    public Solution(int[] w) {
        int sum = 0;
        for (int ww : w) {
            sum += ww;
        }
        
        SortedMap<Integer, ArrayList<Integer>> sm = new TreeMap<>();
        int n = w.length;
        for (int i = 0; i < n; ++i) {
            int percent = (int)((100.0 * w[i]) / sum);
            ArrayList<Integer> list = sm.getOrDefault(percent, new ArrayList<>());
            list.add(i);
            sm.put(percent, list);
        }
        
        int p = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : sm.entrySet()) {
            int k = entry.getKey();
            ArrayList<Integer> v = entry.getValue();
            
            p += k * v.size();
            map.put(p, entry.getValue());
        }
        bound = p;
    }
    
    public int pickIndex() {
        int r = rand.nextInt(bound + 1);
        ArrayList<Integer> list = map.ceilingEntry(r).getValue();
        int n = list.size();
        return list.get(rand.nextInt(n));
    }
}

// a cleaner solution

class Solution {
    
    private int[] accumulate;
    
    private int sum = 0;
    
    private Random rand = new Random();

    public Solution(int[] w) {
        int n = w.length;
        accumulate = new int[n];
        for (int i = 0; i < n; ++i) {
            accumulate[i] = sum + w[i];
            sum = accumulate[i];
        }
    }
    
    public int pickIndex() {
        int n = rand.nextInt(sum) + 1;
        int l = 0, r = accumulate.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (accumulate[m] < n) {
                l = m + 1;
            } else if (accumulate[m] > n) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */