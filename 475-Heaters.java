public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;
        int n1 = houses.length, n2 = heaters.length;
        int i = 0, j = -1;
        while (i < n1 && j < n2 - 1) {
            int minRadius = Math.abs(houses[i] - heaters[j >= 0 ? j : 0]);
            while (j + 1 < n2 && Math.abs(houses[i] - heaters[j + 1]) <= minRadius) {
                minRadius = Math.abs(houses[i] - heaters[j + 1]);
                ++j;
            }
            ++i;
            radius = Math.max(radius, minRadius);
        }
        if (i < n1) {
            radius = Math.max(radius, Math.abs(houses[n1 - 1] - heaters[n2 - 1]));
        }
        return radius;
    }
}
