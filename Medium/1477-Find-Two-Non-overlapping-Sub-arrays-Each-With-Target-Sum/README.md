# 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum

## Approach

1. Use **Prefix Sum + HashMap + Dynamic Programming** to efficiently find two non-overlapping subarrays whose sum equals `target`.
2. Maintain a running `prefixSum` while traversing the array.
3. Store each prefix sum and its index in a HashMap for quick lookup.
4. If `(prefixSum - target)` exists in the map:

   * A subarray with sum equal to `target` has been found.
   * Calculate its length.
5. Use a DP array `dp[i]` where:

   * `dp[i]` stores the minimum length of any valid target-sum subarray found up to index `i`.
6. Whenever a new valid subarray is found:

   * Check if there exists a previous non-overlapping valid subarray using `dp[j]`.
   * Update the answer with the combined length.
7. Update `dp[i]` with the smallest valid subarray length seen so far.
8. Return the minimum combined length of two non-overlapping subarrays.
9. If no such pair exists, return `-1`.

## Algorithm

1. Let `n` be the size of the array.
2. Create a DP array:

   ```java
   int[] dp = new int[n];
   ```
3. Fill `dp` with `Integer.MAX_VALUE`.
4. Create a HashMap:

   ```java
   Map<Integer, Integer> map = new HashMap<>();
   ```
5. Insert:

   ```java
   map.put(0, -1);
   ```

   to handle subarrays starting from index `0`.
6. Initialize:

   ```java
   prefixSum = 0;
   answer = Integer.MAX_VALUE;
   ```
7. Traverse the array:

   * Update `prefixSum`.
   * Copy the previous best value:

     ```java
     dp[i] = dp[i - 1];
     ```
8. Compute:

   ```java
   needed = prefixSum - target;
   ```
9. If `needed` exists in the map:

   * Let:

     ```java
     j = map.get(needed);
     ```
   * Calculate:

     ```java
     length = i - j;
     ```
10. If a previous valid subarray exists before index `j`:

    ```java
    answer = Math.min(answer, dp[j] + length);
    ```
11. Update:

    ```java
    dp[i] = Math.min(dp[i], length);
    ```
12. Store the current prefix sum and index in the map.
13. After traversal:

    * Return `answer` if found.
    * Otherwise return `-1`.

## Time Complexity

Each element is processed once, and all HashMap operations take constant time on average.

**Overall Time Complexity:**
**O(n)**

where:

* `n` = length of the array.

## Space Complexity

* DP array stores one value per index.
* HashMap stores prefix sums and their indices.

**Auxiliary Space Complexity:**
