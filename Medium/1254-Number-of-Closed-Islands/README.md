# 1254. Number of Closed Islands

## Approach

The goal is to count the number of closed islands in a binary grid. A closed island consists of connected `0`s (land) that are completely surrounded by `1`s (water) and do not touch the grid boundary.

We use Depth-First Search (DFS) to eliminate all land connected to the boundary before counting the remaining islands.

1. Traverse the first and last columns and apply DFS to eliminate boundary-connected land.
2. Traverse the first and last rows and apply DFS to eliminate boundary-connected land.
3. Iterate through the inner cells of the grid.
4. Whenever an unvisited land cell (`0`) is found, increment the count and use DFS to mark its entire island as visited.
5. Return the total number of closed islands.

## Algorithm

1. Initialize `m`, `n`, and `count = 0`.
2. For every row `i`, call `dfs(grid, i, 0)` and `dfs(grid, i, n - 1)`.
3. For every column `j`, call `dfs(grid, 0, j)` and `dfs(grid, m - 1, j)`.
4. Traverse the inner grid from row `1` to `m - 2` and column `1` to `n - 2`.
5. If `grid[i][j] == 0`:
   - Increment `count`.
   - Call `dfs(grid, i, j)` to mark the entire island.
6. In `dfs()`:
   - Stop if the cell is out of bounds or contains `1`.
   - Change the current cell from `0` to `1`.
   - Recursively visit the four adjacent cells: up, down, left, and right.
7. Return `count`.

## Time Complexity

- Each grid cell is visited and processed at most a constant number of times.

Overall Time Complexity: **O(m × n)**

## Space Complexity

- The recursive DFS call stack can contain up to O(m × n) calls in the worst case.

Overall Space Complexity: **O(m × n)**

## Concepts

- Depth-First Search (DFS)
- Grid Traversal
- Connected Components
- Boundary Flood Fill
- Recursion
- In-Place Visited Marking
