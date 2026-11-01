# 453. Minimum Moves to Equal Array Elements

## Approach

The goal is to make all array elements equal using the minimum number of moves. In each move, we can increment `n - 1` elements by `1`.

Instead of incrementing `n - 1` elements, we can think of it as decrementing the remaining one element by `1`.

To make all elements equal with minimum moves, we reduce every element to the minimum element in the array.

1. Find the minimum element in the array.
2. Calculate the sum of all array elements.
3. The total number of moves required is the difference between the original sum and the sum when all elements become equal to the minimum.
4. Use the formula:

   ```java
   moves = sum - (n * min);
   ```

5. Return the calculated number of moves.

## Algorithm

1. Initialize `min = Integer.MAX_VALUE` and `sum = 0`.
2. Traverse the array:
   - Update the minimum element using `Math.min()`.
   - Add each element to `sum`.
3. Calculate the minimum number of moves:

   ```java
   return sum - nums.length * min;
   ```

4. Return the result.

## Time Complexity

- Finding the minimum element and calculating the sum requires one traversal of the array.

Overall Time Complexity: **O(n)**

## Space Complexity

- Only two variables are used, regardless of the input size.

Overall Space Complexity: **O(1)**

## Concepts

- Array Traversal
- Minimum Element
- Mathematical Observation
- Greedy Approach
- Optimization
