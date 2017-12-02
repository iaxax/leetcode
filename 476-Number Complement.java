public class Solution {
    public int findComplement(int num) {
        int higestOne = 1 << 31;
        while ((higestOne & num) == 0) {
            higestOne >>>= 1;
        }
        return ~num & ((higestOne << 1) - 1);
    }
}
