# 3963. Create Grid For Exactly One Path

## Approach

The goal is to create an `m × n` character grid following the required pattern.

1. Create a 2D character array of size `m × n`.
2. Fill every row with `'#'`.
3. Fill the first row entirely with `'.'`.
4. Set the last column of every row to `'.'`.
5. Convert each row of the character grid into a string.
6. Store the strings in the result array and return it.

## Algorithm

1. Initialize `char[][] grid = new char[m][n]`.
2. Fill each row with `'#'` using `Arrays.fill()`.
3. Fill the first row with `'.'`:

   ```java
   Arrays.fill(grid[0], '.');
   ```

4. Traverse all rows and set the last column to `'.'`:

   ```java
   grid[i][n - 1] = '.';
   ```

5. Create a `String[] ans` of size `m`.
6. Convert each character row into a string using `new String(grid[i])`.
7. Return `ans`.

## Time Complexity

- Initializing the grid takes O(m × n).
- Filling the first row and last column takes O(n + m).
- Converting the grid rows into strings takes O(m × n).

Overall Time Complexity: **O(m × n)**

## Space Complexity

- The character grid requires O(m × n) space.
- The result array stores `m` strings, containing a total of `m × n` characters.

Overall Space Complexity: **O(m × n)**

## Concepts

- Two-Dimensional Arrays
- Character Grid Initialization
- `Arrays.fill()`
- String Conversion
- Matrix Traversal
