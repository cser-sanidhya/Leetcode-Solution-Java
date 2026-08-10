# 79. Word Search

## Approach
1. Use **Backtracking + DFS (Depth-First Search)** to search for the given word in the 2D board.
2. Start the search from every cell in the board.
3. For each cell, check whether:
   - It is inside the board.
   - It has not already been visited.
   - Its character matches the current character of the word.
4. If the character matches, mark the cell as visited.
5. Recursively search in all four directions:
   - Up
   - Down
   - Left
   - Right
6. If the entire word is found, return `true`.
7. After exploring a cell, **backtrack** by marking it as unvisited so it can be used in another possible path.
8. If no path forms the complete word, return `false`.

The `visited` array prevents the same cell from being used more than once in the same word path.

## Algorithm
1. Get the number of rows and columns:
   - `rows = board.length`
   - `cols = board[0].length`
2. Create a `visited` boolean matrix of the same size as the board.
3. Traverse every cell of the board.
4. For each cell, call:
   - `search(board, word, row, col, 0, visited)`
5. In the `search()` function, check the base conditions:
   - If the position is outside the board → return `false`.
   - If the cell is already visited → return `false`.
   - If the character does not match `word[index]` → return `false`.
6. If `index == word.length() - 1`, the entire word has been found → return `true`.
7. Mark the current cell as visited.
8. Recursively search in four directions:
   - `row - 1, col` → Up
   - `row + 1, col` → Down
   - `row, col - 1` → Left
   - `row, col + 1` → Right
9. After the recursive calls, mark the current cell as unvisited:
   - `visited[row][col] = false`
10. Return whether any of the four directions successfully found the word.

## Time Complexity
Let:
- `R` = number of rows
- `C` = number of columns
- `L` = length of the word

We can start searching from each of the `R × C` cells.

From each cell, we can explore up to 4 directions, and the search can continue for `L` characters.

**Overall Time Complexity:**  
**O(R × C × 4ᴸ)**

Often simplified to:

**O(R × C × 3ᴸ)**

because after the first move, we generally cannot immediately move back to the cell we just visited.

## Space Complexity
- `visited` matrix: **O(R × C)**
- Recursion stack: **O(L)**

**Overall Space Complexity:**  
**O(R × C + L)**

## Concepts
- 2D Arrays
- Backtracking
- Recursion
- Depth-First Search (DFS)
- Matrix Traversal
- Four-Direction Traversal
- Visited Array
- Path Searching
