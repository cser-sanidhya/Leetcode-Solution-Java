# 3619. Count Islands With Total Value Divisible by K

## Approach

The goal is to count the number of connected islands whose total cell value is divisible by `k`. An island consists of connected cells with positive values, using four-directional connectivity: up, down, left, and right.

We use iterative Depth-First Search (DFS) with a stack to explore each island and calculate its total value.

1. Traverse every cell in the grid.
2. Skip cells containing `0`, as they are either water or already visited.
3. When a positive cell is found:
   - Initialize `sum` with the starting cell's value.
   - Mark the cell as visited by changing its value to `0`.
   - Push its coordinates onto the stack.
4. While the stack is not empty:
   - Pop a cell and check its four neighboring cells.
   - If a neighbor is within bounds and has a positive value, add its value to `sum`, mark it visited, and push it onto the stack.
5. After exploring the entire island, check whether `sum % k == 0`.
6. If the condition holds, increment `count`.
7. Return the total count.

## Algorithm

1. Initialize `m`, `n`, and `count = 0`.
2. Define the direction array:

   ```java
   int[] dirs = {-1, 0, 1, 0, -1};
   ```

3. Traverse the grid using nested loops.
4. If `grid[i][j] == 0`, skip the cell.
5. Otherwise:
   - Set `sum = grid[i][j]`.
   - Mark the starting cell as visited by setting it to `0`.
   - Push its coordinates onto the stack.
6. Perform iterative DFS:
   - Pop a cell from the stack.
   - Examine all four neighboring cells.
   - For each valid, positive neighbor, add its value to `sum`, mark it as visited, and push it onto the stack.
7. If `sum % k == 0`, increment `count`.
8. Return `count`.

## Time Complexity

- Each cell is visited at most once.
- Each cell checks at most four neighbors.

Overall Time Complexity: **O(m × n)**

## Space Complexity

- The stack can store up to O(m × n) cells in the worst case..

Overall Space Complexity: **O(m × n)**

## Concepts

- Depth-First Search (DFS)
- Iterative Graph Traversal
- Stack
- Connected Components
- Grid Traversal
- Modular Arithmetic
- In-Place Visited Marking
