class Solution {
public:
    int mySqrt(int x) {
        if (x == 0) return 0;
        double root = x;
        while (true) {
            root = root / 2 + x / (2 * root);
            if (root * root - x < 1) {
                break;
            }
        }
        return int(root);
    }
};