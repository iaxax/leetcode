public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        int absNum = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (absNum > 0) {
            sb.append(String.valueOf(absNum % 7));
            absNum /= 7;
        }
        sb = sb.reverse();
        return num < 0 ? "-" + sb.toString() : sb.toString();
    }
}
