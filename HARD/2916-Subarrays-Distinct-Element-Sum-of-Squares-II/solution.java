class Solution {
    private static final int MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(n);
        int[] lastSeen = new int[100001];

        java.util.Arrays.fill(lastSeen, -1);
        long answer = 0;

        for (int r = 0; r < n; r++) {
            int prev = lastSeen[nums[r]];
            tree.update(prev + 1, r);
            answer = (answer + tree.squareSum[1]) % MOD;
            lastSeen[nums[r]] = r;
        }

        return (int) answer;
    }

    static class SegmentTree {
        int n;
        long[] sum;
        long[] squareSum;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            squareSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        void update(int left, int right) {
            update(1, 0, n - 1, left, right);
        }

        void update(int node, int start, int end,
                    int left, int right) {
            if (start > right || end < left) {
                return;
            }

            if (left <= start && end <= right) {
                apply(node, start, end);
                return;
            }

            push(node, start, end);
            int mid = start + (end - start) / 2;
            update(node * 2, start, mid, left, right);
            update(node * 2 + 1, mid + 1, end, left, right);
            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            squareSum[node] =
                (squareSum[node * 2] + squareSum[node * 2 + 1]) % MOD;
        }

        void apply(int node, int start, int end) {
            long length = end - start + 1L;
            squareSum[node] =
            (squareSum[node] + 2L * sum[node] + length) % MOD;
            sum[node] = (sum[node] + length) % MOD;
            lazy[node]++;
        }

        void push(int node, int start, int end) {
            if (lazy[node] == 0 || start == end) {
                return;
            }

            int mid = start + (end - start) / 2;

            applyMultiple(node * 2, start, mid, lazy[node]);
            applyMultiple(node * 2 + 1, mid + 1, end, lazy[node]);

            lazy[node] = 0;
        }

        void applyMultiple(int node, int start, int end, long value) {
            long length = end - start + 1L;

            squareSum[node] =
                (squareSum[node] + 2L * value * sum[node]
                + value * value % MOD * length) % MOD;
            sum[node] = (sum[node] + value * length) % MOD;
            lazy[node] += value;
        }
    }
}
