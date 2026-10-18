# 1569. Number of Ways to Reorder Array to Get Same BST

## Approach

The goal is to count the number of reorderings of the given array that produce the same Binary Search Tree (BST), excluding the original ordering.

We use recursion and combinatorics to calculate the number of valid reorderings.

1. Precompute binomial coefficients using Pascal's Triangle, where `comb[i][j]` represents the number of ways to choose `j` elements from `i` elements.
2. Treat the first element as the root of the BST.
3. Divide the remaining elements into two lists:
   - `left`: elements smaller than the root.
   - `right`: elements greater than the root.
4. Recursively calculate the number of valid reorderings for the left and right subtrees.
5. Calculate the number of ways to interleave the left and right subtree elements while preserving their relative orders. This is given by `comb[n - 1][left.size()]`.
6. Multiply the interleaving count by the valid reorderings of both subtrees, taking modulo \(10^9+7\).
7. Subtract one to exclude the original ordering and return the result modulo \(10^9+7\).

## Algorithm

1. Initialize a two-dimensional array `comb` of size `(n + 1) × (n + 1)`.
2. Fill `comb` using Pascal's Triangle:
   - Set `comb[i][0] = 1` and `comb[i][i] = 1`.
   - For other positions, calculate `comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j]`, modulo `MOD`.
3. Convert the input array into a list and call `dfs(list)`.
4. In `dfs(nums)`:
   - If the list contains at most two elements, return `1`.
   - Select the first element as the root.
   - Partition the remaining elements into left and right lists.
   - Recursively calculate `leftWays` and `rightWays`.
   - Compute the total ways using:

   ```java
   long ways = comb[n - 1][left.size()];
   ways = (ways * leftWays) % MOD;
   ways = (ways * rightWays) % MOD;
   ```

5. Return `(dfs(list) - 1 + MOD) % MOD`.

## Time Complexity

- Precomputing binomial coefficients: \(O(n^2)\).
- Recursive partitioning: \(O(n^2)\) in the worst case, when the BST is highly unbalanced.

Overall Time Complexity: **\(O(n^2)\)**

## Space Complexity

- Binomial coefficient table: \(O(n^2)\).
- Recursive lists and call stack: \(O(n^2)\) in the worst case.

Overall Space Complexity: **\(O(n^2)\)**

## Concepts

- Binary Search Tree (BST)
- Recursion and Divide and Conquer
- Dynamic Programming
- Combinatorics
- Pascal's Triangle
- Modular Arithmetic
