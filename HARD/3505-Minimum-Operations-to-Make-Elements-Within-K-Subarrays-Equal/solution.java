class Solution {

    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();

    int lowSize = 0, highSize = 0;
    long lowSum = 0, highSum = 0;

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;
        long[] cost = new long[n - x + 1];

        for (int i = 0; i < n; i++) {

            add(nums[i]);

            if (i >= x) {
                remove(nums[i - x]);
            }

            if (i >= x - 1) {
                int median = low.lastKey();

                cost[i - x + 1] =
                    (long) median * lowSize - lowSum
                    + highSum - (long) median * highSize;
            }
        }

        long INF = Long.MAX_VALUE / 2;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int j = 1; j <= k; j++) {

            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                curr[i] = curr[i - 1];

                if (i >= x && prev[i - x] != INF) {

                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }

    private void add(int num) {

        if (low.isEmpty() || num <= low.lastKey()) {
            low.merge(num, 1, Integer::sum);
            lowSize++;
            lowSum += num;
        } else {
            high.merge(num, 1, Integer::sum);
            highSize++;
            highSum += num;
        }

        balance();
    }

    private void remove(int num) {

        if (low.containsKey(num)) {
            erase(low, num);
            lowSize--;
            lowSum -= num;
        } else {
            erase(high, num);
            highSize--;
            highSum -= num;
        }

        balance();
    }

    private void erase(TreeMap<Integer, Integer> map, int num) {

        int count = map.get(num);

        if (count == 1) {
            map.remove(num);
        } else {
            map.put(num, count - 1);
        }
    }

    private void balance() {

        int target = (lowSize + highSize + 1) / 2;

        while (lowSize > target) {

            int val = low.lastKey();

            erase(low, val);
            lowSize--;
            lowSum -= val;

            high.merge(val, 1, Integer::sum);
            highSize++;
            highSum += val;
        }

        while (lowSize < target) {

            int val = high.firstKey();

            erase(high, val);
            highSize--;
            highSum -= val;

            low.merge(val, 1, Integer::sum);
            lowSize++;
            lowSum += val;
        }
    }
}
