class Solution {
    public int calPoints(String[] ops) {
        int i = -1, sum = 0;
        int[] points = new int[ops.length];
        for (String s : ops) {
            if (s.equals("+")) {
                int n = points[i] + points[i - 1];
                points[++i] = n;
                sum += n;
            } else if (s.equals("D")) {
                int n = points[i] * 2;
                points[++i] = n;
                sum += n;
            } else if (s.equals("C")) {
                sum -= points[i--];
            } else {
                int n = Integer.parseInt(s);
                points[++i] = n;
                sum += n;
            }
        }
        return sum;
    }
}