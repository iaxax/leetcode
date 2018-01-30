class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] c1 = a.split("\\+", 2), c2 = b.split("\\+", 2);
        int x1 = Integer.parseInt(c1[0]), x2 = Integer.parseInt(c2[0]);
        int y1 = Integer.parseInt(c1[1].substring(0, c1[1].length() - 1));
        int y2 = Integer.parseInt(c2[1].substring(0, c2[1].length() - 1));
        return (x1 * x2 - y1 * y2) + "+" + (x1 * y2 + x2 * y1) + "i";
    }
}
