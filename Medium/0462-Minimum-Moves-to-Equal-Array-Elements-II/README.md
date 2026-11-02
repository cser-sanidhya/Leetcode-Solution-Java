# 462. Minimum Moves to Equal Array Elements II

## Approach

The goal is to make all array elements equal using the minimum number of moves. In each move, we can increment or decrement any element by `1`.

The optimal value to make all elements equal is the **median** of the sorted array because the median minimizes the sum of absolute differences.

1. Sort the array in ascending order.
2. Find the median element at index `nums.length / 2`.
3. Traverse the array and calculate the absolute difference between each element and the median.
4. Add all differences to calculate the total number of moves.
5. Return the total moves.

## Algorithm

1. Sort the array using `Arrays.sort(nums)`.
2. Find the median:

   ```java
   int median = nums[nums.length / 2];
   ```

3. Initialize `moves = 0`.
4. Traverse the array:
   - Calculate `Math.abs(num - median)`.
   - Add the difference to `moves`.
5. Return `moves`.

## Time Complexity

- Sorting the array takes O(n log n).
- Finding the median takes O(1).
- Calculating the total absolute difference takes O(n).

Overall Time Complexity: **O(n log n)**

## Space Complexity

- The algorithm uses a constant number of extra variables.
- Sorting may require additional auxiliary space depending on the implementation.

Overall Auxiliary Space Complexity: **O(1)**, excluding sorting-related auxiliary space.

## Concepts

- Array Sorting
- Median
- Greedy Approach
- Mathematical Optimization
- Absolute Difference
