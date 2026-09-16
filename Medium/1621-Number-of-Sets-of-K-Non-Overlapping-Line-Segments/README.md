# 1621. Number of Sets of K Non-Overlapping Line Segments

## Approach

1. Use **Dynamic Programming** to count the number of ways to choose exactly `k` non-overlapping line segments among `n` points.
2. Let `dp[j][i]` represent the number of ways to draw exactly `j` segments using the first `i + 1` points.
3. For `0` segments:

   * There is exactly one valid way regardless of the number of points.
   * Therefore:

     ```java
     dp[0][i] = 1
     ```
4. For each segment count `j` from `1` to `k`:

   * Maintain a running prefix sum of previous states.
5. The prefix sum stores all possible starting positions for the current segment.
6. For each point `i`:

   * Update the running sum using:

     ```java
     sum += dp[j - 1][i - 1]
     ```
   * Add the number of ways that end before the current point.
7. Compute:

   ```java
   dp[j][i] = dp[j][i - 1] + sum
   ```

   where:

   * `dp[j][i - 1]` = ways without using point `i`
   * `sum` = ways where a segment ends at point `i`
8. Apply modulo `10^9 + 7` at every step.
9. Return `dp[k][n - 1]`.

## Algorithm

1. Create a DP table:

   ```java
   long[][] dp = new long[k + 1][n];
   ```
2. Initialize the base case:

   ```java
   dp[0][i] = 1
   ```

   for all points.
3. Iterate for every segment count:

   ```java
   for (int j = 1; j <= k; j++)
   ```
4. Initialize:

   ```java
   long sum = 0;
   ```
5. Traverse points from left to right:

   ```java
   for (int i = 1; i < n; i++)
   ```
6. Update prefix contribution:

   ```java
   sum = (sum + dp[j - 1][i - 1]) % MOD;
   ```
7. Calculate current state:

   ```java
   dp[j][i] = (dp[j][i - 1] + sum) % MOD;
   ```
8. Continue until all states are filled.
9. Return:

   ```java
   dp[k][n - 1]
   ```

## Time Complexity

* Outer loop runs `k` times.
* Inner loop runs `n` times.

**Overall Time Complexity:**
**O(n × k)**

where:

* `n` = number of points.
* `k` = number of segments.

## Space Complexity

The DP table stores:

```java
(k + 1) × n
```

states.

**Auxiliary Space Complexity:**
**O(n × k)**

**Overall Space Complexity:**
**O(n × k)**

## Concepts

* Dynamic Programming (DP)
* Prefix Sum
* Combinatorics
* Counting Problems
* Non-Overlapping Segments
* Modular Arithmetic
* Optimization
