# 1658. Minimum Operations to Reduce X to Zero

## Approach

1. Instead of removing elements from the left or right, think in reverse.
2. Let:

   ```java
   totalSum = sum(nums)
   ```
3. If we remove elements whose sum equals `x`, the remaining middle subarray must have sum:

   ```java
   target = totalSum - x
   ```
4. Therefore, the problem becomes:

   * Find the **longest subarray** whose sum equals `target`.
5. Use the **Sliding Window** technique because all elements are positive.
6. Expand the window by moving the right pointer.
7. If the current window sum exceeds `target`:

   * Shrink the window from the left.
8. Whenever the window sum becomes equal to `target`:

   * Update the maximum subarray length found.
9. The minimum operations required will be:

   ```java
   nums.length - maxLength
   ```
10. If no such subarray exists, return `-1`.

## Algorithm

1. Compute:

   ```java
   totalSum = sum(nums)
   ```
2. Calculate:

   ```java
   target = totalSum - x
   ```
3. If:

   ```java
   target < 0
   ```

   return `-1`.
4. If:

   ```java
   target == 0
   ```

   return `nums.length`.
5. Initialize:

   ```java
   left = 0
   currentSum = 0
   maxLength = -1
   ```
6. Traverse the array using the right pointer.
7. Add:

   ```java
   nums[right]
   ```

   to `currentSum`.
8. While:

   ```java
   currentSum > target
   ```

   remove elements from the left side of the window.
9. If:

   ```java
   currentSum == target
   ```

   update:

   ```java
   maxLength = Math.max(maxLength, right - left + 1)
   ```
10. After traversal:

    * If `maxLength == -1`, return `-1`.
    * Otherwise return:

      ```java
      nums.length - maxLength
      ```

## Time Complexity

Each element enters and leaves the sliding window at most once.

**Overall Time Complexity:**
**O(n)**

where:

* `n` = length of the array.

## Space Complexity

Only a few variables are used.

**Auxiliary Space Complexity:**
**O(1)**

**Overall Space Complexity:**
**O(1)**

## Concepts

* Arrays
* Sliding Window
* Two Pointers
* Longest Subarray
* Prefix Sum Observation
* Greedy Window Expansion
* Optimization
