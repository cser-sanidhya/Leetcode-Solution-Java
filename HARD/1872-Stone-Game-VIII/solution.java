class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int suffixSum = stones[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixSum += stones[i];

            if (i == n - 2) {
                continue;
            }
        }
        int sum = 0;

        for (int x : stones) {
            sum += x;
        }
        int best = sum;

        for (int i = n - 1; i >= 2; i--) {
            sum -= stones[i];
            best = Math.max(best, sum - best);
        }
        return best;
    }
}
