class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return PredictTheWinner(nums, new int[2], 0, nums.length - 1, 0);
    }

    private boolean PredictTheWinner(int[] nums, int[] scores, int start, int end, int turn) {
        if (start > end) return turn == 0 && scores[0] >= scores[1] || turn == 1 && scores[0] < scores[1];

        scores[turn] += nums[start];
        if (!PredictTheWinner(nums, scores, start + 1, end, 1 - turn)) {
            scores[turn] -= nums[start];
            return true;
        }

        scores[turn] -= nums[start];
        scores[turn] += nums[end];
        if (!PredictTheWinner(nums, scores, start, end - 1, 1 - turn)) {
            scores[turn] -= nums[end];
            return true;
        }

        scores[turn] -= nums[end];
        return false;
    }
}
