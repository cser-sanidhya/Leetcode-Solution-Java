class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        );
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }
                return a[2] - b[2];
            }
        );
        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        for (int i = 0; i < m; i++) {
            int time = i;
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] server = busy.poll();
                available.offer(new int[]{server[1], server[2]});
            }
            if (available.isEmpty()) {
                time = busy.peek()[0];
                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    int[] server = busy.poll();
                    available.offer(new int[]{server[1], server[2]});
                }
            }
            int[] server = available.poll();
            ans[i] = server[1];
            busy.offer(new int[]{
                time + tasks[i],
                server[0],
                server[1]
            });
        }
        return ans;
    }
}
