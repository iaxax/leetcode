class Solution {
public:
	int jump(vector<int>& nums) {
		int level = 0, lvLeft = 0, lvRight = 0;
		int sz = nums.size();
		while (lvRight < sz - 1) {
			++level;
			int left = lvLeft, right = lvRight;
			lvLeft = lvRight + 1;
			for (int i = left; i <= right; ++i) {
				if (i + nums[i] > lvRight) lvRight = i + nums[i];
			}
		}
		return level;
	}
};