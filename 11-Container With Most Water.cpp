class Solution {
public:
    int maxArea(vector<int>& height) {
        int area = 0, a, k;
        int i = 0, j = height.size() - 1;
        while (i < j) {
            a = std::min(height[i], height[j]) * (j - i);
            area = a > area ? a : area;
            if (height[i] < height[j]) {
                k = i + 1;
                while (k < j && height[i] >= height[k]) ++k;
                i = k;
            }
            else {
                k = j - 1;
                while (k > i && height[j] >= height[k]) --k;
                j = k;
            }
        }
        return area;
    }
};