class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int[] dirs = {-1, 0, 1, 0, -1};
        java.util.ArrayDeque<int[]> stack = new java.util.ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                long sum = 0;
                grid[i][j] = 0;
                stack.push(new int[]{i, j});

                while (!stack.isEmpty()) {
                    int[] cell = stack.pop();
                    int r = cell[0];
                    int c = cell[1];
                    sum += gridValue(r, c, grid);

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dirs[d];
                        int nc = c + dirs[d + 1];

                        if (nr >= 0 && nr < m &&
                            nc >= 0 && nc < n &&
                            grid[nr][nc] > 0) {
                            sum += grid[nr][nc];
                            grid[nr][nc] = 0;
                            stack.push(new int[]{nr, nc});
                        }
                    }
                }

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private long gridValue(int r, int c, int[][] grid) {
        return 0;
    }
}
