class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        vector<int> merge;
        int sz1 = nums1.size(), sz2 = nums2.size();
        int i = 0, j = 0;
        while (i < sz1 && j < sz2) {
            if (nums1[i] < nums2[j]) {
                merge.push_back(nums1[i++]);
            }
            else if (nums1[i] > nums2[j]) {
                merge.push_back(nums2[j++]);
            }
            else {
                merge.push_back(nums1[i++]);
                merge.push_back(nums2[j++]);
            }
        }
        
        while (i < sz1) merge.push_back(nums1[i++]);
        while (j < sz2) merge.push_back(nums2[j++]);
        
        int sz = merge.size();
        int mid = (sz - 1) / 2;
        return sz % 2 == 0 ? (merge[mid] + merge[mid + 1]) / 2.0 : merge[mid];
    }
};