# 835. Image Overlap

## Approach

1. Use **Brute Force Translation Simulation** to check every possible way of shifting one image over the other.
2. Let `dr` represent the row shift and `dc` represent the column shift.
3. Since the image size is `n × n`, valid shifts range from:

   * `-(n - 1)` to `(n - 1)` for rows.
   * `-(n - 1)` to `(n - 1)` for columns.
4. For each possible translation:

   * Traverse every cell of `img1`.
   * Compute its shifted position in `img2`.
5. If the shifted position lies inside the image boundaries:

   * Check whether both corresponding cells contain `1`.
   * If yes, increase the overlap count.
6. After checking all cells for the current shift:

   * Update the maximum overlap found so far.
7. Return the largest overlap among all possible translations.

## Algorithm

1. Let `n` be the size of the image.
2. Initialize:

   * `maxOverlap = 0`
3. Iterate through all possible row shifts:

   ```java
   for (int dr = -(n - 1); dr <= n - 1; dr++)
   ```
4. Iterate through all possible column shifts:

   ```java
   for (int dc = -(n - 1); dc <= n - 1; dc++)
   ```
5. For each translation:

   * Initialize `overlap = 0`.
6. Traverse every cell `(r, c)` in `img1`.
7. Compute the shifted coordinates:

   ```java
   int r2 = r + dr;
   int c2 = c + dc;
   ```
8. If `(r2, c2)` is inside the bounds of `img2`:

   * Check:

     ```java
     img1[r][c] == 1 && img2[r2][c2] == 1
     ```
   * If true, increment `overlap`.
9. After processing all cells:

   * Update:

     ```java
     maxOverlap = Math.max(maxOverlap, overlap);
     ```
10. After trying all translations, return `maxOverlap`.

## Time Complexity

There are:

* `(2n - 1)` possible row shifts.
* `(2n - 1)` possible column shifts.
* For each shift, all `n²` cells are checked.

**Overall Time Complexity:**
**O(n⁴)**

where:

* `n` = dimension of the image.

## Space Complexity

Only a few integer variables are used.

**Auxiliary Space Complexity:**
**O(1)**

**Overall Space Complexity:**
**O(1)**

## Concepts

* Matrix
* Brute Force
* Simulation
* Translation / Shifting
* Nested Loops
* Coordinate Manipulation
* Boundary Checking
