/**
 * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * };
 */
class Solution {
public:
    int maxPoints(vector<Point>& points) {
        if (points.size() < 2) {
            return points.size();
        }
        
        int maxNum = 0;
        for (int i = 0; i < points.size(); ++i) {
            int samePoint = 1;
            int localMax = 0;
            unordered_map<int, unordered_map<int, int>> mp;
            
            for (int j = i + 1; j < points.size(); ++j) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoint += 1;
                    continue;
                }
                
                int diffY = points[i].y - points[j].y;
                int diffX = points[i].x - points[j].x;
                int g = gcd(diffX, diffY);
                if (g != 0) {
                    diffY /= g;
                    diffX /= g;
                }
                
                mp[diffX][diffY] += 1;
                localMax = max(localMax, mp[diffX][diffY]);
            }
            
            maxNum = max(maxNum, localMax + samePoint);
        }
        
        return maxNum;
    }
    
private:
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
};