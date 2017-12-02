// O(nk) Solution
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        long minDiff = Integer.MAX_VALUE;
        int len = Math.min(k + 1, n);
        int[] firstK = Arrays.copyOfRange(nums, 0, len);
        Arrays.sort(firstK);
        for (int i = 0; i < len; ++i) {
            if (i + 1 < len) {
                if (firstK[i + 1] - firstK[i] < minDiff) {
                    minDiff = (long)firstK[i + 1] - firstK[i];
                }
            }
        }
        
        for (int i = len; i < n; ++i) {
            if (minDiff <= t) return true;
            for (int j = i - len + 1; j < i; ++j) {
                long diff = Math.abs((long)nums[j] - nums[i]);
                if (diff < minDiff) minDiff = diff;
            }
        }
        
        return minDiff <= t;
    }
}

// O(nlogk) Solution
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        
        TreeSet<Long> set = new TreeSet<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            Long ceil = set.ceiling((long)nums[i] - t);
            Long floor = set.floor((long)nums[i] + t);
            if ((ceil != null && ceil <= nums[i]) || (floor != null && floor >= nums[i])) {
                return true;
            }
            set.add((long)nums[i]);
            if (set.size() > k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}

// O(n) Solution
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            long remappedNum = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long)t + 1);
            if (map.containsKey(bucket) ||
               (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t) ||
               (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)) {
                return true;
            }
            if (map.size() >= k) {
                map.remove(((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1));
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}
