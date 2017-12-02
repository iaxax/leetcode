class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int maxArea = 0;
        heights.push_back(0);
        stack<int> index;
        
        for (int i = 0; i < heights.size(); ++i) {
            while (!index.empty() && heights[index.top()] >= heights[i]) {
                int h = heights[index.top()];
                index.pop();
                int left = index.empty() ? -1 : index.top();
                if (maxArea < h * (i - 1 - left)) {
                    maxArea = h * (i - 1 - left);
                }
            }
            index.push(i);
        }
        return maxArea;
    }
};