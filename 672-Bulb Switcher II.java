class Solution {
    public int flipLights(int n, int m) {
        if (m == 0 || n == 0) {
            return 1;
        }
        
        if (n >= 3) {
            if (m == 1) {
                return 4;
            } else if (m == 2){
                return 7;
            } else {
                return 8;
            }
        } else if (n == 2) {
            if (m == 1) {
                return 3;
            } else {
                return 4;
            }
        } else {
            return 2;
        }
    }
}
    