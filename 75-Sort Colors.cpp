class Solution {
public:
	void sortColors(vector<int>& nums) {
		int redBound = -1;
		int sz = nums.size();
		for (int i = 0; i < sz; ++i) {
			if (nums[i] == 0) {
				swap(nums[i], nums[++redBound]);
			}
		}

		int whiteBound = redBound ;
		for (int i = whiteBound; i < sz; ++i) {
			if (nums[i] == 1) {
				swap(nums[i], nums[++whiteBound]);
			}
		}
	}
};