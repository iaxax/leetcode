/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {
    
    TreeMap<Integer, Integer> ranges;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        ranges = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if (ranges.containsKey(val)) return;
        
        int start = val, end = val;
        Map.Entry<Integer, Integer> prev = ranges.floorEntry(val);
        Map.Entry<Integer, Integer> next = ranges.ceilingEntry(val);
        if (prev != null && prev.getValue() >= start - 1) {
            start = prev.getKey();
            end = Math.max(prev.getValue(), val);
            ranges.remove(prev.getKey());
        }
        if (next != null && next.getKey() <= end + 1) {
            end = Math.max(next.getValue(), val);
            ranges.remove(next.getKey());
        }
        
        ranges.put(start, end);
    }
    
    public List<Interval> getIntervals() {
        List<Interval> result = new ArrayList<>(ranges.size());
        for (Map.Entry<Integer, Integer> range : ranges.entrySet()) {
            result.add(new Interval(range.getKey(), range.getValue()));
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */