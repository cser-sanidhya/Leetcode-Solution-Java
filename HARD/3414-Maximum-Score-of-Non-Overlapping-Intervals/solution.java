class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int lo = 0, hi = i - 1;
            int ans = -1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                if (arr[mid][1] < arr[i][0]) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            prev[i] = ans;
        }

        long[][] dp = new long[5][n + 1];

        boolean[][] take = new boolean[5][n + 1];

        for (int k = 1; k <= 4; k++) {
            for (int i = 1; i <= n; i++) {
                dp[k][i] = dp[k][i - 1];

                int idx = i - 1;

                long candidate =
                        arr[idx][2] +
                        dp[k - 1][prev[idx] + 1];

                if (candidate > dp[k][i]) {
                    dp[k][i] = candidate;
                    take[k][i] = true;
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        int k = 4;
        int i = n;

        while (i > 0 && k > 0) {
            if (take[k][i]) {
                int idx = i - 1;

                result.add(arr[idx][3]);

                i = prev[idx] + 1;
                k--;
            } else {
                i--;
            }
        }

        Collections.sort(result);

        int[] answer = new int[result.size()];

        for (int j = 0; j < result.size(); j++) {
            answer[j] = result.get(j);
        }

        return answer;
        
    }
}
