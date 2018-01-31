class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int len1 = distance(p1, p2);
        if (len1 == 0) return false;
        
        int len2 = distance(p1, p3);
        if (len2 == 0) return false;
        
        int len3 = distance(p1, p4);
        if (len3 == 0) return false;
        
        if (len1 == len2 && len1 + len2 == len3) {
            int l1 = distance(p2, p4), l2 = distance(p3, p4);
            return l1 == len1 && l2 == len1;
        } else if (len1 == len3 && len1 + len3 == len2) {
            int l1 = distance(p2, p3), l2 = distance(p4, p3);
            return l1 == len1 && l2 == len1;
        } else if (len2 == len3 && len2 + len3 == len1) {
            int l1 = distance(p2, p3), l2 = distance(p2, p4);
            return l1 == len2 && l2 == len2;
        } else {
            return false;
        }
    }
    
    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] distance = {d(p1, p2), d(p1, p3), d(p1, p4), d(p2, p3), d(p2, p4), d(p3, p4)};
        Arrays.sort(distance);
        return distance[0] > 0 && distance[0] == distance[1] && distance[1] == distance[2] &&
                distance[2] == distance[3] && distance[4] == distance[5] &&
                distance[5] == 2 * distance[1];
    }
    
    private int d(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
