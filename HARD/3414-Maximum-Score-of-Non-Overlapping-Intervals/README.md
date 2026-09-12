# 3414. Maximum Score of Non-Overlapping Intervals

## Approach
1. Each interval contains:
   - Start time
   - End time
   - Weight (score)
   - Original index
2. We need to select **at most 4 non-overlapping intervals** such that the total weight is maximized.
3. First, sort all intervals by their ending time.
4. For every interval, find the latest non-overlapping interval using **Binary Search**.
   - Store this index in the `prev` array.
5. Use **Dynamic Programming**:
   - `dp[k][i]` = maximum weight obtainable using the first `i` intervals while selecting at most `k` intervals.
6. For every interval, we have two choices:
   - Skip the interval.
   - Take the interval and add its weight to the best solution ending before it starts.
7. Maintain a `take` table to reconstruct which intervals were selected.
8. Backtrack through the DP table to recover the chosen interval indices.
9. Sort the resulting indices and return them.

This is a variation of the **Weighted Interval Scheduling** problem with an additional constraint of selecting at most **4 intervals**.

## Algorithm
1. Convert each interval into:

   `[start, end, weight, originalIndex]`

2. Sort intervals by:
   - End time
   - Start time (for ties)
3. For each interval:
   - Use Binary Search to find the last interval whose end time is strictly less than the current interval's start time.
   - Store it in `prev[i]`.
4. Create:
   - `dp[5][n + 1]`
   - `take[5][n + 1]`
5. For each:
   - `k = 1` to `4`
   - `i = 1` to `n`
6. Option 1:
   - Skip interval:
     - `dp[k][i] = dp[k][i - 1]`
7. Option 2:
   - Take interval:
     - `candidate = weight + dp[k - 1][prev + 1]`
8. If candidate is better:
   - Update DP value.
   - Mark `take[k][i] = true`.
9. Reconstruct the answer:
   - Start from `(k = 4, i = n)`
   - Follow the `take` table.
10. Collect selected original indices.
11. Sort indices.
12. Return the result.

## Time Complexity

Let:
- `n` = number of intervals.

### Sorting
- Sorting intervals:

**O(n log n)**

### Building Previous Compatible Intervals
- Binary search for each interval:

**O(n log n)**

### Dynamic Programming
- 4 DP layers.
- Each layer processes all intervals.

**O(4 × n) = O(n)**

### Reconstruction
- At most 4 intervals selected.

**O(1)**

### Total

**O(n log n)**

## Space Complexity

### Interval Storage
- `arr[n][4]`

### Previous Array
- `prev[n]`

### DP Table
- `dp[5][n + 1]`

### Take Table
- `take[5][n + 1]`

Overall:

**O(n)**

## Concepts
- Dynamic Programming
- Weighted Interval Scheduling
- Binary Search
- Sorting
- DP Reconstruction
- Non-Overlapping Intervals
- Optimization
- Greedy + DP
- Interval Scheduling
