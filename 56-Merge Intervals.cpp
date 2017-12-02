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
	vector<Interval> merge(vector<Interval>& intervals) {
		sort(intervals.begin(), intervals.end(), [](const Interval &i1, const Interval &i2) {
			return i1.start < i2.start || i1.start == i2.start && i1.end < i2.end;
		});
		vector<Interval> result;
		for (unsigned int i = 0; i < intervals.size(); ++i) {
			int begin = intervals[i].start;
			int end = intervals[i].end;
			while (i + 1 < intervals.size() && intervals[i + 1].start <= end) {
				begin = min(begin, intervals[i + 1].start);
				end = max(end, intervals[++i].end);
			}
			result.push_back(Interval(begin, end));
		}
		return result;
	}
};