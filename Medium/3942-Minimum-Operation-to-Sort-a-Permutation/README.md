# 3942. Minimum Operations to Sort a Circular Array

## Approach

The goal is to determine the minimum number of operations required to make the circular array sorted in non-decreasing order, using the position of the element `0` as the starting point.

We check two possible traversal directions: clockwise and counterclockwise.

1. Find the index of the first occurrence of `0`.
2. Check the array in both directions:
   - Clockwise (`step = 1`).
   - Counterclockwise (`step = -1`).
3. Use modular arithmetic to calculate the previous and current indices while traversing the circular array.
4. If any adjacent pair violates non-decreasing order, mark that direction as invalid.
5. If a direction is valid, calculate the possible operation counts based on the position of `0` and update the minimum answer.
6. If neither direction is valid, return `-1`; otherwise, return the minimum number of operations.

## Algorithm

1. Initialize `n = nums.length` and find the index `zero` where `nums[zero] == 0`.
2. Initialize `ans = Integer.MAX_VALUE`.
3. Iterate through `step` values `1` and `-1`.
4. For each direction:
   - Set `valid = true`.
   - Traverse the circular array from the position of `0`.
   - Calculate indices using:

   ```java
   int prev = (zero + (i - 1) * step + n) % n;
   int curr = (zero + i * step + n) % n;
   ```

   - If `nums[prev] > nums[curr]`, mark the direction invalid and stop checking it.
5. If the direction is valid, update `ans`:
   - For `step == 1`, consider `zero` and `n - zero + 2`.
   - For `step == -1`, consider `zero + 2` and `n - zero`.
6. Return `-1` if `ans` remains `Integer.MAX_VALUE`; otherwise, return `ans`.

## Time Complexity

- Finding the zero index takes O(n).
- Checking both traversal directions takes O(n) overall.

Overall Time Complexity: **O(n)**

## Space Complexity

- Only a constant number of variables are used, excluding the fixed-size direction array...

Overall Space Complexity: **O(1)**

## Concepts

- Circular Arrays
- Modular Arithmetic
- Array Traversal
- Greedy Approach
- Minimum Value Tracking
- Conditional Validation
