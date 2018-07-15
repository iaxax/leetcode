// naive solution
import java.util.*;

class Solution {
    public int minPatches(int[] nums, int n) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        for (int num : nums) map.put((long)num, map.getOrDefault((long)num, 0) + 1);
        
        int patch = 0;
        long coverRange = 0, last = 0;
        while (coverRange < n && map.ceilingKey(coverRange) != null) {
            SortedMap<Long, Integer> temp = null;
            while (!(temp = map.subMap(last + 1, coverRange + 1)).isEmpty()) {
                for (SortedMap.Entry<Long, Integer> entry : temp.entrySet()) {
                    coverRange += entry.getKey() * entry.getValue();
                }
                last = temp.lastKey();
            }
            
            if (coverRange >= n) break;
            if (!map.containsKey(coverRange + 1)) {
                ++patch;
                last = coverRange + 1;
                coverRange = coverRange * 2 + 1;
            } else {
                last = coverRange + 1;
                coverRange += (coverRange + 1) * map.get(coverRange + 1);
            }
        }
        
        while (coverRange < n) {
            coverRange = coverRange * 2 + 1;
            ++patch;
        }
        return patch;
    }
}

// smart solution
class Solution {
    public int minPatches(int[] nums, int n) {
        int patch = 0, i = 0, l = nums.length;
        long coverRange = 0;
        while (coverRange < n) {
            if (i >= l || nums[i] > coverRange + 1) {
                coverRange += coverRange + 1;
                ++patch;
            } else {
                coverRange += nums[i++];
            }
        }
        return patch;
    }
}