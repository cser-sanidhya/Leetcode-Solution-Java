# 3505. Minimum Operations to Make Elements Within K Subarrays Equal

## Approach

The solution combines a **sliding window with two balanced multisets** and **dynamic programming**.

The goal is to select exactly `k` non-overlapping subarrays of length `x` and minimize the total operations required to make all elements within each selected subarray equal.

For every window of length `x`, the minimum number of operations required to make all its elements equal is achieved by choosing the **median**.

### 1. Sliding Window with Two TreeMaps

Maintain two `TreeMap` structures:

- `low`: Stores the smaller half of the window elements.
- `high`: Stores the larger half of the window elements.

The elements are maintained so that:

- `low` contains the median.
- `low` has either the same number of elements as `high` or one extra element.
- Every element in `low` is less than or equal to every element in `high`.

Additionally, maintain:

- `lowSize` and `highSize`: Number of elements in each half.
- `lowSum` and `highSum`: Sum of elements in each half.

The `add()` and `remove()` methods update the two halves, while `balance()` maintains the required size distribution.

### 2. Calculate the Cost of Each Window

For a window of length `x`, the median is:

```java
int median = low.lastKey();
```

The minimum operations required to make all elements equal to the median are:

```java
cost[i - x + 1] =
    (long) median * lowSize - lowSum
    + highSum - (long) median * highSize;
```

This works because:

- Elements in `low` are increased to the median.
- Elements in `high` are decreased to the median.

The `cost` array stores the minimum cost for every window of length `x`.

### 3. Dynamic Programming

Use two DP arrays:

- `prev[i]`: Minimum cost of selecting `j - 1` non-overlapping subarrays from the first `i` elements.
- `curr[i]`: Minimum cost of selecting `j` non-overlapping subarrays from the first `i` elements.

For every position, there are two choices:

1. Skip the current element:

```java
curr[i] = curr[i - 1];
```

2. Select a subarray of length `x` ending at the current position:

```java
curr[i] = Math.min(
    curr[i],
    prev[i - x] + cost[i - x]
);
```

The second choice ensures that the selected subarrays do not overlap.

After processing each value of `j`, swap the DP arrays.

Finally:

```java
return prev[n];
```

This gives the minimum operations required to select exactly `k` non-overlapping subarrays.

## Algorithm

1. Initialize two `TreeMap` structures, `low` and `high`, to maintain the smaller and larger halves of the sliding window.
2. Maintain the sizes and sums of both halves.
3. Iterate through the array using a sliding window of length `x`.
4. Insert the incoming element using `add()`.
5. Remove the outgoing element using `remove()` when the window exceeds size `x`.
6. Rebalance both halves using `balance()`.
7. Once the window reaches size `x`, calculate its median-based operation cost and store it in the `cost` array.
8. Initialize two DP arrays, `prev` and `curr`.
9. For each number of selected subarrays from `1` to `k`:
   - Skip the current element.
   - Or select a window of length `x` and add its precomputed cost.
10. Swap the DP arrays after each iteration.
11. Return `prev[n]`.

## Time Complexity

**O(n log x + nk)**

- Sliding window: Each insertion and removal takes `O(log x)` using `TreeMap`.
- Calculating window costs: `O(1)` after maintaining the two halves.
- Dynamic programming: `O(nk)`.

Overall: **O(n log x + nk)**.

## Space Complexity

**O(n + x)**

- `cost` array: `O(n)`.
- DP arrays: `O(n)`.
- Two `TreeMap` structures: `O(x)`.

Overall: **O(n + x)**.

## Concepts

- Sliding Window
- Two Balanced Multisets
- TreeMap
- Median
- Prefix Sums
- Dynamic Programming
- Greedy Optimization
- Non-overlapping Subarrays
