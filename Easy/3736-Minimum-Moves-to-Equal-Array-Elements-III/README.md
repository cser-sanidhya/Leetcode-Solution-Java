# 3736. Minimum Moves to Equal Array Elements

## Approach

The goal is to make all array elements equal using the minimum number of moves. In each move, we can increment `n - 1` elements by `1`.

Instead of incrementing `n - 1` elements, we can consider it equivalent to decrementing the remaining element by `1`.

To minimize the number of moves, we make every element equal to the maximum element in the array.

1. Find the maximum element in the array.
2. Calculate the sum of all array elements.
3. Calculate the difference between the sum required to make every element equal to the maximum and the current sum.
4. Use the formula:

   ```java
   moves = (max * n) - sum;
   ```

5. Return the calculated number of moves.

## Algorithm

1. Initialize `max = 0` and `sum = 0`.
2. Traverse the array:
   - Update the maximum element using `Math.max()`.
   - Add each element to `sum`.
3. Calculate the minimum moves:

   ```java
   return max * nums.length - sum;
   ```

4. Return the result.

## Time Complexity

- Finding the maximum element and calculating the sum requires one traversal of the array.

Overall Time Complexity: **O(n)**

## Space Complexity

- Only two variables are used.

Overall Space Complexity: **O(1)**

## Concepts

- Array Traversal
- Maximum Element
- Mathematical Observation
- Greedy Approach
- Sum Calculation
