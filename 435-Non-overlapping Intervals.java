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
    public int eraseOverlapIntervals(Interval[] intervals) {
        int size = intervals.length;
        Arrays.sort(intervals, (a, b) -> a.start - b.start != 0 ? a.start - b.start : a.end - b.end);
        
        int count = 0;
        for (int i = 0; i < size; ++i) {
            while (i + 1 < size && intervals[i].start == intervals[i + 1].start) {
                count += 1;
                swap(intervals, i, i + 1);
                i = i + 1;
            }
            if (i + 1 < size && intervals[i].end > intervals[i + 1].start) {
                count += 1;
                if (intervals[i].end < intervals[i + 1].end) {
                    swap(intervals, i, i + 1);
                }
            }
        }
        return count;
    }
    
    private void swap(Interval[] arr, int i, int j) {
        Interval temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int size = intervals.length;
        if(size <= 1) return 0;
        Arrays.sort(intervals, (a, b) -> a.end - b.end);
        
        int count = 1;
        int end = intervals[0].end;
        for (int i = 1; i < size; ++i) {
            if (intervals[i].start >= end) {
                count += 1;
                end = intervals[i].end;
            }
        }
        return size - count;
    }
}
