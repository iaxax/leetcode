class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        
        boolean[] used = new boolean[maxChoosableInteger + 1];
        return canIWin(new HashMap<>(), used, desiredTotal);
    }
    
    private boolean canIWin(HashMap<Integer, Boolean> memory, boolean[] used, int total) {
        if (total <= 0) return false;
        
        int key = format(used);
        if (memory.containsKey(key)) return memory.get(key);
        
        int len = used.length;
        for (int i = 1; i < len; ++i) {
            if (!used[i]) {
                used[i] = true;
                if (!canIWin(memory, used, total - i)) {
                    memory.put(key, true);
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
        }
        
        memory.put(key, false);
        return false;
    }
    
    private int format(boolean[] used) {
        int result = 0, len = used.length;
        for (int i = 1; i < len; ++i) {
            result += (used[i] ? 1 : 0) * (1 << i);
        }
        return result;
    }
}
