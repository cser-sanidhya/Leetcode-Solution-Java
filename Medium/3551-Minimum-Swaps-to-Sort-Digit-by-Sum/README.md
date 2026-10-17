# 3551. Minimum Swaps to Sort by Digit Sum

## Approach

The goal is to sort the array by digit sum in ascending order. If two numbers have the same digit sum, sort them by their numerical values in ascending order. We then calculate the minimum swaps required to transform the original array into this sorted order using cycle detection.

## Algorithm

1. Create a 2D array where each element stores the digit sum and the original number.
2. Sort the 2D array:
   - First, by digit sum in ascending order.
   - If digit sums are equal, by the number itself in ascending order.
3. Create a HashMap `indexMap` that stores each number's target index in the sorted array.
4. Create a `visited` array to track elements already processed.
5. Traverse the original array and identify permutation cycles:
   - Skip indices that are already visited.
   - Follow each element to its target index using `indexMap`.
   - Count the number of elements in the cycle.
6. For each cycle of size `k`, add `k - 1` to the total swaps.
7. Return the total number of swaps.

## Time Complexity

- Calculating digit sums: O(n log M), where M is the maximum element.
- Sorting the array: O(n log n).
- Building the index map: O(n).
- Cycle detection: O(n).

Overall Time Complexity: **O(n log n + n log M)**

## Space Complexity

- The 2D array requires O(n) space.
- The HashMap requires O(n) space.
- The visited array requires O(n) space.

Overall Space Complexity: **O(n)**

## Concepts

- Digit Sum Calculation
- Custom Sorting with Comparators
- HashMap
- Permutation Cycles
- Cycle Detection
- Minimum Swaps
