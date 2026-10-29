class Solution {
    private int n, LOG;
    private List<Integer>[] graph;
    private int[] tin, tout, depth, parent, order;
    private int[][] up;
    private char[] chars;
    private Fenwick bit;
    private int timer;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        this.n = n;
        chars = s.toCharArray();

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        parent = new int[n];
        order = new int[n];
        up = new int[n][LOG];

        buildEulerTour();
        buildLCA();

        bit = new Fenwick(n);

        for (int u = 0; u < n; u++) {
            rangeXor(tin[u], tout[u],
                    1 << (chars[u] - 'a'));
        }

        List<Boolean> result = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int delta = (1 << (chars[u] - 'a'))
                          ^ (1 << (c - 'a'));

                rangeXor(tin[u], tout[u], delta);
                chars[u] = c;
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int ancestor = lca(u, v);

                int mask = bit.query(tin[u])
                         ^ bit.query(tin[v])
                         ^ (1 << (chars[ancestor] - 'a'));

                result.add((mask & (mask - 1)) == 0);
            }
        }

        return result;
    }

    private void buildEulerTour() {
        int[] stack = new int[n];
        int top = 0;
        int count = 0;

        Arrays.fill(parent, -1);
        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[--top];

            tin[u] = ++timer;
            order[count++] = u;

            for (int v : graph[u]) {
                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }

        for (int u = 0; u < n; u++) {
            tout[u] = tin[u];
        }

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            int p = parent[u];
            tout[p] = Math.max(tout[p], tout[u]);
        }
    }

    private void buildLCA() {
        for (int u = 0; u < n; u++) {
            up[u][0] = parent[u];
        }

        for (int j = 1; j < LOG; j++) {
            for (int u = 0; u < n; u++) {
                up[u][j] = up[up[u][j - 1]][j - 1];
            }
        }
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if (((diff >> j) & 1) != 0) {
                u = up[u][j];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return parent[u];
    }

    private void rangeXor(int left, int right, int mask) {
        bit.update(left, mask);
        bit.update(right + 1, mask);
    }

    private static class Fenwick {
        private final int[] tree;
        private final int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int index, int mask) {
            for (int i = index; i <= n; i += i & -i) {
                tree[i] ^= mask;
            }
        }

        int query(int index) {
            int mask = 0;

            for (int i = index; i > 0; i -= i & -i) {
                mask ^= tree[i];
            }

            return mask;
        }
    }
}
