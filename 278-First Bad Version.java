/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }
    
    private int firstBadVersion(long begin, long end) {
        while (begin <= end) {
            int mid = (int)((begin + end) / 2);
            if (isBadVersion(mid)) {
                end = mid - 1;
            }
            else {
                begin = mid + 1;
            }
        }
        return (int)begin;
    }
}
