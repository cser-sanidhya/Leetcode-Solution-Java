# 51. N-Queens

## Approach
1. Use **Backtracking** to place `n` queens on an `n × n` chessboard.
2. Represent the board using a `char[][]` array:
   - `'.'` represents an empty cell.
   - `'Q'` represents a queen.
3. Place exactly one queen in each row.
4. For every row, try placing a queen in every possible column.
5. Before placing a queen, check whether the position is valid:
   - No queen exists in the same column.
   - No queen exists on the upper-left diagonal.
   - No queen exists on the upper-right diagonal.
6. If the position is valid:
   - Place the queen.
   - Recursively move to the next row.
7. After returning from recursion, remove the queen to **backtrack** and try another column.
8. When `row == n`, all queens have been successfully placed, so convert the board into a list of strings and add it to the result.

The important idea is that we only place queens row by row. Therefore, we only need to check previously processed rows.

## Algorithm
1. Create an empty `n × n` board filled with `'.'`.
2. Call:
   - `backtrack(res, board, 0, n)`
3. In `backtrack()`:
   - If `row == n`:
     - Convert the board into a list of strings using `addBoard()`.
     - Add it to `res`.
     - Return.
4. Try every column in the current row:
   - Call `isValid()` to check whether a queen can be placed.
5. If the position is valid:
   - Place `'Q'` on the board.
   - Recursively call `backtrack()` for `row + 1`.
   - Remove the queen by setting the position back to `'.'`.
6. In `isValid()`:
   - Check the same column above the current position.
   - Check the upper-left diagonal.
   - Check the upper-right diagonal.
   - If a queen is found in any of these directions, return `false`.
   - Otherwise, return `true`.
7. Return all valid board configurations.

## Time Complexity
- There are up to `n` choices for each row.
- The backtracking search explores an exponential number of possible placements.
- For every attempted position, `isValid()` can take **O(n)** time because it checks the column and diagonals.

**Overall Time Complexity:**  
**O(n! × n)**

where:
- `n` = number of queens.

The `n!` represents the backtracking search space, while the additional `n` comes from checking whether a position is valid.

## Space Complexity
- Chessboard: **O(n²)**
- Recursion stack: **O(n)**
- Temporary board conversion: **O(n²)** across a generated solution.

**Auxiliary Space Complexity:**  
**O(n²)**

**Overall Space Complexity (including output):**  
**O(n² × S)**

where:
- `S` = number of valid N-Queens solutions.

## Concepts
- Backtracking
- Recursion
- Depth-First Search (DFS)
- Chessboard
- Constraint Satisfaction
- Matrix
- Diagonal Checking
- State Restoration
