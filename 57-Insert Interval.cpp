/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
        sort(intervals.begin(), intervals.end(), [](const Interval &i1, const Interval &i2) {
            return i1.start < i2.start || i1.start == i2.start && i1.end < i2.end;
        });
        
        vector<Interval> result;
        int i = 0, sz = intervals.size();
        while (i < sz && intervals[i].end < newInterval.start) {
            result.push_back(intervals[i++]);
        }
        
        int start = newInterval.start;
        int end = newInterval.end;
        while (i < sz && intervals[i].start <= end) {
            start = min(start, intervals[i].start);
            end = max(end, intervals[i].end);
            ++i;
        }
        result.push_back(Interval(start, end));
        
        while (i < sz) {
            result.push_back(intervals[i++]);
        }
        
        return result;
    }
};