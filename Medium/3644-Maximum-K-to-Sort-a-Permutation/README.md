# 3644. Maximum K to Sort a Permutation

## Approach

The goal is to determine the maximum bitwise AND value that can be used to sort the permutation.

1. Initialize `ans = -1`, which has all bits set to `1` in its two's-complement representation.
2. Traverse the array and compare each element `nums[i]` with its correct index `i`.
3. If `nums[i] != i`, the element is not in its correct position.
4. For every misplaced element, update `ans` using bitwise AND: `ans &= nums[i]`.
5. Return `Math.max(ans, 0)` to ensure the result is non-negative.

## Algorithm

1. Initialize `ans` to `-1`.
2. Iterate through the array from index `0` to `nums.length - 1`.
3. If `nums[i] != i`, perform:

   ```java
   ans &= nums[i];
   ```

4. After traversing the array, return:

   ```java
   return Math.max(ans, 0);
   ```

## Time Complexity

- The array is traversed once.

Overall Time Complexity: **O(n)**

## Space Complexity

- Only a constant number of variables are used.

Overall Space Complexity: **O(1)**

## Concepts

- Bitwise AND (`&`)
- Permutations
- Array Traversal
- Bit Manipulation
- Conditional Logic
