

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefixSum = 0;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            if (i > 0) {
                dp[i] = dp[i - 1];
            }

            int needed = prefixSum - target;

            if (map.containsKey(needed)) {
                int j = map.get(needed);

                int length = i - j;

                if (j >= 0 && dp[j] != Integer.MAX_VALUE) {
                    answer = Math.min(answer, dp[j] + length);
                }

                dp[i] = Math.min(dp[i], length);
            }

            map.put(prefixSum, i);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
