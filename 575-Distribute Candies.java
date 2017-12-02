class Solution {
    public int distributeCandies(int[] candies) {
        int catagory = 0;
        boolean[] set = new boolean[200001];
        for (int c : candies) {
            if (!set[c + 100000]) {
                set[c + 100000] = true;
                ++catagory;
            }
        }
        int half = candies.length / 2;
        return catagory >= half ? half : catagory;
    }
}
