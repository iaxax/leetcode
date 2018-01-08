/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int size = intervals.length;
        for (int i = 0; i < size; ++i) {
            if (!map.containsKey(intervals[i].start)) {
                map.put(intervals[i].start, i);
            }
        }
        
        int[] result = new int[intervals.length];
        for (int i = 0; i < size; ++i) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            result[i] = entry == null ? -1 : entry.getValue();
        }
        return result;
    }
}


