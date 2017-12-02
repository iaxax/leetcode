public class Solution {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        for (int l = (int)Math.ceil(Math.sqrt(area)); l <= area; ++l) {
            if (area % l == 0) {
                result[0] = l;
                result[1] = area / l;
                return result;
            }
        }
        return result;
    }
}
