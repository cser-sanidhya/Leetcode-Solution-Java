# 3619. Count Islands With Total Value Divisible by K

## Approach

The goal is to count connected islands in a grid whose total cell value is divisible by `k`. An island consists of connected positive-valued cells, with connections allowed in the four directions: up, down, left, and right.

We use iterative Depth-First Search (DFS) with a stack to explore each island and calculate its total value.

1. Traverse every cell in the grid.
2. Skip cells containing `0`, as they do not belong to an island.
3. When a positive cell is found:
   - Initialize the island sum to `0`.
   - Mark the cell as visited by changing its value to `0`.
   - Push its coordinates onto the stack.
4. While the stack is not empty:
   - Pop a cell and add its value to the island sum.
   - Check its four adjacent cells.
   - If an adjacent cell is within bounds and positive, add its value to the sum, mark it visited, and push it onto the stack.
5. If the island's total sum is divisible by `k`, increment the count.
6. Return the total count of qualifying islands.

## Algorithm

1. Initialize `m`, `n`, and `count = 0`.
2. Define the direction array:

   ```java
   int[] dirs = {-1, 0, 1, 0, -1};
   ```

   This represents the four adjacent directions.
3. Traverse the grid using nested loops.
4. If `grid[i][j] == 0`, continue to the next cell.
5. Otherwise, initialize the sum and stack, mark the starting cell visited, and push its coordinates.
6. Perform iterative DFS:
   - Pop a cell from the stack.
   - Add its value to the island sum.
   - Visit each valid, positive, unvisited neighbor.
7. After exploring the entire island, check `sum % k == 0`.
8. Increment `count` if the condition holds.
9. Return `count`.

## Time Complexity

- Each cell is visited at most once.
- Each cell checks at most four neighbors.

Overall Time Complexity: **O(m × n)**

## Space Complexity

- The stack can contain up to O(m × n) cells in the worst case.

Overall Space Complexity: **O(m × n)**

## Concepts

- Depth-First Search (DFS)
- Iterative Graph Traversal
- Stack
- Connected Components
- Grid Traversal
- Modular Arithmetic
- In-Place Visited Marking
